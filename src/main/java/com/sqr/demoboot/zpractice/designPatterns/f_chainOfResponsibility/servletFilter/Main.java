package com.sqr.demoboot.zpractice.designPatterns.f_chainOfResponsibility.servletFilter;

import com.sqr.demoboot.zpractice.designPatterns.f_chainOfResponsibility.Request;
import com.sqr.demoboot.zpractice.designPatterns.f_chainOfResponsibility.Response;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.add(new HtmlFilter()).add(new FaceFilter());
        Request request = new Request();
        request.str = "<input/> 开心";
        Response response = new Response();
        response.str = "";
        System.out.println(request.str);
        System.out.println(response.str);

        filterChain.doFilter(request,response,filterChain);

        System.out.println(request.str);
        System.out.println(response.str);
    }
}
interface Filter{
    boolean doFilter(Request request, Response response,FilterChain chain);
}
class HtmlFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        if (request.str.contains("<") || request.str.contains(">")){
            request.str = request.str.replaceAll("<","[").replaceAll(">","}");
        }else {
            return false;
        }
        chain.doFilter(request,response,chain);
        response.str += "---html filter";
        return true;
    }
}
class FaceFilter implements Filter{
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        if (request.str.contains("开心")){
            request.str = request.str.replaceAll("开心","高兴");
        }else {
            return false;
        }
        chain.doFilter(request,response,chain);
        response.str += "---face filter";
        return true;
    }
}
class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    int index = 0;
    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }
    @Override
    public boolean doFilter(Request request, Response response,FilterChain chain) {
        if (index==filters.size())return false;
        Filter filter = filters.get(index);
        index++;
        return filter.doFilter(request,response,chain);
    }
}