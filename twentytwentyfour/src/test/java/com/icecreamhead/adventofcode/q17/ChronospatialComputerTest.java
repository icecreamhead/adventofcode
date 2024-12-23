package com.icecreamhead.adventofcode.q17;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import java.util.OptionalLong;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

class ChronospatialComputerTest {

  private static final String puzzle = "2,4,1,1,7,5,4,0,0,3,1,6,5,5,3,0";

  @Test
  void p1_sample() {
    ChronospatialComputer underTest = new ChronospatialComputer(729, "0,1,5,4,3,0");

    assertThat(underTest.run()).isEqualTo("4,6,3,5,6,3,5,2,1,0");
  }

  @Test
  void p1_puzzle() {
    ChronospatialComputer underTest = new ChronospatialComputer(30899381, puzzle);

    System.out.println(underTest.run());
  }

  @Test
  void p2_sample() throws InterruptedException {
    System.out.println(Long.toBinaryString(117440));

    long i = p2recurse(0, 0, "0,3,5,4,3,0").orElseThrow();

    assertThat(i).isEqualTo(117440);
  }

  @Test
  void p2_experiment()  {
    //System.out.println(p2recurse(0, 0, puzzle).orElseThrow());
  }

//  private long p2(String input) throws InterruptedException {
//    long accum = 0;
//    int c = 0;
//    while (!new ChronospatialComputer(accum, input).run().equals(input)) {
//      boolean goToNext = false;
//      Thread.sleep(1000);
//      for (int i = 0; i < 8; i++) {
//        long candidate = (accum << (3 * c)) + i;
//        System.out.printf("accum: %d, candidate: %d\n", accum, candidate);
//        String out = new ChronospatialComputer(candidate, input).run();
//        String exp = input.substring(input.length() - ((c * 2) + 1));
//        System.out.printf("%d\t%d\t%d\t%s\t%s\t%s%n", c, i, candidate, Long.toBinaryString(candidate), exp, out);
//
//        if (out.equals(exp) && !(c == 0 && i == 0)) {
//          c++;
//          accum = candidate;
//          System.out.printf("Set accum=%d%n", accum);
//          goToNext = true;
//          break;
//        }
//        Thread.sleep(1000);
//      }
//      if (!goToNext) {
//        throw new IllegalStateException("Should not be here");
//      }
//    }
//    return accum;
//  }

  private OptionalLong p2recurse(long accum, int depth, String input) {
    String out = new ChronospatialComputer(accum, input).run();
//    System.out.printf("%s depth=%d out=%s accum=%d%n", input, depth, out, accum);
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
    if (input.equals(out)) {
      return OptionalLong.of(accum);
    }

    return LongStream.range(0, 8)
        .filter(i -> {
          long a = (accum << 3) + i;
          String o = new ChronospatialComputer(a, input).run();
          String exp = input.substring(input.length() - ((depth * 2) + 1));
          System.out.printf("[%24s]\t%64s %12d => %s%n", exp, Long.toBinaryString(a), a, o);

          return o.equals(exp);
        })
        .flatMap(i -> p2recurse((accum << 3) + i, depth + 1, input).stream())
        .findFirst();
  }

  //  @Test
  void p2_puzzle() {
//    long i = 0;
//    ChronospatialComputer underTest;
//    do {
//      underTest = new ChronospatialComputer(++i,"2,4,1,1,7,5,4,0,0,3,1,6,5,5,3,0");
//      if (i % 1_000_000 == 0) {
//        System.err.println(i);
//      }
//    } while (!underTest.run().equals("2,4,1,1,7,5,4,0,0,3,1,6,5,5,3,0"));
//    System.out.println(i);

    AtomicLong solution = new AtomicLong();
    LongStream.iterate(1, x -> solution.get() == 0, x -> x + 1)
        .parallel()
        .forEach(a -> {
          if (a % 1_000_000 == 0) {
            System.err.println(a);
          }
          if (new ChronospatialComputer(a, puzzle).run().equals(puzzle)) {
            solution.set(a);
            System.out.println(a);
          }
        });
    System.out.println(solution.get());

  }
}