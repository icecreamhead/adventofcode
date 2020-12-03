package com.icecreamhead.adventofcode.twenty;

import junit.framework.TestCase;

import static com.icecreamhead.adventofcode.twenty.Input.PUZZLE_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

public class SwarmTest extends TestCase {

  private final SwarmBuilder builder = new SwarmBuilder();
  private final SwarmRunner runner = new SwarmRunner();

  private static final String PART_1_INPUT =
      "p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>\n" +
          "p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0>";

  private static final String PART_2_INPUT =
      "p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>    \n" +
          "p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>\n" +
          "p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>\n" +
          "p=<0,0,-1>, v=< 0,0,-1>, a=< 0,0,0>\n" +
          "p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>";

  public void testPart1() throws Exception {
    Swarm swarm = builder.build(PART_1_INPUT);

    assertThat(swarm.remainClosest()).isEqualTo(0);
  }

  public void testPart2() throws Exception {
    assertThat(runner.remaining(PART_2_INPUT)).isEqualTo(2);
  }

  public void testPart1Solution() throws Exception {
    Swarm swarm = builder.build(PUZZLE_INPUT);

    System.out.println(swarm.remainClosest());
  }

  public void testPart2Solution() throws Exception {
    System.out.println(runner.remaining(PUZZLE_INPUT));
  }
}