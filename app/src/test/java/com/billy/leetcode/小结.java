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
     *  旋转数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] a, int start, int end){
        while (start < end){
            a[start] = a[start] ^ a[end];
            a[end] = a[start] ^ a[end];
            a[start] = a[start] ^ a[end];
            start++;
            end--;
        }
    }

    /**
     * 杨辉三角 II
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0){
            return list;
        }
        for (int i = 0; i < rowIndex +1; i++) {
           list.add(0,1);
            for (int j = 1; j < list.size()-1 ; j++) {
                list.set(j,list.get(j)+list.get(j+1));
            }
        }
        return list;
    }

    /**
     * 翻转字符串里的单词
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() ==0){
            return "";
        }
        String[] split = s.split(" ");
        int start = 0,end=split.length-1;
        String tem = "";
        while (start < end){
            tem = split[start] ;
            split[start] = split[end];
            split[end] = tem;
            start++;
            end--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            stringBuffer.append(split[i]!=" "?split[i]:"");
            if (i!=split.length-1){
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }


    @Test
    public void main(){
//        getRow(3);
        System.out.println(reverseWords("1 "));
    }

}
