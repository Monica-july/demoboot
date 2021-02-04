package com.sqr.demoboot.zpractice.algorithmbasic.trieTree;

import java.util.Arrays;

public class Node1{
    int pass;
    int end;
    Node1[] nexts;

    public Node1() {
        pass = 0;
        end = 0;
        nexts = new Node1[26];
    }

    @Override
    public String toString() {
        return "Node1{" +
                "pass=" + pass +
                ", end=" + end +
                ", nexts=" + Arrays.toString(nexts) +
                '}';
    }
}
