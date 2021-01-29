package com.sqr.demoboot.zpractice.designPatterns.p_command.chainAndCommand;

import com.sqr.demoboot.zpractice.designPatterns.p_command.chainAndCommand.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandChain implements Command {
    List<Command> commands = new ArrayList<>();
    public void add(Command command){
        commands.add(command);
    }

    @Override
    public boolean doit() {
        for (int i=0 ; i<commands.size() ; i++){
            commands.get(i).doit();
        }
        return false;
    }

    @Override
    public boolean undo() {
        for (int i=0 ; i<commands.size() ; i++){
            commands.get(i).undo();
        }
        return false;
    }
}
