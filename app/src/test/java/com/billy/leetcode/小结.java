package com.billy.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Billy_Cui on 2018/8/14
 * Describe:
 */

public class 小结 {

    /**
     * 旋转数组
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] a, int start, int end) {
        while (start < end) {
            a[start] = a[start] ^ a[end];
            a[end] = a[start] ^ a[end];
            a[start] = a[start] ^ a[end];
            start++;
            end--;
        }
    }

    /**
     * 杨辉三角 II
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) {
            return list;
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    /**
     * 翻转字符串里的单词
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] split = s.split(" ");
        int start = 0, end = split.length - 1;
        String tem = "";
        while (start < end) {
            tem = split[start];
            split[start] = split[end];
            split[end] = tem;
            start++;
            end--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            stringBuffer.append(split[i] != " " ? split[i] : "");
            if (i != split.length - 1) {
                stringBuffer.append(" ");
            }
        }
        String string = stringBuffer.toString();
        System.out.println(string.length());
        return string;
    }


    /**
     * 反转字符串中的单词 III
     *
     * @param s
     * @return
     */
    public String reverseWordsIII(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isSpaceChar(chars[i])) {
                reverse(chars, start, i-1);
                start = i + 1;
            }
            if (i == chars.length - 1) {
                reverse(chars, start, i);
            }
        }
        return String.copyValueOf(chars);
    }

    public void reverse(char[] a, int start, int end) {
        while (start < end) {
            char tem;
            tem = a[start];
            a[start] = a[end];
            a[end] = tem;
            start++;
            end--;
        }
    }


    /**
     *
     *
     public int removeDuplicates(int[] nums) {
     if (nums.length == 0) return 0;
     int i = 0;
     for (int j = 1; j < nums.length; j++) {
     if (nums[j] != nums[i]) {
     i++;
     nums[i] = nums[j];
     }
     }
     return i + 1;
     }
     * 删除排序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            boolean repeat = false;
            for (int j = 0; j <= start; j++) {
                if (nums[j] == nums[i]){
                    repeat = true;
                    break;
                }
            }
            if (!repeat){
                start++;
//                nums[start] = nums[start] ^ nums[i];
//                nums[i] = nums[start] ^ nums[i];
//                nums[start] = nums[start] ^ nums[i];
                int tem;
                tem = nums[start];
                nums[start] = nums[i];
                nums[i] = tem;
            }
        }
        return start+1;
    }


    /**
     * 移动零
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int end = nums.length;
        for (int i = 0; i < end;) {
            if (nums[i] == 0){
                end--;
                reverse(nums,i,end);
                reverse(nums,i,end-1);
            }else {
                i++;
            }
        }
    }

    @Test
    public void main() {
//        getRow(3);
//        System.out.println(reverseWords("1 ") + ".");
//        System.out.println(removeDuplicates(new int[]{1,1,2}));
        moveZeroes(new int[]{0,0,1});
    }

}
