package com.sqr.demoboot.zpractice.designPatterns.n_adapter;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream("C:\\Users\\17538\\Desktop\\test.txt");
        InputStreamReader reader = new InputStreamReader(is);//转接器
        BufferedReader bf = new BufferedReader(reader);
        String readStrLine = bf.readLine();
        System.out.print(readStrLine);
        bf.close();
        reader.close();
        is.close();
    }
}
