package com.billy.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Billy_Cui on 2018/8/7
 * Describe:
 */

public class 探索_双指针 {

    /**
     * 反转字符串
     * @param s
     * @return
     */
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            stringBuffer.append(chars[chars.length-i-1]);
        }
        return stringBuffer.toString();
    }

    /**
     * 数组拆分 I
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }

    /**
     * 数组拆分 II
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length ; j++) {
                if (numbers[i]+numbers[j] == target){
                    return  new int[]{i+1, j+1};
                }
            }
        }
        return ints;
    }

    /**
     * 移除元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
    int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * 最大连续1的个数
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes  = 0;
        for (int i = 0; i < nums.length; i++) {
            int newOnes = 0;
            while (i<nums.length&&nums[i]==1){
                i++;
                newOnes++;
            }
            maxOnes = Math.max(maxOnes,newOnes);
        }
        return maxOnes ;
    }

    /**
     * 长度最小的子数组
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int minLength =Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int newLenth = 0;
            int sum = 0;
            int j=i;
            while(j<nums.length&&sum<s){
                sum += nums[j];
                newLenth++;
                j++;
            }
            if (sum >= s)
            minLength = Math.min(minLength, newLenth);
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }

    @Test
    public void main(){
        int[] ints = {2, 3, 1, 2, 4, 3};
        minSubArrayLen(7,ints);
    }
}
