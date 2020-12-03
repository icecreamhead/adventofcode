package com.icecreamhead.adventofcode.eighteen.commands;

import com.icecreamhead.adventofcode.eighteen.SoundRegisters;

public abstract class Command {

  final int idx;
  final String x;
  final String y;

  Command(int idx, String x, String y) {
    this.idx = idx;
    this.x = x;
    this.y = y;
  }

  public abstract Result execute(SoundRegisters registers);

  public static Command build(int idx, String cmd) {
    final String[] bits = cmd.split(" ");
    final String operation = bits[0];
    final String x = bits[1];
    switch (operation) {
      case "snd":
        return new PlaySound(idx, x);
      case "set":
        return new SetRegister(idx, x, bits[2]);
      case "add":
        return new Add(idx, x, bits[2]);
      case "mul":
        return new Multiply(idx, x, bits[2]);
      case "mod":
        return new Mod(idx, x, bits[2]);
      case "rcv":
        return new Recover(idx, x);
      case "jgz":
        return new Jump(idx, x, bits[2]);
    }
    throw new IllegalArgumentException();
  }
}
