package com.icecreamhead.adventofcode.eighteen.commands;

import com.icecreamhead.adventofcode.eighteen.SoundRegisters;

public class Jump extends Command {
  public Jump(int idx, String x, String y) {
    super(idx, x, y);
  }

  @Override
  public Result execute(SoundRegisters registers) {
    int offset = registers.offset(x, y);
    return Result.ok(idx + offset);
  }
}
