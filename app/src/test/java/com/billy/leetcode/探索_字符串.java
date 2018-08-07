package com.billy.leetcode;

import org.junit.Test;

/**
 * Created by Billy_Cui on 2018/8/6
 * Describe:
 */

public class 探索_字符串 {


    //二进制求和
    public String addBinary(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int[] result = new int[Math.max(aChar.length,bChar.length)];
        int carry = 0;
        for (int i = 0; i <  Math.max(aChar.length,bChar.length) ; i++) {
            int aTem = 0,bTem = 0;
            if (i<aChar.length) {
                 aTem = aChar[aChar.length - i - 1] - '0';
            }
            if (i<bChar.length) {
                 bTem = bChar[bChar.length - i - 1] - '0';
            }
            int j = aTem + bTem + carry;
            result[i] = j%2;
            carry = j/2;
        }
        StringBuffer stringBuffer = new StringBuffer();

        if (carry == 1){
            stringBuffer.append(1);
        }
        for (int i = result.length-1; i >=0 ; i--) {
            stringBuffer.append(result[i]);
        }
        return stringBuffer.toString();
    }

    /**
     * 实现strStr()
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)){
            return 0;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int record = -1;
        for (int i = 0; i < haystackChars.length; i++) {
            if (haystackChars[i]  == needleChars[0] && haystackChars.length-i >= needleChars.length) {
                record = i;
                for (int j = 0; j < needleChars.length; j++) {
                    if (haystackChars[i+j] != needleChars[j]){
                        record = -1;
                        break;
                    }
                    if (j == needleChars.length-1 && record > -1){
                        return record;
                    }
                }
            }
        }
        return record;
    }

    /**
     *   最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean record = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i){
                    return stringBuffer.toString();
                }
                if (c != strs[j].charAt(i)){
                    record = false;
                    return stringBuffer.toString();
                }
            }
            if (record){
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    @Test
    public void main(){
//        System.out.println(addBinary("11","1"));
//        System.out.println(strStr("hello","ll"));
        System.out.println(longestCommonPrefix(new String[]{"aaa", "aa", "aaa"}));
    }

}
