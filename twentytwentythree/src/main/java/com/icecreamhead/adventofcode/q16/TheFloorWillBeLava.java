package com.icecreamhead.adventofcode.q16;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TheFloorWillBeLava {

    long part1(char[][] input) throws InterruptedException {
        HashSet<Beam> beams = new HashSet<Beam>();
        beams.add(Beam.START);
        HashSet<Pos> visited = new HashSet<Pos>();

//        print(input, beams);
        while (!beams.isEmpty()) {

            for (Beam beam : beams) {




            }

            break;

//            print(input, beams);
//            Thread.sleep(1000);
        }

        return visited.size();
    }

    private void print(char[][] input, Set<Beam> beams) {
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[y].length; x++) {
                if (has(beams, x, y))
                    System.out.print("#");
                else
                    System.out.print(input[y][x]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean has(Set<Beam> beams, int x, int y) {
        return beams.stream().anyMatch(b -> b.x() == x && b.y() == y);
    }

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }


    private record Pos(int x, int y) {}
    private record Beam(Pos pos, Direction direction) {
        private static final Beam START = new Beam(new Pos(0,0), Direction.RIGHT);
        private int x() {
            return pos.x;
        }
        private int y() {
            return pos.y;
        }
    }
}
