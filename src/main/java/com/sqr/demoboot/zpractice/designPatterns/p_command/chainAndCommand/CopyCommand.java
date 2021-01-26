package com.sqr.demoboot.zpractice.designPatterns.p_command.chainAndCommand;

public class CopyCommand implements Command {
    private Content content;

    public CopyCommand(Content content) {
        this.content = content;
    }

    @Override
    public boolean doit() {
        if (content.con!=null && content.con!=""){
            content.con = content.con+content.con;
            System.out.println("copy doit:"+content.con);
            return true;
        }
        return false;
    }

    @Override
    public boolean undo() {
        if (content.con!=null && content.con!=""){
            content.con = content.con.substring(0,content.con.length()/2);
            System.out.println("copy undo:"+content.con);
            return true;
        }
        return false;
    }
}
