package com.billy.leetcode.链表;

import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.billy.leetcode.B;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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


    /**
     * 删除链表的倒数第N个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int count = 0;
        ListNode next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        while (next != null) {
            map.put(count, next);
            count++;
            next = next.next;
        }
        //如果是第一个
        if (count - n == 0) {
            return head.next;
        }
        //拿前一个节点
        ListNode listNode = map.get(count - n - 1);
        listNode.next = listNode.next.next;
        return head;
    }


    /**
     * 一次遍历算法
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        //提前拉开 n 的距离
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        //第一个链表结束时，第二个正好是倒数n
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode next;
        ListNode prev = null;
        while (cur != null) {
            if (cur.next == null) {
                cur.next = prev;
                break;
            }
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return cur;
    }

    /**
     * 移除链表元素
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode next = new ListNode(0);
        next.next = head;
        head = next;
        ListNode prev = null;
        while (next != null && next.next != null) {
            if (next.next.val == val) {
                next.next = next.next.next;
                continue;
            }
            next = next.next;
        }
        return head.next;
    }

    /**
     * 奇偶链表
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode ji = head, ou = head.next;
        for (int i = 2; ou.next != null; i++) {
            if (i % 2 == 0) {
                ListNode temp = ji.next;
                ji.next = ou.next;
                ou.next = ou.next.next;
                ji.next.next = temp;
                ji = ji.next;
            } else {
                ou = ou.next;
            }
        }
        return head;
    }

    @Test
    public void mainB() {
        new B();
    }

    /**
     * 回文链表
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }


    /**=========================================== 小结 ================================================*/
    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head;
    }

    /**
     * 两数相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        int mod = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);
            int i = (l1.val + l2.val + mod) % 10;
            mod = (l1.val + l2.val + mod) / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        if (mod > 0)
            cur.next = new ListNode(mod);
        return listNode.next;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    /**
     * 扁平化多级双向链表
     *
     * @param head
     * @return Node cur = head;
     * while (cur != null) {
     * if (cur.child != null) {
     * Node next = cur.next;
     * Node child = flatten(cur.child);
     * cur.child = null;
     * cur.next = child;
     * child.prev = cur;
     * Node tail = child;
     * while (tail.next != null) tail = tail.next;
     * tail.next = next;
     * if (next != null) next.prev = tail;
     * cur = next;
     * } else cur = cur.next;
     * }
     * return head;
     */
    public Node flatten(Node head) {
        Node result = head;
        if (head != null)
            nextNode(head);
        return result;
    }

    private Node nextNode(Node head) {
        if (head.child == null) {
            if (head.next == null) return head;
            return nextNode(head.next);
        }
        Node next = head.next;
        head.next = head.child;
        head.child.prev = head;
        head.child = null;
        Node node = nextNode(head.next);
        if (next == null) return node;
        node.next = next;
        next.prev = node;
        return nextNode(next);
    }


    /**
     * 旋转链表
     *
     * @param head
     * @param k
     * @return
     */
//    public ListNode rotateRight(ListNode head, int k) {
//
//    }
    @Test
    public void main() {

        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(1);
        ListNode ln3 = new ListNode(2);
        ListNode ln4 = new ListNode(1);
//        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
//        ln4.next = ln5;

        isPalindrome(ln1);


//        SparseArray array = new SparseArray();

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

//        getIntersectionNode(new ListNode(1), new ListNode(2));
    }

    @Test
    public void test(){
        int solution = solution(32);
        System.out.println(solution);
    }
    public int solution(int N) {
        int max = 0,count = -1;
        while (N > 0) {
            int remainder = N % 2;
            if (remainder == 1 ) {
                if (count > 0){
                    max = Math.max(count, max);
                    count = 0;
                }else {
                    count = 0;
                }
            } else {
                if (count > -1) count++;
            }
            N = N / 2;
        }
        return max;
    }
}
