package com.icecreamhead.adventofcode.q8;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.w3c.dom.Node;


public class HauntedWasteland {

    private static final Pattern PATTERN = Pattern.compile("(?<source>[A-Z]{3}) = \\((?<left>[A-Z]{3}), (?<right>[A-Z]{3})\\)");
    private static final Pattern PATTERN2 = Pattern.compile("(?<source>[0-9A-Z]{3}) = \\((?<left>[0-9A-Z]{3}), (?<right>[0-9A-Z]{3})\\)");

    long steps(List<String> lines) {
        char[] instructions = lines.get(0).toCharArray();
        Map<String, Node> nodeMap = lines.stream().skip(2)
                .map(line -> {
                    Matcher matcher = PATTERN.matcher(line);
                    if (!matcher.matches()) {
                        throw new IllegalStateException(line);
                    }
                    return new Instruction(matcher.group("source"), new Node(matcher.group("left"), matcher.group("right")));
                })
                .collect(Collectors.toUnmodifiableMap(Instruction::pos, Instruction::node));

        int i = 0;
        String node = "AAA";
        while (!node.equals("ZZZ")) {
            node = switch (instructions[i % instructions.length]) {
                case 'L' -> nodeMap.get(node).left();
                case 'R' -> nodeMap.get(node).right();
                default -> throw new IllegalStateException(instructions[i % instructions.length] + "");
            };
            i++;
        }

        return i;
    }
    long steps2(List<String> lines) throws InterruptedException {
        char[] instructions = lines.get(0).toCharArray();
        Map<String, Node> nodeMap = lines.stream().skip(2)
                .map(line -> {
                    Matcher matcher = PATTERN2.matcher(line);
                    if (!matcher.matches()) {
                        throw new IllegalStateException(line);
                    }
                    return new Instruction(matcher.group("source"), new Node(matcher.group("left"), matcher.group("right")));
                })
                .collect(Collectors.toUnmodifiableMap(Instruction::pos, Instruction::node));

        long i = 0;
        int instr = 0;
        String[] nodes = nodeMap.keySet().stream().filter(node -> node.endsWith("A")).toArray(String[]::new);
//        String[] nodes = new String[]{"XQA","SKA"};
        Long[] firstNodeFinish = new Long[nodes.length];
        Long[] loopPeriod = new Long[nodes.length];
        System.out.println(Arrays.toString(nodes));
        long finishCount = 0;
        while (finishCount != nodes.length) {
            for (int j = 0; j < nodes.length; j++) {
                nodes[j] = switch (instructions[instr % instructions.length]) {
                    case 'L' -> nodeMap.get(nodes[j]).left();
                    case 'R' -> nodeMap.get(nodes[j]).right();
                    default -> throw new IllegalStateException(instructions[instr % instructions.length] + "");
                };
                if (nodes[j].endsWith("Z")) {
                    if (firstNodeFinish[j] == null)
                        firstNodeFinish[j] = i+1;
                    else if (loopPeriod[j] == null) {
                        loopPeriod[j] = i + 1 - firstNodeFinish[j];
                    }
                }
            }
            instr = instr == instructions.length - 1 ? 0 : instr+1;
            i++;
            finishCount = Arrays.stream(nodes).filter(node -> node.endsWith("Z")).count();
//            if (finishCount > 0)
//                System.out.printf("%d: %s (%d)%n", finishCount, Arrays.toString(nodes), i);
//            if (Arrays.stream(firstNodeFinish).allMatch(Objects::nonNull))
//                System.out.println(Arrays.toString(firstNodeFinish) + ": " + Arrays.toString(loopPeriod));
            if (Arrays.stream(loopPeriod).allMatch(Objects::nonNull))
                break;
//            Thread.sleep(1000);
        }

        while (!allEqual(firstNodeFinish)) {
            int ix = lowestIdx(firstNodeFinish);
            firstNodeFinish[ix] = firstNodeFinish[ix] + loopPeriod[ix];
//            System.out.println(Arrays.toString(firstNodeFinish));
//            Thread.sleep(1000);
//            if (firstNodeFinish[ix] > 1200000) throw new IllegalStateException();
        }
        System.out.println(Arrays.toString(firstNodeFinish));

        return firstNodeFinish[0];
    }

    private static boolean allEqual(Long[] a) {
        for (int i = 0; i < a.length - 1; i++) {
//            System.out.printf("%d == %d => %s%n",a[i],a[i+1],(long) a[i] != (long) a[i+1]);
            if ((long) a[i] != (long) a[i+1]) return false;
        }
        return true;
    }
    private int lowestIdx(Long[] a) {
        long l = Long.MAX_VALUE;
        int lx = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i] + " vs " + l);
            if (a[i] < l) {
//                System.out.println("l := "+a[i]);
                l = a[i];
                lx = i;
            }
        }
        return lx;
    }
    record Node(String left, String right) {
    }

    record Instruction(String pos, Node node) {
    }
}
