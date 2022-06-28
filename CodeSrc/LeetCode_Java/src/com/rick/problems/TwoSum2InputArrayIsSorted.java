package com.rick.problems;

public class TwoSum2InputArrayIsSorted {

    public static void main(String[] args) {
        int numbers[] = {2, 7, 11, 15}, target = 9;
        int[] res = new TwoSum2InputArrayIsSorted().twoSum(numbers, target);
        for (int i : res) System.out.println(i);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++)
            for (int j = i + 1; j < numbers.length; j++)
                if (target == (numbers[i] + numbers[j])) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                }
        return res;
    }
}
