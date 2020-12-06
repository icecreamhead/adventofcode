package com.icecreamhead.adventofcode.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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

}
