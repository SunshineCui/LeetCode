package com.billy.leetcode.链表;

import android.util.SparseArray;

import org.junit.Test;

import java.util.HashSet;

/**
 * Created by Billy_Cui on 2018/8/20
 * Describe:
 */

public class test {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 双指针
     * 环形链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * hash值
     * 环形链表 II
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode tem = head;
        while (tem != null) {
            if (hashSet.contains(tem)) {
                return tem;
            } else {
                hashSet.add(tem);
            }
            tem = tem.next;
        }
        return null;
    }

    /**
     * 相交链表
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode temA = headA;
        ListNode temB = headB;
        while (temA != temB) {
            temA = temA == null ? headB : temA.next;
            temB = temB == null ? headA : temB.next;
        }
        return temA;
    }

    @Test
    public void main() {

        SparseArray array = new SparseArray();

//        MyLinkedList obj = new MyLinkedList();
//        obj.addAtHead(1);
//        obj.addAtTail(3);
//        obj.addAtIndex(1, 2);
//        int param_1 = obj.get(1);
//        obj.deleteAtIndex(1);
//        int param_2 = obj.get(1);
//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        System.out.println(hasCycle(listNode));

        getIntersectionNode(new ListNode(1),new ListNode(2));
    }
}
