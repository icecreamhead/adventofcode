package com.icecreamhead.adventofcode.eighteen.commands;

public class Result {

  private final int next;
  private final Long out;

  private Result(int next, Long out) {
    this.next = next;
    this.out = out;
  }

  public Long output() {
    return out;
  }

  public int next() {
    return next;
  }

  public boolean complete() {
    return out != null;
  }

  public static Result ok(int next) {
    return new Result(next, null);
  }

  static Result exit(Long output) {
    return new Result(-1, output);
  }
}
