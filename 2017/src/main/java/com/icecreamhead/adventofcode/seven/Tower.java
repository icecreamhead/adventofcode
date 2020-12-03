package com.icecreamhead.adventofcode.seven;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tower {

  private final String name;
  private final int weight;
  private final Map<String, Tower> towers = new HashMap<>();

  public Tower(String name, int weight) {
    this.name = name;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public int getWeight() {
    return weight;
  }

  public Set<String> getSubtowerNames() {
    return towers.keySet();
  }

  public void addSubTower(Tower tower) {
    towers.put(tower.name, tower);
  }

  public Tower removeSubTower(String name) {
    return towers.remove(name);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Tower tower = (Tower) o;

    return name.equals(tower.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
