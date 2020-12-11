package com.icecreamhead.adventofcode.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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
    List<String> lines = InputLoader.loadLines(resourceName);
    int h = lines.size();
    int w = lines.get(0).length();
    char[][] grid = new char[h][w];
    for (int y = 0; y < lines.size(); y++) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); x++) {
        grid[y][x] = line.charAt(x);
      }
    }
    return grid;
  }

}
