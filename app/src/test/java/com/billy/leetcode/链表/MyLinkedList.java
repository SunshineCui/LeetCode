package com.billy.leetcode.链表;

/**
 * Created by Billy_Cui on 2018/8/20
 * Describe:  单链表
 */

public class MyLinkedList {

     class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode temHead = head;
        for (int i = 0; i <= index; i++) {
            if (temHead == null ){
                return -1;
            }else if (i == index){
                return temHead.val;
            }
            temHead = temHead.next;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = head;
        head = listNode;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null){
            head = new ListNode(val);
            return;
        }
        ListNode temHead = head;
        while (temHead.next != null){
            temHead = temHead.next;
        }
        temHead.next = new ListNode(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode listNode = new ListNode(val);
        ListNode temHead = head;
        if (index == 0){
            listNode.next = temHead;
            head = listNode;
            return;
        }
        for (int i = 1; i <= index; i++) {
            if (temHead == null){
                return;
            }
            if (i == index){
                listNode.next = temHead.next;
                temHead.next = listNode;
                return;
            }
            temHead = temHead.next;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode temHead = head;
        for (int i = 0; i < index; i++) {
            if (temHead == null){
                break;
            }
            if (i == index-1){
                if (temHead.next!=null){
                    temHead.next = temHead.next.next;
                    return;
                }
            }
            temHead = temHead.next;
        }
    }


}
