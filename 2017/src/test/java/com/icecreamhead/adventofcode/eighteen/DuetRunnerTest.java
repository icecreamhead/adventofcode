package com.icecreamhead.adventofcode.eighteen;

import com.icecreamhead.adventofcode.util.Converter;

import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class DuetRunnerTest extends TestCase {

  private final DuetRunner runner = new DuetRunner();

  private static final String TEST_INPUT =
      "set a 1\n" +
          "add a 2\n" +
          "mul a a\n" +
          "mod a 5\n" +
          "snd a\n" +
          "set a 0\n" +
          "rcv a\n" +
          "jgz a -1\n" +
          "set a 1\n" +
          "jgz a -2";

  public void testPart1() throws Exception {
    assertThat(runner.run(Converter.multilineStringToStringList(TEST_INPUT))).isEqualTo(4);
  }

  public void testPart1b() throws Exception {
    assertThat(runner.run(Converter.multilineStringToStringList("set a 2\n" +
        "set b 3\n" +
        "add b 2\n" +
        "mul a b\n" +
        "mul b a\n" +
        "snd b\n" +
        "mod b a\n" +
        "rcv b\n" +
        "add b 1\n" +
        "jgz a -3"))).isEqualTo(50);
  }

  public void testPart1Solution() throws Exception {
    System.out.println("Solution 1: " + runner.run(Converter.multilineStringToStringList(PUZZLE_INPUT)));
  }

  private static final String PUZZLE_INPUT =
      "set i 31\n" +
          "set a 1\n" +
          "mul p 17\n" +
          "jgz p p\n" +
          "mul a 2\n" +
          "add i -1\n" +
          "jgz i -2\n" +
          "add a -1\n" +
          "set i 127\n" +
          "set p 316\n" +
          "mul p 8505\n" +
          "mod p a\n" +
          "mul p 129749\n" +
          "add p 12345\n" +
          "mod p a\n" +
          "set b p\n" +
          "mod b 10000\n" +
          "snd b\n" +
          "add i -1\n" +
          "jgz i -9\n" +
          "jgz a 3\n" +
          "rcv b\n" +
          "jgz b -1\n" +
          "set f 0\n" +
          "set i 126\n" +
          "rcv a\n" +
          "rcv b\n" +
          "set p a\n" +
          "mul p -1\n" +
          "add p b\n" +
          "jgz p 4\n" +
          "snd a\n" +
          "set a b\n" +
          "jgz 1 3\n" +
          "snd b\n" +
          "set f 1\n" +
          "add i -1\n" +
          "jgz i -11\n" +
          "snd a\n" +
          "jgz f -16\n" +
          "jgz a -19";
}