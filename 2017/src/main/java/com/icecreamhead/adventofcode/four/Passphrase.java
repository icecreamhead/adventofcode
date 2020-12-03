package com.icecreamhead.adventofcode.four;

import java.util.Arrays;

import static com.icecreamhead.adventofcode.util.Converter.multilineStringToStringList;

public class Passphrase {

  public long countValidPart1(String passphrases) {
    return multilineStringToStringList(passphrases)
        .stream()
        .filter(this::noDuplicates)
        .count();
  }

  public long countValidPart2(String passphrases) {
    return multilineStringToStringList(passphrases)
        .stream()
        .map(this::sortPassphrase)
        .filter(this::noDuplicates)
        .count();
  }

  public String sortPassphrase(String passphrase) {
    String[] words = passphrase.split(" ");
    String[] sortedWords = Arrays.stream(words)
        .map(this::sortWord)
        .toArray(String[]::new);


    return String.join(" ", sortedWords);
  }

  String sortWord(String word) {
    char[] chars = word.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public boolean noDuplicates(String passphrase) {
    String[] tokens = passphrase.split(" ");
    return Arrays.stream(tokens).distinct().count() == tokens.length;
  }
}
