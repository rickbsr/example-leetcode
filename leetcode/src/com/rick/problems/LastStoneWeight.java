package com.rick.problems;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {7, 6, 7, 6, 9};
        int res = new LastStoneWeight().lastStoneWeight(stones);
        System.out.println(res);
    }

    public int lastStoneWeight(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : A) pq.offer(i);
        for (int i = 0; i < A.length - 1; ++i)
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }
}
