package com.icecreamhead.adventofcode.q2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class CubeConundrum {

    long part1(List<String> lines) {
        return resolveGames(lines)
                .stream()
                .filter(g -> g.isPossible(12, 13, 14))
                .mapToInt(Game::id)
                .sum();
    }

    long part2(List<String> lines) {
        return resolveGames(lines)
                .stream()
                .mapToLong(g -> g.drawnCubes
                        .stream()
                        .reduce((c1, c2) -> new DrawnCubes(
                                Math.max(c1.red, c2.red), Math.max(c1.green, c2.green), Math.max(c1.blue, c2.blue)
                        ))
                        .map(DrawnCubes::power)
                        .orElseThrow()
                )
                .sum();
    }

    private List<Game> resolveGames(List<String> lines) {
        return lines.stream()
                .map(line -> {

                    Set<DrawnCubes> drawnCubes = new HashSet<>();

                    StringTokenizer tokenizer = new StringTokenizer(line, " ");
                    if (!tokenizer.nextToken().equals("Game")) {
                        throw new IllegalStateException();
                    }
                    int id = Integer.parseInt(tokenizer.nextToken().replace(":", ""));

                    int r = 0, g = 0, b = 0;
                    while (tokenizer.hasMoreTokens()) {
                        String t = tokenizer.nextToken();
                        int count = Integer.parseInt(t);
                        String col = tokenizer.nextToken();
                        switch (col.replace(",", "").replace(";", "")) {
                            case "red" -> r = count;
                            case "green" -> g = count;
                            case "blue" -> b = count;
                            default -> throw new IllegalStateException(col);
                        }
                        if (col.endsWith(";") || !tokenizer.hasMoreTokens()) {
                            drawnCubes.add(new DrawnCubes(r, g, b));
                            r = 0;
                            g = 0;
                            b = 0;
                        }
                    }

                    return new Game(id, drawnCubes);
                })
                .peek(System.out::println)
                .toList();
    }

    record Game(int id, Set<DrawnCubes> drawnCubes) {
        boolean isPossible(int r, int g, int b) {
            return drawnCubes.stream().allMatch(c -> c.red <= r && c.green <= g && c.blue <= b);
        }
    }

    record DrawnCubes(int red, int green, int blue) {
        long power() {
            return (long) red * green * blue;
        }
    }
}
