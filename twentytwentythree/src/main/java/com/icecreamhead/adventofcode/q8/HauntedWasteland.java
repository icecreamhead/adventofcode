package com.icecreamhead.adventofcode.q8;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.w3c.dom.Node;


public class HauntedWasteland {

  private static final Pattern PATTERN = Pattern.compile("[A-Z]{3} = \\([A-Z]{3}, [A-Z]{3}\\)");

  long steps(List<String> lines) {
    String instructions = lines.get(0);
    Map<String, Node> nodeMap = lines.stream().skip(2)
        .map(line -> {
          if (PATTERN.matcher(line).matches()) {
            System.err.println("No match3aa");
          }
          return new Instruction("", new Node("",""));
        })
        .collect(Collectors.toUnmodifiableMap(Instruction::pos, Instruction::node));
    return 0;
  }

  record Node(String left, String right){}
  record Instruction(String pos, Node node){}
}
