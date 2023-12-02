package com.icecreamhead.adventofcode.q1;

import com.icecreamhead.adventofcode.util.InputLoader;
import java.util.List;
import java.util.function.Function;

public class Main {

  /* Part 2 */
  public static void main(String[] args) {

    List<String> calibrationLines = InputLoader.loadLines("q1/puzzle.txt");

    long total = calibrationLines.stream()
        .peek(System.out::println)
        .map(replaceNumberWords)
        .peek(System.out::println)
        .mapToLong(line -> {
          String digits = line.replaceAll("[^\\d]", "");

          return Long.parseLong(digits.charAt(0) + digits.substring(digits.length() - 1));
        })
        .peek(System.out::println)
        .sum();

    System.out.println(total);

  }
  /* Part 1 */
  /*public static void main(String[] args) {
    List<String> calibrationLines = InputLoader.loadLines("q1/puzzle.txt");

    long total = calibrationLines.stream()
        .mapToLong(line -> {
          String digits = line.replaceAll("[^\\d]", "");

          return Long.parseLong(digits.charAt(0) + digits.substring(digits.length() - 1));
        })
        .sum();

    System.out.println(total);
  }*/

  private static final String[] NUMBERS = new String[]{
      null, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
  };
  private final static Function<String, String> replaceNumberWords = line -> {
    int firstDigitIdx = Integer.MAX_VALUE, lastDigitIdx = Integer.MIN_VALUE;
    int firstNumber = -1, lastNumber = -1;
    int firstNumberIndex = Integer.MAX_VALUE, lastNumberIndex = Integer.MIN_VALUE;
    for (int i = 1; i < 10; i++) {
      int idx1, idx2;
      if ((idx1 = line.indexOf(NUMBERS[i])) != -1 && idx1 < firstNumberIndex) {
        firstNumberIndex = idx1;
        firstNumber = i;
      }
      if ((idx2 = line.lastIndexOf(NUMBERS[i])) != -1 && idx2 > lastNumberIndex) {
        lastNumberIndex = idx2;
        lastNumber = i;
      }
      {
        int idx;
        if ((idx = line.indexOf(String.valueOf(i))) != -1 && idx < firstDigitIdx) firstDigitIdx = idx;
      }
      {
        int idx;
        if ((idx = line.lastIndexOf(String.valueOf(i))) != -1 && idx > lastDigitIdx) lastDigitIdx = idx;
      }
    }

    if (firstNumber != -1 && firstNumberIndex < firstDigitIdx) line = line.replace(NUMBERS[firstNumber], String.valueOf(firstNumber));
    if (lastNumber != -1 && lastNumberIndex > lastDigitIdx) line = line.replace(NUMBERS[lastNumber], String.valueOf(lastNumber));
    return line;
  };
}