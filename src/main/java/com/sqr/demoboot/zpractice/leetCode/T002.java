package com.sqr.demoboot.zpractice.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 * 2->4->3
 * 5->6->4
 * --------
 * 7->0->8
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class T002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1,l2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        ListNode node = l1;
        while (node!=null){
            num1.add(node.val);
            node = node.next;
        }
        node = l2;
        while (node!=null){
            num2.add(node.val);
            node = node.next;
        }
        List<Integer> relArray = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < Math.max(num1.size(),num2.size()) ; i++) {
            int t1=i<num1.size()?num1.get(i):0;
            int t2=i<num2.size()?num2.get(i):0;
            relArray.add(((t1+t2)+(flag?1:0))%10);
            flag=((t1+t2)+(flag?1:0))/10>0;
        }
        if (flag)relArray.add(1);
        System.out.println(relArray.toString());
        ListNode head = new ListNode();
        ListNode rel = head;
        for (int i = 0 ; i < relArray.size() ; i++) {
            rel.val = relArray.get(i);
            if (i!=relArray.size()-1){
                ListNode next = new ListNode();
                rel.next = next;
                rel = rel.next;
            }
        }
        return head;
    }
}
