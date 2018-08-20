package com.billy.leetcode.数组和字符串;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Billy_Cui on 2018/8/2
 * Describe:
 */

public class 探索_数组 {

    /**
     * 寻找数组的中心索引
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int index = -1;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                leftSum += nums[i - 1];
            }
            rightSum -= nums[i];
            if (rightSum == leftSum) {
                return i;
            }
        }
        return index;
    }

    /**
     * 至少是其他数字两倍的最大数
     *
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        int max = 0;
        int secondMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[secondMax] || secondMax == max) {
                secondMax = i;
                if (nums[secondMax] > nums[max]) {
                    max = max ^ secondMax;
                    secondMax = max ^ secondMax;
                    max = max ^ secondMax;
                }
            }
        }
        if (nums[max] >= nums[secondMax] * 2 || max == secondMax) {
            return max;
        } else {
            return -1;
        }
    }

    /**
     * 加一
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int tem = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                tem = digits[i] + 1;
            } else {
                tem += digits[i];
            }
            if (tem / 10 > 0) {//需要进位
                digits[i] = tem % 10;
                tem = tem / 10;
            } else {
                digits[i] = tem;
                return digits;
            }
        }
        if (tem > 0) {
            int[] extend = new int[digits.length + 1];
            extend[0] = tem;
            for (int i = 1; i < extend.length; i++) {
                extend[i] = digits[i - 1];
            }
            return extend;
        }

        throw new IllegalArgumentException("无结果返回");
    }




    @Test
    public void main() {
        int[][] init = new int[3][4];
        init[0] = new int[]{1, 2, 3, 4};
        init[1] = new int[]{5, 6, 7, 8};
        init[2] = new int[]{9, 10, 11, 12};
//        init[3] = new int[]{13,14,15,16};
//        findDiagonalOrder(init);
//        System.out.print("index:" + dominantIndex(new int[]{3, 0, 0, 2}));
//        spiralOrder(init);
//        generate(5);
    }
}
