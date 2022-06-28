package com.rick.problems;

import java.util.Arrays;

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

public class DesignHashMap {

    public static void main(String[] args) {
        int key = 2, value = 50;
        MyHashMap obj = new MyHashMap();
        obj.put(key, value);

        int param_2 = obj.get(key);
        System.out.println(param_2);
        obj.remove(key);
        int param_3 = obj.get(key);
        System.out.println(param_3);
    }
}

class MyHashMap {

    private int[] arr;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        arr = new int[1_000_000 + 1];
        Arrays.fill(arr, -1);
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        arr[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return arr[key];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        arr[key] = -1;
    }
}

