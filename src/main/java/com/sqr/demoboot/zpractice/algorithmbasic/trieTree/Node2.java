package com.sqr.demoboot.zpractice.algorithmbasic.trieTree;

import java.util.Arrays;
import java.util.HashMap;

public class Node2 {
    int pass;
    int end;
    HashMap<Character,Node2> nexts;

    public Node2() {
        pass = 0;
        end = 0;
        nexts = new HashMap<>();
    }
}
