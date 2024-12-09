package com.icecreamhead.adventofcode.q8;

import java.util.LinkedList;

public class DiskFragmenter {

  long pt1(String input) {
    int[] blocks = generateBlocks(input);
    compactBlocks(blocks);
    return checksum(blocks);
  }

  long pt2(String input) {
    int[] blocks = generateBlocks(input);
    compactFiles(blocks);
    return checksum(blocks);
  }

  static long checksum(int[] blocks) {
    int i = 0;
    long t = 0;
    System.out.printf("length: %d\n", blocks.length);
    while (i < blocks.length) {
      if (blocks[i] != -1) {
        t += blocks[i] * (long) i;
      }
      i++;
    }
    return t;
  }

  static void compactBlocks(int[] blocks) {
    int l = 0, r = blocks.length - 1;
    while (l < r) {
      if (blocks[l] != -1) {
        l++;
      } else if (blocks[r] == -1) {
        r--;
      } else {
        assert blocks[l] == -1 && blocks[r] != -1;
        blocks[l] = blocks[r];
        blocks[r] = -1;
      }
    }
  }

  static void compactFiles(int[] blocks) {
//    System.out.printf("%s%n", new String(blocks));
    int r = blocks.length - 1;
    while (r >= 0) {

      if (blocks[r] == -1) {
        r--;
      } else {
        int rstart = r;
        int val = blocks[r];
        while (r >= 0 && blocks[r] == val) {
          System.out.printf("block[%d] is %d\n", r, blocks[r]);
          r--;
        }
        int rlen = rstart - r;

                System.out.printf("len of %d is %d\n", val, rlen);

        int emptySpace = findEmptySpaceOfSize(blocks, rlen, r);
        System.out.println("empty space: " + emptySpace + " (started at " + 0 + ")");

        if (emptySpace != -1) {
          for (int i = 0; i < rlen; i++) {
            blocks[emptySpace + i] = blocks[r + 1 + i];
            blocks[r + 1 + i] = -1;
          }
        }
//        System.out.printf("%s%n", new String(blocks));
      }
    }
  }

  private static int findEmptySpaceOfSize(int[] blocks, int reqlen, int max) {

    for (int i = 0; i < max; i++) {

      if (blocks[i] == -1) {
        int blockstart = i;
        while (i < max && blocks[i] != -1) {
          System.out.printf("block[%d] is %d\n", i, blocks[i]);
          i++;
        }
        int foundlen = 1 + i - blockstart;
        System.out.printf("foundlen: %d\n", foundlen);
        if (foundlen >= reqlen) return blockstart;
      }

    }
    return -1;
  }

  static int[] generateBlocks(String input) {
    boolean file = true;
    int id = 0;

    LinkedList<Integer> blocks = new LinkedList<>();
    for (char c : input.toCharArray()) {
      int repetitions = c - 48;

      for (int i = 0; i < repetitions; i++) {
        blocks.add(file ? id : -1);
      }
      if (file) {
        id++;
      }
      file = !file;
    }

    return blocks.stream().mapToInt(i -> i).toArray();
  }

}
