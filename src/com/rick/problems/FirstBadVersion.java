package com.rick.problems;

public class FirstBadVersion {

    public static void main(String[] args) {
        int n = 10;
        int res = new FirstBadVersion().new Solution().firstBadVersion(n);
        System.out.println(res);
    }

    class Solution extends VersionControl {

        public int firstBadVersion(int n) {
            int low = 1, high = n;
            while (low < high) {
                int med = low + (high - low) / 2;
                if (isBadVersion(med)) high = med;
                else low = med + 1;
            }
            return low;
        }
    }

    class VersionControl {

        private int firstBadVersion = 4;

        boolean isBadVersion(int version) {
            return firstBadVersion == version;
        }
    }
}

