package com.billy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Billy_Cui on 2018/8/2
 * Describe:
 */

public class LeetCode_18_8_2 {

//    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for(int i=0;i<nums.length;i++){
//            int subtract = target - nums[i];
//            for (int j = 0; j < nums.length ; j++) {
//                if (subtract == nums[j] && i != j){
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
//        return result;
//    }

    /**
     * 1. 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No tow sum  solution");
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 2. 两数相加
     *https://leetcode-cn.com/problems/add-two-numbers/solution/
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        ListNode previousListNode = null;
        int advance = 0;
        while (l1 != null || l2!=null) {
            int i = (l1==null?0:l1.val) + (l2==null?0:l2.val);
            if (advance > 0) {
                i += advance;
                advance = 0;
            }
        /**      可优化:
        * carry = sum / 10;
        * curr.next = new ListNode(sum % 10);
        */
            if (i > 9) {
                advance = 1;
                i -= 10;
            }
            if (listNode != null) {
                previousListNode.next = new ListNode(i);
                previousListNode = previousListNode.next;
            } else {
                listNode = new ListNode(i);
                previousListNode = listNode;
            }
            l1 = l1 == null?null:l1.next;
            l2 = l2 == null?null:l2.next;
        }
        if (advance > 0){
            previousListNode.next = new ListNode(1);
        }
        return listNode;
    }



}
