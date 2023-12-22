package com.icecreamhead.adventofcode.q20;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PulsePropagation {

  long part1(List<String> input) {

    Map<String, Module> modulesByName = input.stream()
        .map(module -> {
          if (module.contains("rx")) {
            System.out.println(module);
          }
          String[] parts = module.split("->");
          String source = parts[0].strip();
          List<String> dests = Arrays.asList(parts[1].strip().split(", "));
          if (source.startsWith("%")) {
            return new FlipFlop(source.substring(1), dests);
          } else if (source.startsWith("&")) {
            return new Conjunction(source.substring(1), dests);
          } else if (source.equals("broadcaster")) {
            return new Broadcaster(source, dests);
          }
          throw new IllegalStateException(source);
        })
        .collect(Collectors.toMap(Module::name, Function.identity()));

    modulesByName.values().forEach(module -> module.receivers.forEach(receiverName -> {
      Module receiver = modulesByName.get(receiverName);
      if (receiver instanceof Conjunction conjunction) {
        conjunction.init(module.name);
      }
    }));

    ArrayDeque<Msg> queue = new ArrayDeque<>();
    long high = 0, low = 0;
    for (long i = 1; i <= 1000; i++) {
      queue.add(new Msg("button", "broadcaster", Pulse.LOW));
      while (!queue.isEmpty()) {
        Msg msg = queue.pop();
        modulesByName.computeIfAbsent(msg.dest, Output::new).signal(msg.src, msg.pulse, queue, i);

        if (msg.pulse == Pulse.HIGH) high++; else low++;
      }
    }
//    System.out.println("high=" + high +" low="+low);
    return high * low;
  }

  record Msg(String src, String dest, Pulse pulse) {}
}
