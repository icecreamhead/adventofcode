package com.icecreamhead.adventofcode.q20;

import com.icecreamhead.adventofcode.q20.PulsePropagation.Msg;
import java.util.ArrayDeque;
import java.util.List;

public class Output extends Module {

  public Output(String name) {
    super(name, List.of());
  }

  @Override
  void signal(String source, Pulse pulse, ArrayDeque<Msg> queue, long press) {
//    System.out.println(getClass().getSimpleName() + " " + source + " -" + pulse.name().toLowerCase() + "-> " + name + " (" + press + ")");
  }

}
