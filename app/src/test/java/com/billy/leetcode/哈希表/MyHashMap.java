package com.billy.leetcode.哈希表;

/**
 * Created by Billy_Cui on 2019/6/13.
 * Describe:
 */
public class MyHashMap {

    int[] collection ;

    public MyHashMap() {
        collection = new int[1000001];
        for (int i = 0; i < collection.length; i++) {
            collection[i] = -1;
        }
    }

    public void put(int key,int value) {
//        if (key < 0 || key > 1000000)return;
        int index = key % 1000000;
        collection[index] = value;
    }

    public void remove(int key) {
//        if (key < 0 || key > 1000000)return;
        int index = key % 1000000;
        collection[index] = -1;
    }

    /** Returns true if this set contains the specified element */
    public int get(int key) {
//        if (key < 0 || key > 1000000)return false;
        int index = key % 1000000;
        return collection[index];
    }
}
