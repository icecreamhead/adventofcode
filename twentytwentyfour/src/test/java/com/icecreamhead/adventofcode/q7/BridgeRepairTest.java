package com.icecreamhead.adventofcode.q7;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeRepairTest {

    private final BridgeRepair underTest = new BridgeRepair();

    @Test
    void pt1_sample() {
        assertThat(underTest.pt1(InputLoader.loadLines("q7/sample.txt"))).isEqualTo(3749);
    }    @Test
    void pt1_puzzle() {
        System.out.println(underTest.pt1(InputLoader.loadLines("q7/puzzle.txt")));
    }
    @Test
    void pt2_sample() {
        assertThat(underTest.pt2(InputLoader.loadLines("q7/sample.txt"))).isEqualTo(11387);
    }    @Test
    void pt2_puzzle() {
        System.out.println(underTest.pt2(InputLoader.loadLines("q7/puzzle.txt")));
    }
}