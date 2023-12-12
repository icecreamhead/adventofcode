package com.icecreamhead.adventofcode.q12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotSprings {

    long part1(List<String> input) {
        System.out.println("Inputs");
        input.forEach(System.out::println);
        System.out.println();
        return input.stream()
                .mapToLong(line -> {
//                    System.out.println(line);
                    String[] parts = line.split(" ");
                    String record = parts[0];
                    int[] groups = Arrays.stream(parts[1].split(",")).mapToInt(Integer::parseInt).toArray();
                    int unknownCount = record.replaceAll("[^?]", "").length();
                    int allocatedDamageCount = record.replaceAll("[^#]", "").length();
                    int totalDamageCount = Arrays.stream(groups).sum();
                    int damageToAllocate = totalDamageCount - allocatedDamageCount;
                                        System.out.printf("unknownCount=%d allocatedDamageCount=%d totalDamageCount=%d damageToAllocate=%d%n%n",
                            unknownCount, allocatedDamageCount, totalDamageCount, damageToAllocate);
//                    Set<String> permutations = permutations(unknownCount, damageToAllocate);
//                    System.out.println(line + " => " + permutations.size() + " permutations to try...");
//                    System.out.println(permutations);
                    Set<String> validPerms = permutations(unknownCount, damageToAllocate)
                            .map(perm -> {
                                String o = record;
//                                System.out.println("== " + o);
                                for (char c : perm.toCharArray()) {
                                    o = o.replaceFirst("\\?", "%s".formatted(c));
//                                    System.out.println("=> " + o);
                                }
                                return o;
                            })
//                            .peek(System.out::println)
                            .filter(p -> isValid(p, groups))
                            .collect(Collectors.toSet());


//                    System.out.println(validPerms);
//                    System.out.printf("unknownCount=%d allocatedDamageCount=%d totalDamageCount=%d damageToAllocate=%d%n%n",
//                            unknownCount, allocatedDamageCount, totalDamageCount, damageToAllocate);
                    System.out.println(line + " => " + validPerms.size() + " valid permutations");
                    return validPerms.size();
                })
                .sum();
    }

    long part2(List<String> input) {
        return part1(
                input.stream()
                        .map(s -> {
                            String[] ss = s.split(" ");
                            return ss[0] + "?" + ss[0] + "?" + ss[0] + "?" + ss[0] + "?" + ss[0] + " " + ss[1] + "," + ss[1] + "," + ss[1] + "," + ss[1] + "," + ss[1];
                        }).toList()
        );
    }

    static boolean isValid(String arrangement, int[] groups) {
        int inGroup = -1;
        int consecutiveDamageCount = 0;
        char prev = '!';
//        System.out.printf("%s: %s%n", Arrays.toString(groups), arrangement);
        for (char c : arrangement.toCharArray()) {
//            System.out.printf("%s%n", c);
            if (arrangement.contains("?")) throw new IllegalStateException("Found ?, incomplete impl!");

            if (c == '.') {
                if (prev == '#') {
                    // we've exited a damage group, verify its length
                    if (consecutiveDamageCount != groups[inGroup]) return false;
                    consecutiveDamageCount = 0;
                }
            } else if (c == '#') {
                consecutiveDamageCount++;
                if (prev == '.' || prev == '!') {
                    inGroup++;
                }
            }
//            System.out.printf("prev %s => %s%n", prev, c);
            prev = c;
        }
        // check last group was valid
        if (prev == '#' && consecutiveDamageCount != groups[inGroup]) return false;

        return true;
    }

    static Stream<String> permutations(int totalNumberOfPlacesToFill, int numberOfDesiredCharsToFillWith) {
        if (totalNumberOfPlacesToFill == numberOfDesiredCharsToFillWith) {
            return Stream.of("#".repeat(totalNumberOfPlacesToFill));
        } else if (numberOfDesiredCharsToFillWith == 0) {
            return Stream.of(".".repeat(totalNumberOfPlacesToFill));
        } else if (totalNumberOfPlacesToFill == 1) {
            if (numberOfDesiredCharsToFillWith > 1) throw new IllegalStateException();
            return Stream.of(".");
        }

        return Stream.concat(
                permutations(totalNumberOfPlacesToFill - 1, numberOfDesiredCharsToFillWith).map(p -> "." + p),
                permutations(totalNumberOfPlacesToFill - 1, numberOfDesiredCharsToFillWith - 1).map(p -> "#" + p)
        );
    }
}
