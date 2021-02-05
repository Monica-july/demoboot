package com.sqr.demoboot.zpractice.algorithmbasic.trieTree;

public class Code02_TrieTree {
    Node2 root;//根节点

    public Code02_TrieTree() {
        this.root = new Node2();
    }

    /*
    * 添加字符串
    * */
    public void insert(String str){
        if (str==null ||str==""){
            return;
        }
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        Node2 node = root;
        node.pass++;
        for (int i = 0; i < chars.length ; i++) {
            Node2 node1;
            if (node.nexts.get(chars[i])==null){
                node.nexts.put(chars[i],new Node2());
            }
            node = node.nexts.get(chars[i]);
            node.pass++;
            if (i==chars.length-1){
                node.end++;
            }
        }
    }
    /*
     * 查找字符串加入过多少次
     * */
    public int search(String str){
        if (str==null ||str==""){
            return 0;
        }
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        Node2 node = root;
        for (int i = 0; i < chars.length ; i++) {
            if (node.nexts.get(chars[i])==null){
                return 0;
            }
            node = node.nexts.get(chars[i]);
        }
        return node.end;
    }
    /*
    * 删除字符串
    * */
    public boolean delete(String str){
        str = str.toLowerCase();
        //查找字符串是否存在
        if (search(str)>0){
            Node2 node = root;
            char[] chars = str.toCharArray();
            node.pass--;
            for (int i = 0; i < chars.length ; i++) {
                //如果没有字符经过 则下面的路都无效 直接置为null 删除结束
                if (node.pass==0){
                    node.nexts=null;
                    return true;
                }
                node = node.nexts.get(chars[i]);
            }
            node.end--;
            return true;
        }
        return false;
    }
    /*
    * 查找有多少以str为前缀的字符串
    * */
    public int trieStr(String str){
        if (str==null ||str==""){
            return 0;
        }
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        Node2 node = root;
        for (int i = 0; i < chars.length ; i++) {
            if (node.nexts.get(chars[i])==null){
                return 0;
            }
            node = node.nexts.get(chars[i]);
        }
        return node.pass;
    }
}

class Main{
    public static void main(String[] args) {
        Code02_TrieTree trieTree = new Code02_TrieTree();
//        trieTree.insert("abc");
//        trieTree.insert("ab");
        trieTree.insert("cd");
        trieTree.insert("abc");
        System.out.println("abc添加次数："+trieTree.search("abc"));
        System.out.println("ac添加次数："+trieTree.search("ac"));
        System.out.println("以ab为前缀的字符串："+trieTree.trieStr("ab"));
        System.out.println("cd删除："+trieTree.delete("cd"));
        System.out.println("cd添加次数："+trieTree.search("cd"));
        System.out.println("---------------------------------------");
    }
}