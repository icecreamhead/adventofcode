package com.icecreamhead.adventofcode.q8;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

class DiskFragmenterTest {

  private final DiskFragmenter underTest = new DiskFragmenter();

  @Test
  void genBlocks() {
    assertThat(DiskFragmenter.generateBlocks("12345")).isEqualTo(new int[]{0, -1, -1, 1, 1, 1, -1, -1, -1, -1, 2, 2, 2, 2, 2});
    assertThat(DiskFragmenter.generateBlocks("2333133121414131402")).isEqualTo(new int[]{0, 0, -1, -1, -1, 1, 1, 1, -1, -1, -1, 2, -1, -1, -1, 3, 3, 3, -1, 4, 4, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, 7, 7, 7, -1, 8, 8, 8, 8, 9, 9});
    assertThat(DiskFragmenter.generateBlocks("1111111111111111111111")).isEqualTo(new int[]{0, -1, 1, -1, 2, -1, 3, -1, 4, -1, 5, -1, 6, -1, 7, -1, 8, -1, 9, -1, 10, -1});
  }

  @Test
  void compactBlocks() {
    int[] a = "0..111....22222".chars().map(i -> i == 46 ? -1 : i - 48).toArray();
    DiskFragmenter.compactBlocks(a);
    assertThat(a).isEqualTo(new int[]{0, 2, 2, 1, 1, 1, 2, 2, 2, -1, -1, -1, -1, -1, -1});

    int[] b = "00...111...2...333.44.5555.6666.777.888899".chars().map(i -> i == 46 ? -1 : i - 48).toArray();
    DiskFragmenter.compactBlocks(b);
    assertThat(b).isEqualTo(new int[]{0, 0, 9, 9, 8, 1, 1, 1, 8, 8, 8, 2, 7, 7, 7, 3, 3, 3, 6, 4, 4, 6, 5, 5, 5, 5, 6, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1});
  }

  @Test
  void compactFiles() {
    int[] c = new int[]{0, -1, 1, -1, 2, -1, 3, -1, 4, -1, 5, -1, 6, -1, 7, -1, 8, -1, 9, -1, 10, -1};
//    DiskFragmenter.compactFiles(c);
//    assertThat(c).isEqualTo(new int[]{0, 10, 1, 9, 2, 8, 3, 7, 4, 6, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1});

    int[] b = new int[]{0, -1, -1, -1, 1, -1, -1, 2, -1, 3, 4, 6, 6, 5, 5, 5};
    DiskFragmenter.compactFiles(b);
    assertThat(b).isEqualTo(new int[]{0, 5, 5, 5, 1, 6, 6, 2, 4, 3, -1, -1, -1, -1, -1, -1});
  }

  @Test
  void checksum() {
    assertThat(DiskFragmenter.checksum("00992111777.44.333....5555.6666.....8888..".chars().map(i -> i == 46 ? -1 : i - 48).toArray())).isEqualTo(2858);
    assertThat(DiskFragmenter.checksum(new int[]{0, 10, 1, 9, 2, 8, 3, 7, 4, 6, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1})).isEqualTo(290);
  }

  @Test
  void pt1_sample() {
    assertThat(underTest.pt1("2333133121414131402")).isEqualTo(1928);
  }

  @Test
  void pt1_puzzle() {
    System.out.println(underTest.pt1(InputLoader.loadString("q8/puzzle.txt")));
  }

  @Test
  void pt2_sample() {
    assertThat(underTest.pt2("2333133121414131402")).isEqualTo(2858);
  }

  @Test
  void pt2_puzzle() {
    System.out.println(underTest.pt2(InputLoader.loadString("q8/puzzle.txt")));
  }
}