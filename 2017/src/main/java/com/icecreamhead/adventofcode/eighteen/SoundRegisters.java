package com.icecreamhead.adventofcode.eighteen;

import java.util.HashMap;
import java.util.Map;

public class SoundRegisters {

  private final Map<String, Long> registers = new HashMap<>();
  private long sound = 0;

  public void set(String dest, String operand) {
    long val = eval(operand);
    System.out.println(dest + " := " + operand + "(" + val + ")");
    registers.put(dest, val);
  }

  public void mod(String dest, String operand) {
    long val = eval(operand);
    registers.put(dest, get(dest) % val);
  }

  public void multiply(String dest, String operand) {
    long val = eval(operand);
    registers.put(dest, get(dest) * val);
  }

  public void add(String dest, String operand) {
    long val = eval(operand);
    registers.put(dest, get(dest) + val);
  }

  long get(String reg) {
    return registers.getOrDefault(reg, 0L);
  }

  public void sound(String x) {
    System.out.println("# " + eval(x));
    sound = eval(x);
  }

  public Long recover(String x) {
    System.out.println("Recovering " + x + "=" + get(x) + " => " + (get(x) != 0 ? sound : null));
    return get(x) != 0 ? sound : null;
  }

  private long eval(String operand) {
    try {
      return Long.parseLong(operand);
    } catch (Exception e) {
      return get(operand);
    }
  }

  public int offset(String x, String y) {
    if (get(x) > 0) {
      return (int) eval(y);
    }
    return 1;
  }
}
