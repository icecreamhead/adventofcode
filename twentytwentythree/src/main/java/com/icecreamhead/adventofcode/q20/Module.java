package com.icecreamhead.adventofcode.q20;

import com.icecreamhead.adventofcode.q20.PulsePropagation.Msg;
import java.util.ArrayDeque;
import java.util.List;

abstract class Module {

  protected final String name;
  protected final List<String> receivers;

  Module(String name, List<String> receivers) {
    this.name = name;
    this.receivers = receivers;
  }

  abstract void signal(String source, Pulse pulse, ArrayDeque<Msg> queue, long press);

  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{name='" + name + "', receivers=" + receivers + '}';
  }
}
