package com.rick.problems;

public class GuessNumberHigherOrLower extends GuessGame {

    public static void main(String[] args) {
        int n = 100;
        int res = new GuessNumberHigherOrLower().guessNumber(n);
        System.out.println(res);
    }

    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            switch (guess(mid)) {
                case 0:
                    return mid;
                case 1:
                    low = mid + 1;
                    break;
                case -1:
                    high = mid - 1;
            }
        }
        return low;
    }
}

class GuessGame {
    int pickedNum = 30;

    int guess(int num) {
        if (pickedNum != num) return num < pickedNum ? -1 : 1;
        return 0;
    }
}