package com.icecreamhead.adventofcode.twenty;

import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticleTest extends TestCase {

  public void testParse() throws Exception {
    assertThat(Particle.parse("p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>"))
        .isEqualToComparingFieldByFieldRecursively(new Particle(new Coord(3, 0, 0), new Coord(2, 0, 0), new Coord(-1, 0, 0)));
  }
}