package com.icecreamhead.adventofcode.eighteen.commands;

import com.icecreamhead.adventofcode.eighteen.SoundRegisters;

public class Multiply extends Command {

  public Multiply(int idx, String x, String y) {
    super(idx, x, y);
  }

  @Override
  public Result execute(SoundRegisters registers) {
    registers.multiply(x, y);
    return Result.ok(idx + 1);
  }
}
