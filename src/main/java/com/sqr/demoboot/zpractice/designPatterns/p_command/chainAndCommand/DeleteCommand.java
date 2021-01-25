package com.sqr.demoboot.zpractice.designPatterns.p_command.chainAndCommand;

public class DeleteCommand implements Command {
    private Content content;
    private String delCon;

    public DeleteCommand(Content content) {
        this.content = content;
        delCon = "";
    }

    @Override
    public boolean doit() {
        if (content.con!=null && content.con!=""){
            delCon = content.con.substring(content.con.length()-1,content.con.length());
            content.con = content.con.substring(0,content.con.length()-1);
            System.out.println("del doit:"+content.con);
            return true;
        }
        return false;
    }

    @Override
    public boolean undo() {
        content.con = content.con+delCon;
        System.out.println("del undo:"+content.con);
        return true;
    }
}
