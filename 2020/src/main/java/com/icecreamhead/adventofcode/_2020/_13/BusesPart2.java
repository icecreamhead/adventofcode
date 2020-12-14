package com.icecreamhead.adventofcode._2020._13;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class BusesPart2 {

  private static final List<String> SCHEDULE = InputLoader.loadLines("_13/puzzle-input.txt");
  private static final int[] BUSES = Arrays.stream(SCHEDULE.get(1).split(","))
      .mapToInt(bus -> "x".equals(bus) ? Integer.MAX_VALUE : Integer.parseInt(bus)).toArray();

  private static final ExecutorService executor = Executors.newFixedThreadPool(12);

  public static void main(String[] args) throws InterruptedException {

    AtomicLong answer = new AtomicLong();
    boolean optimised = false;
    int jump = 1;
    int run = 0;

    long mostInfrequentBus = 0;
    int mostInfrequentBusIdxSearch = 0;
    for (int i = 0; i < BUSES.length; i++) {
      if (BUSES[i] > mostInfrequentBus && BUSES[i] != Integer.MAX_VALUE) {
        mostInfrequentBus = BUSES[i];
        mostInfrequentBusIdxSearch = i;
      }
    }
    final int mostInfrequentBusIdx = mostInfrequentBusIdxSearch;

    System.out.printf("Most infrequent bus is %d [%d/%d]\n", mostInfrequentBus, mostInfrequentBusIdx, BUSES.length);

    // 100_000_000_000_000L
    for (long t = 100_000_000_000_000L; t < Long.MAX_VALUE; t += jump) {

      if (answer.get() > 0) break;
//      if (run < 500) {
//        System.out.printf("Run %d: t=%d\n", run, t);
//        run++;
//      }

      // optimisation to skip base times that can't be eligible
      if (!optimised && t % BUSES[mostInfrequentBusIdx] == 0) {
        System.out.printf("Optimised! Bus %d runs at %d\n", BUSES[mostInfrequentBusIdx], t);
        System.out.printf("Offset from %d to %d\n", -mostInfrequentBusIdx, BUSES.length - mostInfrequentBusIdx);
        jump = BUSES[mostInfrequentBusIdx];
        optimised = true;
      }


      List<Callable<Boolean>> tasks = new ArrayList<>();
      long ts = t;
      for (int tOffset = -mostInfrequentBusIdx; tOffset < BUSES.length - mostInfrequentBusIdx; tOffset++) {

        int offset = tOffset;


        tasks.add(() -> {
          if (offset == 0 && ts % BUSES[mostInfrequentBusIdx] != 0)
            throw new RuntimeException("that's not right! [t=" + ts + "]");

          return BUSES[mostInfrequentBusIdx + offset] == Integer.MAX_VALUE
              || (ts + offset) % BUSES[mostInfrequentBusIdx + offset] == 0;
        });

      }

      new Thread(() -> {
        try {
          boolean allRunning = executor.invokeAll(tasks, 10, TimeUnit.SECONDS).stream().allMatch(callable -> {
            try {
              return callable.get();
            } catch (Exception e) {
              throw new RuntimeException(e);
            }
          });
          if (allRunning) {
            System.out.println(ts - mostInfrequentBusIdx);
            answer.set(ts - mostInfrequentBusIdx);
          }
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }).start();


//      final long tf = t;
//      allRunning =
//          Stream.iterate(-mostInfrequentBusIdx, tOffset -> tOffset < BUSES.length - mostInfrequentBusIdx, i -> i + 1)
//          .parallel()
//          .allMatch(tOffset -> {
//            if (tOffset == 0 && tf % BUSES[mostInfrequentBusIdx] != 0)
//              throw new RuntimeException("that's not right! [t=" + tf + "]");
//
//            if (BUSES[mostInfrequentBusIdx + tOffset] == Integer.MAX_VALUE)
//              return true;
//
//            if ((tf + tOffset) % BUSES[mostInfrequentBusIdx + tOffset] != 0) {
//              return false;
//            }
//
//            return true;
//          });


//      if (allRunning) {
//        answer = t;
//        break;
//      }

    }

    System.out.println(answer);
  }
}
