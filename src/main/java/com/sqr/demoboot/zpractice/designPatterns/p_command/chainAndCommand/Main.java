package com.sqr.demoboot.zpractice.designPatterns.p_command.chainAndCommand;

import com.sqr.demoboot.zpractice.designPatterns.p_command.chainAndCommand.CopyCommand;

public class Main {
    public static void main(String[] args) {
        Content content = new Content();
        content.con = "真没睡";
        CommandChain chain = new CommandChain();
        chain.add(new CopyCommand(content));
        chain.add(new DeleteCommand(content));
        chain.add(new CopyCommand(content));
        chain.doit();
        chain.undo();
    }
}
