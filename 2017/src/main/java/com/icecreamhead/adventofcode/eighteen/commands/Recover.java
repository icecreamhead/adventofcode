package com.icecreamhead.adventofcode.eighteen.commands;

import com.icecreamhead.adventofcode.eighteen.SoundRegisters;

public class Recover extends Command {

  public Recover(int idx, String x) {
    super(idx, x, null);
  }

  @Override
  public Result execute(SoundRegisters registers) {
    Long out = registers.recover(x);
    if (out != null) {
      return Result.exit(out);
    } else {
      return Result.ok(idx + 1);
    }
  }
}
