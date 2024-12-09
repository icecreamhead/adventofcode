package com.icecreamhead.adventofcode.q16;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TheFloorWillBeLavaTest {

    private final TheFloorWillBeLava underTest = new TheFloorWillBeLava();

    private static final char[][] SAMPLE = InputLoader.loadGrid("q16/sample.txt");
    //@Test
    void part1_sample() throws InterruptedException {
        assertThat(underTest.part1(SAMPLE)).isEqualTo(46);
    }
}