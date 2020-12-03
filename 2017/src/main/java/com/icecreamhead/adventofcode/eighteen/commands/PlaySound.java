package com.icecreamhead.adventofcode.eighteen.commands;

import com.icecreamhead.adventofcode.eighteen.SoundRegisters;

public class PlaySound extends Command {

  PlaySound(int idx, String x) {
    super(idx, x, null);
  }

  @Override
  public Result execute(SoundRegisters registers) {
    registers.sound(x);
    return Result.ok(idx + 1);
  }
}
