package com.icecreamhead.adventofcode.eight;

import java.util.HashMap;
import java.util.Map;

public class Memory {

  private final Map<String, Integer> registers = new HashMap<>();
  private int allTimeMax = Integer.MIN_VALUE;

  public void consume(String instr) {
    String[] instructionBits = instr.split(" if ");

    String[] conditionBits = instructionBits[1].split(" ");
    String conditionRegister = conditionBits[0];
    String conditionOperator = conditionBits[1];
    int conditionOperand = Integer.valueOf(conditionBits[2]);
    if (eval(conditionOperator, conditionRegister, conditionOperand)) {
      String[] operationBits = instructionBits[0].split(" ");
      String operationRegister = operationBits[0];
      String operationOperator = operationBits[1];
      int operationOperand = Integer.valueOf(operationBits[2]);

      eval(operationOperator, operationRegister, operationOperand);
    }
  }

  public int max() {
    return registers.values().stream().mapToInt(x -> x).max().getAsInt();
  }

  public int allTimeMax() {
    return allTimeMax;
  }

  private int read(String register) {
    return registers.getOrDefault(register, 0);
  }

  private boolean set(String register, int val) {
    registers.put(register, val);
    if (val > allTimeMax) {
      allTimeMax = val;
    }
    return true;
  }

  private boolean eval(String operator, String register, int operand) {
    switch (operator) {
      case "!=":
        return read(register) != operand;
      case "==":
        return read(register) == operand;
      case "<=":
        return read(register) <= operand;
      case ">=":
        return read(register) >= operand;
      case ">":
        return read(register) > operand;
      case "<":
        return read(register) < operand;
      case "inc":
        return set(register, read(register) + operand);
      case "dec":
        return set(register, read(register) - operand);
    }
    throw new IllegalArgumentException("Unexpected operator: " + operator);
  }
}
