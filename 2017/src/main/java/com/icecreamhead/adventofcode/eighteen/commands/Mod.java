package com.icecreamhead.adventofcode.eighteen.commands;

import com.icecreamhead.adventofcode.eighteen.SoundRegisters;

public class Mod extends Command {
  public Mod(int idx, String x, String y) {
    super(idx, x, y);
  }

  @Override
  public Result execute(SoundRegisters registers) {
    registers.mod(x, y);
    return Result.ok(idx + 1);
  }
}
