package com.icecreamhead.adventofcode.q10;

import java.util.Arrays;

public class PipeMaze {

    long part1(char[][] input) {

        Pos pos = findStart(input);

        long x = 0;
        Pos prev = null, tmp = null;
        do {
            tmp = pos;
            pos = pos.next(prev, input);
            prev = tmp;
//            System.out.println(pos);
            x++;
        } while (pos.tile != 'S');


        return x % 2 == 0 ? x / 2 : (x + 1) / 2;
    }

    private static Pos findStart(char[][] input) {
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[y].length; x++) {
                if (input[y][x] == 'S') return new Pos(input[y][x], x, y);
            }
        }
        throw new IllegalStateException();
    }

    record Pos(char tile, int x, int y) {
        Pos next(Pos prev, char[][] tiles) {
            boolean tileNorth = y > 0, tileEast = x < tiles.length - 1, tileSouth = y < tiles[0].length - 1, tileWest = x > 0;
            return switch (tile) {
                case 'S' -> {
                    if (tileNorth && tiles[y - 1][x] != '.') yield new Pos(tiles[y - 1][x], x, y - 1);
                    if (tileEast && tiles[y][x + 1] != '.') yield new Pos(tiles[y][x + 1], x + 1, y);
                    if (tileSouth && tiles[y + 1][x] != '.') yield new Pos(tiles[y + 1][x], x, y + 1);
                    if (tileWest && tiles[y][x - 1] != '.') yield new Pos(tiles[y][x - 1], x - 1, y);
                    throw new IllegalStateException();
                }
                case 'F' ->
                        prev.x == x + 1 && prev.y == y ? new Pos(tiles[y + 1][x], x, y + 1) : new Pos(tiles[y][x + 1], x + 1, y);
                case 'J' ->
                        prev.x == x && prev.y == y - 1 ? new Pos(tiles[y][x - 1], x - 1, y) : new Pos(tiles[y - 1][x], x, y - 1);
                case '-' ->
                        prev.x == x + 1 && prev.y == y ? new Pos(tiles[y][x - 1], x - 1, y) : new Pos(tiles[y][x + 1], x + 1, y);
                case '|' ->
                        prev.x == x && prev.y == y - 1 ? new Pos(tiles[y + 1][x], x, y + 1) : new Pos(tiles[y - 1][x], x, y - 1);
                case 'L' ->
                        prev.x == x + 1 && prev.y == y ? new Pos(tiles[y - 1][x], x, y - 1) : new Pos(tiles[y][x + 1], x + 1, y);
                case '7' ->
                        prev.x == x - 1 && prev.y == y ? new Pos(tiles[y + 1][x], x, y + 1) : new Pos(tiles[y][x - 1], x - 1, y);
                default -> throw new IllegalStateException();
            };


//            throw new IllegalStateException();
        }
    }
}
