package com.sqr.demoboot.zpractice.designPatterns.f_chainOfResponsibility;

public interface Filter {
    boolean doFilter(Msg msg);
}

class HtmlFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        if (msg.getMsg().contains("<") || msg.getMsg().contains(">")){
            msg.setMsg(msg.getMsg().replaceAll("<","[").replaceAll(">","]"));
            return true;
        }
        return false;
    }
}
class FaceFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        if (msg.getMsg().contains("(*￣︶￣)")){
            msg.setMsg(msg.getMsg().replaceAll("\\(*￣︶￣\\)","(灬ꈍ ꈍ灬)"));
            return true;
        }
        return false;
    }
}
class UrlFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        if (msg.getMsg().contains("mashibing")){
            msg.setMsg(msg.getMsg().replaceAll("mashibing","baidu"));
            return true;
        }
        return false;
    }
}
