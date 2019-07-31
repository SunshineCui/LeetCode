package com.billy.leetcode.哈希表;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by Billy_Cui on 2019/6/13.
 * Describe:
 */
public class test {

    @Test
    public void main() {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 349. 两个数组的交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> result = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        int[] res = new int[result.size()];
        int count = 0;
        for (Integer integer : result) {
            res[count] = integer;
            count++;
        }
        return res;
    }

    /**
     * 快乐数
     *
     * @param n
     * @return
     */
    List<Integer> nums = new ArrayList<>();

    public boolean isHappy(int n) {

        if (nums.contains(n)) {
            return false;
        }
        nums.add(n);
        int sum = 0;
        while (n / 10 != 0) {
            int unit = n - (n / 10) * 10;
            sum += (int) Math.pow(unit, 2);
            n /= 10;
        }
        sum += (int) Math.pow(n, 2);
        if (sum == 1) {
            return true;
        } else {
            return isHappy(sum);
        }
    }

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length -1; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//       throw  new IllegalArgumentException("No two sum solution");

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 同构字符串
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
//        Map<Character, Character> map = new HashMap<>();
//        if (s.length() != t.length()) return false;
//        for (int i = 0; i < s.length(); i++) {
//            char ss = s.charAt(i);
//            char tt = t.charAt(i);
//            if (map.containsKey(ss)) {
//                if (map.get(ss) != tt) return false;
//            } else {
//                if (map.containsValue(tt)) return false;
//                map.put(ss, tt);
//            }
//        }
//        return true;
        HashMap<Character, Character> map = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if (map.containsKey(ss)) {
                if (!map.get(ss).equals(tt)) return false;
            } else if (map.containsValue(tt)) return false;
            map.put(ss, tt);
        }
        return true;
    }

    /**
     * 两个列表的最小索引总和
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if (i + j < min) {
                    res.clear();
                    res.add(list2[i]);
                    min = i + j;
                } else if (i + j == min) {
                    res.add(list2[i]);
                }
            }
        }

        return res.toArray(new String[res.size()]);
    }

    /**
     * 字符串中的第一个唯一字符
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (map.containsKey(charAt)) {
                map.put(charAt, -1);
            } else {
                map.put(charAt, i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) > -1) return i;
        }
        return -1;
    }

    /**
     * 两个数组的交集 II
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] ints = new int[list.size()];
        int n = 0;
        for (Integer integer : list) {
            ints[n++] = integer;
        }
        return ints;
    }


    /**
     * 存在重复元素 II
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
//        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }


    /**
     * 字母异位词分组
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String sortStr = sort(strs[i]);
            if (map.containsKey(sortStr)) {
                Integer index = map.get(sortStr);
                list.get(index).add(strs[i]);
            } else {
                map.put(sortStr, list.size());
                ArrayList<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                list.add(strings);
            }
        }
        return list;
    }

    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    /**
     * 有效的数独
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Map<String, Boolean> map = new HashMap<>(9 * 9 * 3);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                String rowKey = i + "row" + c;
                String colKey = j + "col" + c;
                int groupIndex = i / 3 * 3 + j / 3;
                String groupKey = groupIndex + "group" + c;
                if (map.getOrDefault(rowKey, false)
                        || map.getOrDefault(colKey, false)
                        || map.getOrDefault(groupKey, false)) return false;

                map.put(rowKey, true);
                map.put(colKey, true);
                map.put(groupKey, true);
            }
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 寻找重复的子树
     *
     * @param root
     * @return
     */
    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return res;
        printTree(root);
        return res;
    }

    private String printTree(TreeNode root) {
        if (root == null) return "#";
        String treeStr = root.val + printTree(root.left) + printTree(root.right);
        if (!map.containsKey(treeStr)) {
            map.put(treeStr, 1);
        } else if (map.get(treeStr) == 1) {
            res.add(root);
            map.put(treeStr, 2);
        }
        return treeStr;
    }

    /**
     * 宝石与石头
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) return 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.toCharArray().length; i++) {
            set.add(J.charAt(i));
        }
        char[] chars = S.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                count++;
            }
        }
        return count;
    }

    /**
     * 无重复字符的最长子串
     *
     * @param s
     * @return aab
     */
    public int lengthOfLongestSubstring(String s) {
//        char[] chars = s.toCharArray();
////        int max = 0,count =0;
////        Map<Character,Integer> map = new HashMap<>();
////        for (int i = 0; i < chars.length; i++) {
////            char c = chars[i];
////            if (!map.containsKey(c)){//没有重复
////                map.put(c,i);
////                count++;
////                max = Math.max(count,max);
////            }else {//有重复
////                count =1;
////                Integer pro_index = map.get(c);
////                max = Math.max(i- pro_index,max);
////                map.get()
////                map.put(c,i);
////            }
////        }
////        return max;
//        char[] chars = s.toCharArray();
//        Map<Character,Integer> map = new HashMap<>();
//        int i = 0,previous=0,max=0,count=0;
//       while (i<chars.length){
//           char key = chars[i];
//           if (map.containsKey(key)){
//               map.clear();
//               for (int j = previous+1; j <= i; j++) {
//                   map.put(chars[j],j);
//               }
//           }else {
//               map.put(key,i);
//               i++;
//           }
//       }
//        return 0;

        int     i = 0,
                flag = 0,
                length = 0,//两个索引的间隔
                result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i), flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }

//    @Test
//    public void test() {
//        lengthOfLongestSubstring("abba");
//    }

    /**
     * 四数相加 II
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(sum)){
                    map.put(sum,map.get(sum)+1);
                }else {
                    map.put(sum,1);
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int sum = -(C[i] + D[j]);
                if (map.containsKey(sum)){
                    count += map.get(sum);
                }
            }
        }
        return count;
    }


    /**
     * 前 K 个高频元素    ,用到了 PriorityQueue
     * @param nums
     * @param k 出现频率前 k 高
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        final Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });

        for (Integer key : map.keySet()) {
            if (pq.size() < k){
                pq.add(key);
            }else if (map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.remove());
        }
        return res;
    }


    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int end = nums.length-1;
        int start = 0;
        while(start <= end){
            int mid = (end+start)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }


    /**
     * x 的平方根
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x==0)return 0;
        long start = 0;
        long end = x/2;
        while (start < end){
            long mid = (start + end +1) >> 1;
            long i = mid * mid;
            if (i == x){
                return (int) mid;
            }else if (i<x){
                start = mid;
            }else {
                end = mid -1;
            }
        }
        return (int) start;
    }

}
