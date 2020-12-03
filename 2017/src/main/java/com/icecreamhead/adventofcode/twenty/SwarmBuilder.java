package com.icecreamhead.adventofcode.twenty;

import com.icecreamhead.adventofcode.util.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class SwarmBuilder {

  public Swarm build(String input) {
    List<Particle> particles = Converter.multilineStringToStringList(input)
        .stream()
        .map(Particle::parse)
        .collect(Collectors.toList());

    return new Swarm(particles);
  }

}
