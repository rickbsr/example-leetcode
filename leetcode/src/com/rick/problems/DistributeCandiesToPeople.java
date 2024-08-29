package com.rick.problems;

public class DistributeCandiesToPeople {

    public static void main(String[] args) {
        int candies = 10, num_people = 3;
        int[] res = new DistributeCandiesToPeople().distributeCandies(candies, num_people);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        for (int i = 0; candies > 0; candies -= i)
            res[i % num_people] += Math.min(candies, ++i);
        return res;
    }
}
