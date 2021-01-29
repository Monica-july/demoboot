package com.sqr.demoboot.zpractice.designPatterns.f_chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好 (*￣︶￣)，<script>，欢迎访问mashibing.com，大家都是996");
//        msg.setMsg("大家好 O(∩_∩)O哈哈~，<script>，欢迎访问mashibing.com，大家都是996");
        //封装变化
        /* 1.0写法 */
//        msg.setMsg(msg.getMsg().replaceAll("<","[").
//                replaceAll(">","]").
//                replaceAll("996","955"));
        /* 2.0写法 */
//        List<Filter> filters = new ArrayList<>();
//        filters.add(new HtmlFilter());
//        filters.add(new FaceFilter());
//        filters.add(new UrlFilter());
//        filters.forEach(e-> e.doFilter(msg));

        /* 3.0写法 */
//        FilterChain filterChain = new FilterChain();
//        filterChain.add(new HtmlFilter()).add(new FaceFilter()).add(new UrlFilter());
//        filterChain.doFilter(msg);

        /* 4.0写法 */
        FilterChain filterChain = new FilterChain();
        filterChain.add(new HtmlFilter()).add(new FaceFilter());
        FilterChain chain = new FilterChain();
        chain.add(new UrlFilter());
        filterChain.add(chain);

        filterChain.doFilter(msg);


        System.out.println(msg.toString());
    }
}
