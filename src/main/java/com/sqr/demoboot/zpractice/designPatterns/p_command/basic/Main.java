package com.sqr.demoboot.zpractice.designPatterns.p_command.basic;

public class Main {
    public static void main(String[] args) {
        Content content = new Content();
        content.con = "举步维艰";
        Command copy = new CopyCommand(content);
        copy.doit();
        System.out.println("copy do:"+content.con);
        copy.undo();
        System.out.println("copy undo:"+content.con);

        Command del = new DeleteCommand(content);
        del.doit();
        System.out.println("del do:"+content.con);
        del.undo();
        System.out.println("del undo:"+content.con);
    }
}
