package com.apptao.leetcode;

import java.util.LinkedList;

/**
 * Created by a on 2018-01-02.
 * <p>
 * 删除单向链表中的倒数第k 个元素
 */
public class LinkNodeKthTail {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);





        new LinkNodeKthTail().removeNthFromEnd(node1, 2);
    }



    /**
     * 方案一，，计算length ,在遍历设置数组
     * 亮点，使用LinkedList 缓存一下
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        LinkedList<Integer> ans = new LinkedList<>();
        ans.add(head.val);
        while (head.next != null) {
            head = head.next;
            ans.add(head.val);
        }
        ans.remove(ans.size() - n);
        ListNode p = new ListNode(0);
        ListNode q = p;
        for (int i = 0; i < ans.size(); i++) {
            q.next = new ListNode(ans.get(i));
            q = q.next;
        }
        return p.next;
    }

    /**
     * 双指针方案
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndtwoPoint(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


}
