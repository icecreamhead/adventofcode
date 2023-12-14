package com.icecreamhead.adventofcode.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class InputLoader {

  private InputLoader() {
  }

  public static List<String> loadLines(String resourceName) {
    try {
      return Files.readAllLines(Path.of(InputLoader.class.getClassLoader().getResource(resourceName).toURI()));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static String loadString(String resourceName) {
    try {
      return Files.readString(Path.of(InputLoader.class.getClassLoader().getResource(resourceName).toURI()));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static char[][] loadGrid(String resourceName) {
    return loadGrid(loadLines(resourceName));
  }

  public static List<char[][]> loadListOfGrids(String resourceName) {
    String input = loadString(resourceName);
    String[] patterns = input.split("\n\n");
    return Arrays.stream(patterns)
        .map(pattern -> pattern.split("\n"))
        .map(Arrays::asList)
        .map(InputLoader::loadGrid)
        .collect(Collectors.toList());
  }

  private static char[][] loadGrid(List<String> lines) {
    int h = lines.size();
    int w = lines.get(0).length();
    char[][] grid = new char[h][w];
    for (int y = 0; y < lines.size(); y++) {
      grid[y] = lines.get(y).toCharArray();
    }
    return grid;
  }

  public static char[][] transpose(char[][] input) {
    char[][] out = new char[input[0].length][input.length];
    for (int coli = 0; coli < input[0].length; coli++) {
      for (int rowi = 0; rowi < input.length; rowi++) {
        out[coli][rowi] = input[rowi][coli];
      }
    }
    return out;
  }

}
