package com.icecreamhead.adventofcode.twenty;

public class SwarmRunner {

  private final SwarmBuilder builder = new SwarmBuilder();

  int remaining(String input) {
    Swarm swarm = builder.build(input);
//    swarm.print();
    int last;
    int increase = 0;

    do {
      last = swarm.minRelativeDistance();

      swarm = swarm.nextTick();
      swarm.print();

      if (swarm.minRelativeDistance() > last) {
        increase++;
      } else {
        increase = 0;
      }

//      System.out.println();
    }
    while (swarm.particleCount() > 1 && increase < 2);

    return swarm.particleCount();
  }

}
