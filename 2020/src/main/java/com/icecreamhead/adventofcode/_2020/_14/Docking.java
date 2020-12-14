package com.icecreamhead.adventofcode._2020._14;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Docking {

  private static final List<String> DATA = InputLoader.loadLines("_14/puzzle-input.txt");

  private static final Map<Long, Long> MEM = new HashMap<>();

  private static String bitmask;

  public static void main(String[] args) {

    for (String line : DATA) {
      if (line.startsWith("mask")) {
        setMask(line);
      } else {
        setAddress(line);
      }
    }

    System.out.println(MEM.values().stream().mapToLong(l -> l).sum());

  }

  private static void setAddress(String line) {
    String[] parts = line.split("=");

//    String val = longToBinary36(Long.parseLong(parts[1].strip()));
    long val = Long.parseLong(parts[1].strip());

    System.out.println(" val: " + val);

//    String maskedValue = applyBitmask(val, bitmask);
//    System.out.println(" out: " + maskedValue);

    int idx = Integer.parseInt(parts[0].strip().replace("mem[", "").replace("]",""));
    String binaryIdx = longToBinary36(idx);
    System.out.println("addr: " + binaryIdx);
    String maskedIdx = applyBitmask(binaryIdx, bitmask);

    setAddress(maskedIdx, val);

//    long out = Long.parseLong(maskedValue, 2);
//    System.out.println("   " + idx + ": " + out);
//    mem[idx] = out;
  }

  private static void setAddress(String address, long value) {
    System.out.println(address + " => " + value);
    if (address.contains("X")) {
      setAddress(address.replaceFirst("X", "1"), value);
      setAddress(address.replaceFirst("X", "0"), value);
    } else {
      MEM.put(Long.parseLong(address, 2), value);
    }
  }

  private static String applyBitmask(String input, String mask) {
    StringBuilder bob = new StringBuilder();
    for (int i = 0; i < 36; i++) {
      switch (mask.charAt(i)) {
        case 'X' -> bob.append('X');
        case '1' -> bob.append('1');
        case '0' -> bob.append(input.charAt(i));
      }
    }
    return bob.toString();
  }

  private static void setMask(String line) {
    bitmask = line.split("=")[1].strip();
    System.out.println("mask: " + bitmask);
  }

  private static String longToBinary36(long l) {
    StringBuilder out = new StringBuilder(Long.toBinaryString(l));
    int len = out.length();
    for (int i = 0; i < 36 - len; i++) {
      out.insert(0, '0');
    }
    return out.toString();
  }

}
