package com.rick.problems;

public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 0, 0};
        new DuplicateZeros().duplicateZeros(arr);
        for (int i : arr) System.out.print(i + " ");
    }

    public void duplicateZeros(int[] arr) {
        for (int sample[] = arr.clone(), i = 0, j = 0; j < arr.length; arr[j++] = sample[i++])
            if (sample[i] == 0 && j < arr.length - 1) arr[j++] = 0;
    }
}
