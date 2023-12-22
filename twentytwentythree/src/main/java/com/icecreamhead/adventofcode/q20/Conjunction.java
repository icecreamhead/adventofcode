package com.icecreamhead.adventofcode.q20;

import static com.icecreamhead.adventofcode.q20.Pulse.HIGH;
import static com.icecreamhead.adventofcode.q20.Pulse.LOW;

import com.icecreamhead.adventofcode.q20.PulsePropagation.Msg;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Conjunction extends Module {

  private final HashMap<String, Pulse> receiverPrevPulse = new HashMap<>();

  private final HashSet<String> loggedHigh = new HashSet<>();

  public Conjunction(String name, List<String> receivers) {
    super(name, receivers);
  }

  @Override
  void signal(String source, Pulse pulse, ArrayDeque<Msg> queue, long press) {
    receiverPrevPulse.put(source, pulse);

    if (name.equals("gq") && List.of("xj", "qs", "kz", "km").contains(source) && pulse == HIGH && press < 5000)
      System.out.println(getClass().getSimpleName() + " " + source + " -" + pulse.name().toLowerCase() + "-> " + name + " (" + press + ")");

    receivers.forEach(r -> {
      queue.add(new Msg(name, r, receiverPrevPulse.values().stream().allMatch(HIGH::equals) ? LOW : HIGH));
    });
  }

  public void init(String src) {
    receiverPrevPulse.put(src, LOW);
  }
}
