package com.rick.problems.easy;

import java.util.*;

public class NRepeatedElementInSize2NArray {

    public static void main(String[] args) {
        int[] A = {2, 6, 2, 1};
        int res = new NRepeatedElementInSize2NArray().repeatedNTimes(A);
        System.out.println(res);
    }

    public int repeatedNTimes(int[] A) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (!list.contains(A[i])) list.add(A[i++]);
        return A[i];
    }

    public int repeatedNTimesBySet(int[] A) {
        Set<Integer> set = new HashSet<>();
        int i = 0, size = set.size();
        do set.add(A[i++]);
        while (set.size() != size++);
        return A[i - 1];
    }

    public int repeatedNTimesByMap(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) if (map.put(i, 1) != null) return i;
        return -1;
    }

    public int repeatedNTimesBySoft(int[] A) {
        Arrays.sort(A);
        return A[A[0] != A[A.length / 2 - 1] ? A.length / 2 : 0];
    }

    public int repeatedNTimesBySoft2(int[] A) {
        Arrays.sort(A);
        return A[A[A.length - 1] != A[A.length / 2] ? A.length / 2 - 1 : A.length - 1];
    }

    public int repeatedNTimesBySoftForDetail(int[] A) {
        Arrays.sort(A);
        int len = A.length, halfOfLen = len / 2;
        if (A[halfOfLen - 1] == A[halfOfLen]) return A[halfOfLen];
        else if (A[0] == A[halfOfLen - 1]) return A[0]; // 狀況 1
        else if (A[len - 1] == A[halfOfLen]) return A[len - 1]; // 狀況 4
        return -1;
    }
}
