package com.icecreamhead.adventofcode.q20;

import com.icecreamhead.adventofcode.q20.PulsePropagation.Msg;
import java.util.ArrayDeque;
import java.util.List;

public class Broadcaster extends Module {

  public Broadcaster(String name, List<String> receivers) {
    super(name, receivers);
  }

  @Override
  void signal(String source, Pulse pulse, ArrayDeque<Msg> queue, long press) {
//    System.out.println(getClass().getSimpleName() + " " + source + " -" + pulse.name().toLowerCase() + "-> " + name + "(" + press + ")");
    receivers.forEach(r -> queue.add(new Msg(name, r, pulse)));
  }
}
