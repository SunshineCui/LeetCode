package com.billy.leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Billy_Cui on 2019/7/30.
 * Describe:
 */
public class RandomizedSet {

    private Map<Integer, Integer> indexValue;
    private Map<Integer, Integer> valueIndex;
    private int maxIndex;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        indexValue = new HashMap<>();
        valueIndex = new HashMap<>();
        maxIndex = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valueIndex.containsKey(val)) {
            return false;
        }
        valueIndex.put(val, maxIndex);
        indexValue.put(maxIndex, val);
        maxIndex++;
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valueIndex.containsKey(val)) {
            return false;
        }
        Integer index = valueIndex.get(val);
        if (index == maxIndex - 1) {
            indexValue.remove(index);
            valueIndex.remove(val);
        } else {
            //索引最后一个数
            Integer value = indexValue.get(maxIndex - 1);
            indexValue.put(index, value);
            valueIndex.remove(val);
            valueIndex.put(value,index);
        }
        maxIndex --;
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        int i = random.nextInt(maxIndex);
        return indexValue.get(i);
    }

}
