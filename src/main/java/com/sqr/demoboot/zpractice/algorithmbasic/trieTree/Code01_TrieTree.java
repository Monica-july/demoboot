package com.sqr.demoboot.zpractice.algorithmbasic.trieTree;

public class Code01_TrieTree {
    Node1 root;//根节点

    public Code01_TrieTree() {
        this.root = new Node1();
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
        Node1 node = root;
        for (int i = 0; i < chars.length ; i++) {
            node.pass++;
            Node1 node1;
            if (node.nexts[chars[i]-97]==null){
                node1 = new Node1();
                node.nexts[chars[i]-97] = node1;
            }
            node1 = node.nexts[chars[i]-97];
            if (i==chars.length-1){
                node1.pass++;
                node1.end++;
            }
            node = node1;
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
        Node1 node = root;
        for (int i = 0; i < chars.length ; i++) {
            if (node.nexts[chars[i]-97]==null){
                return 0;
            }
            node = node.nexts[chars[i]-97];
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
            Node1 node = root;
            char[] chars = str.toCharArray();
            node.pass--;
            for (int i = 0; i < chars.length ; i++) {
                //如果没有字符经过 则下面的路都无效 直接置为null 删除结束
                if (node.pass==0){
                    node.nexts=null;
                    return true;
                }
                Node1 tempNode = node.nexts[chars[i]-97];
                node = tempNode;
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
        Node1 node = root;
        for (int i = 0; i < chars.length ; i++) {
            if (node.nexts[chars[i]-97]==null){
                return 0;
            }
            node = node.nexts[chars[i]-97];
        }
        return node.pass;
    }
}
class Test{
    public static void main(String[] args) {
        Code01_TrieTree trieTree = new Code01_TrieTree();
//        trieTree.insert("abc");
//        trieTree.insert("ab");
        trieTree.insert("cd");
        trieTree.insert("abc");
        System.out.println("abc添加次数："+trieTree.search("abc"));
        System.out.println("ac添加次数："+trieTree.search("ac"));
        System.out.println("以ab为前缀的字符串："+trieTree.trieStr("ab"));
        System.out.println("cd删除："+trieTree.delete("cd"));
        System.out.println("---------------------------------------");
    }
}