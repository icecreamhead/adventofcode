package com.icecreamhead.adventofcode.eighteen;

import com.icecreamhead.adventofcode.eighteen.commands.Command;
import com.icecreamhead.adventofcode.eighteen.commands.Result;

import java.util.ArrayList;
import java.util.List;

public class DuetRunner {

  private final SoundRegisters registers = new SoundRegisters();

  public long run(List<String> commands) {
    List<Command> cmds = new ArrayList<>();
    for (int i = 0; i < commands.size(); i++) {
      cmds.add(Command.build(i, commands.get(i)));
    }

    Result state = Result.ok(0);

    do {
      state = cmds.get(state.next()).execute(registers);
    } while (!state.complete());
    return state.output();
  }
}
