package com.sqr.demoboot.zpractice.designPatterns.h_composite;

import java.util.ArrayList;
import java.util.List;

abstract class Node{
    public abstract void print();
}
/*叶子节点*/
class LeafNode extends Node{
    String content;

    public LeafNode(String content) {
        this.content = content;
    }
    @Override
    public void print() {
        System.out.println(content);
    }
}
/*枝干节点*/
class BranchNode extends Node {
    String content;
    List<Node> nodes = new ArrayList<>();

    public BranchNode(String content) {
        this.content = content;
    }

    public void add(Node node){
        nodes.add(node);
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}
public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        LeafNode l1 = new LeafNode("L1");
        LeafNode l2 = new LeafNode("L2");
        LeafNode l3 = new LeafNode("L3");
        BranchNode b1 = new BranchNode("b1");
        BranchNode b2 = new BranchNode("b2");
        root.add(b1);
        root.add(b2);
        b1.add(l1);
        b2.add(l2);
        b2.add(l3);
        tree(root);
        treeShape(root,0);
    }
    private static void tree(Node node){
        node.print();
        if (node instanceof BranchNode){
            for (int i=0 ; i<((BranchNode) node).nodes.size() ; i++){
                tree(((BranchNode) node).nodes.get(i));
            }
        }
    }
    private static void treeShape(Node node,int depth){
        for (int i=0 ; i<depth ; i++) System.out.print("--");
        node.print();
        if (node instanceof BranchNode){
            for (int i=0 ; i<((BranchNode) node).nodes.size() ; i++){
                treeShape(((BranchNode) node).nodes.get(i),depth++);
            }
        }
    }
}
