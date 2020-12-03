package com.icecreamhead.adventofcode.twenty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class Swarm {
  private final List<Particle> particles;

  public Swarm(List<Particle> particles) {
    this.particles = particles;
  }

  public List<Particle> getParticles() {
    return particles;
  }

  public int particleCount() {
    return particles.size();
  }

  public int minRelativeDistance() {
    int dist = Integer.MAX_VALUE;
    for (int i = 0; i < particles.size(); i++) {
      for (int j = i + 1; j < particles.size(); j++) {
        int rel = Particle.manhattan(particles.get(i).getP(), particles.get(j).getP());
        if (rel < dist) {
          dist = rel;
        }
      }
    }
    return dist;
  }

  public int remainClosest() {
    int particleIdx = -1;
    int minAccel = Integer.MAX_VALUE;

    for (int i = 0; i < particles.size(); i++) {
      Particle p = particles.get(i);
      if (p.acceleration() < minAccel) {
        particleIdx = i;
        minAccel = p.acceleration();
      }
    }

    return particleIdx;
  }

  public Swarm nextTick() {
    List<Particle> next = particles
        .stream()
        .map(Particle::next)
        .collect(Collectors.toList());

    for (int i = 0; i < next.size(); i++) {
      Coord first = next.get(i).getP();
      for (int j = i + 1; j < next.size(); j++) {
        if (first.equals(next.get(j).getP())) {
          deleteAllAt(first, next);
        }
      }
    }

    return new Swarm(next);
  }

  private static void deleteAllAt(Coord c, List<Particle> particles) {
    List<Particle> toRemove = new ArrayList<>();
    for (Particle p : particles) {
      if (p.getP().equals(c)) {
        toRemove.add(p);
      }
    }
    System.out.println("Removing " + toRemove.size() + " particles at " + c);
    particles.removeAll(toRemove);
  }

  public void print() {
    System.out.println("Particles (min distance=" + minRelativeDistance() + ")");
//    for (int i = 0; i < particles.size(); i++) {
//      System.out.println(i + ": "+particles.get(i));
//    }
  }
}
