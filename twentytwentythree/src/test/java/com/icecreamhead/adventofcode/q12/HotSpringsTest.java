package com.icecreamhead.adventofcode.q12;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HotSpringsTest {

  private final HotSprings underTest = new HotSprings();

  private static final List<String> SAMPLE = InputLoader.loadLines("q12/sample.txt");
  private static final List<String> PUZZLE = InputLoader.loadLines("q12/puzzle.txt");

  @Test
  void part1_sample() {
    assertThat(underTest.part1(SAMPLE)).isEqualTo(21);
  }
  @Test
  void part2_sample() {
    assertThat(underTest.part2(SAMPLE)).isEqualTo(506250);
  }
  @Test
  void part1_puzzle() {
    System.out.println(underTest.part1(PUZZLE));
  }

  @Test
  void testIsValid() {
    int[] groups = new int[]{1,1,3};
    assertThat(HotSprings.isValid("#.#.###", groups)).isTrue();
    assertThat(HotSprings.isValid(".##.###", groups)).isFalse();
    assertThat(HotSprings.isValid("##..###", groups)).isFalse();

    assertThat(HotSprings.isValid(".##.......###.", groups)).isFalse();
    assertThat(HotSprings.isValid(".....##...###.", groups)).isFalse();
    assertThat(HotSprings.isValid(".#...#....###.", groups)).isTrue();
    assertThat(HotSprings.isValid("..#..#....###.", groups)).isTrue();
    assertThat(HotSprings.isValid(".#....#...###.", groups)).isTrue();
    assertThat(HotSprings.isValid("..#...#...###.", groups)).isTrue();
    assertThat(HotSprings.isValid("..#...#..#.##.", groups)).isFalse();
  }

  @Test
  void permutations() {
    assertThat(HotSprings.permutations(1, 1)).containsExactly("#");
    assertThat(HotSprings.permutations(1, 0)).containsExactly(".");
    assertThat(HotSprings.permutations(2, 2))
            .containsExactly("##");
    assertThat(HotSprings.permutations(2, 1))
            .containsExactlyInAnyOrder("#.",".#");
    assertThat(HotSprings.permutations(2, 0))
            .containsExactly("..");
    assertThat(HotSprings.permutations(3, 0))
            .containsExactlyInAnyOrder("...");
    assertThat(HotSprings.permutations(3, 1))
            .containsExactlyInAnyOrder("..#", ".#.", "#..");
    assertThat(HotSprings.permutations(3, 2))
            .containsExactlyInAnyOrder("##.", ".##", "#.#");
    assertThat(HotSprings.permutations(3, 3))
            .containsExactlyInAnyOrder("###");
    assertThat(HotSprings.permutations(4, 4))
            .containsExactlyInAnyOrder("####");
    assertThat(HotSprings.permutations(4, 3))
            .containsExactlyInAnyOrder(".###","#.##","##.#","###.");
    assertThat(HotSprings.permutations(4, 2))
            .containsExactlyInAnyOrder("##..","#.#.","#..#",".##.",".#.#","..##");
    assertThat(HotSprings.permutations(4, 1))
            .containsExactlyInAnyOrder("#...",".#..","..#.","...#");
    assertThat(HotSprings.permutations(4, 0))
            .containsExactlyInAnyOrder("....");
  }
}