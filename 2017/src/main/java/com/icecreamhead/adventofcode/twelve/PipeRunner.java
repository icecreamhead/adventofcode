package com.icecreamhead.adventofcode.twelve;

public class PipeRunner {

  private final Pipes pipes = new Pipes();

  public int counter(String input) {
    for (String s : input.split("\n")) {
      pipes.add(s);
    }
    return pipes.count();
  }

  public int groups(String input) {
    for (String s : input.split("\n")) {
      pipes.add(s);
    }
    return pipes.groups();
  }
}
