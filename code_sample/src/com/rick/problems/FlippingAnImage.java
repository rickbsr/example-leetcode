package com.rick.problems;

public class FlippingAnImage {

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        int[][] res = new FlippingAnImage().flipAndInvertImage(A);
        for (int[] ints : res) {
            for (int i : ints) {
                System.out.print(i + "");
            }
            System.out.println();
        }
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] ints : A) {
            reverse(ints);
            invert(ints);
        }
        return A;
    }

    private void reverse(int[] ints) {
        for (int i = 0, len = ints.length; i < len / 2; i++) {
            int temp = ints[i];
            ints[i] = ints[(len - 1) - i];
            ints[(len - 1) - i] = temp;
        }
    }

    private void invert(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            ints[i] ^= 1;
        }
    }
}
