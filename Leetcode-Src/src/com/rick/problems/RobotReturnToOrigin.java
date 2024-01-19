package com.rick.problems;

public class RobotReturnToOrigin {

    public static void main(String[] args) {
        String moves = "UDRL";
        boolean res = new RobotReturnToOrigin().judgeCircle(moves);
        System.out.println(res);
    }

    public boolean judgeCircle(String moves) {
        int upDown = 0, leftRight = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    upDown++;
                    break;
                case 'D':
                    upDown--;
                    break;
                case 'R':
                    leftRight++;
                    break;
                case 'L':
                    leftRight--;
                    break;
            }
        }
        return upDown == 0 && leftRight == 0;
    }
}
