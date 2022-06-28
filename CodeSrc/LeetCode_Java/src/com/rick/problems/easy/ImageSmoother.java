package com.rick.problems.easy;

import java.util.HashSet;
import java.util.Set;

public class ImageSmoother {

    public static void main(String[] args) {
        int[][] M = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};
        int[][] res = new ImageSmoother().imageSmoother(M);
        for (int[] arr : res) for (int i : arr) System.out.print(i + " ");
    }

    public int[][] imageSmoother(int[][] M) {
        // 求出圖片的長寬，也就是二維陣列的長寬
        int n = M.length, m = M[0].length, cnt;
        int[][] res = new int[n][m];
        int[][] dir = new int[][]{
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 0}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int i = 0; i < n; i++) {
            int[] labels = {0, 1, 2, 3, 4, 5, 6, 7, 8};

            // 上邊界
            if (i == 0) {
                labels[0] = -1;
                labels[1] = -1;
                labels[2] = -1;
            }

            // 下邊界
            if (i == n - 1) {
                labels[6] = -1;
                labels[7] = -1;
                labels[8] = -1;
            }

            for (int j = 0; j < m; j++) {
                int[] mLabels = labels.clone();

                // 左邊界
                if (j == 0) {
                    mLabels[0] = -1;
                    mLabels[3] = -1;
                    mLabels[6] = -1;
                }

                // 右邊界
                if (j == m - 1) {
                    mLabels[2] = -1;
                    mLabels[5] = -1;
                    mLabels[8] = -1;
                }

                cnt = 0;
                for (int l : mLabels) {
                    if (l == -1) continue;
                    int x = dir[l][0];
                    int y = dir[l][1];
                    cnt++;
                    res[i][j] += M[i + x][j + y];
                }

                res[i][j] /= cnt;
            }
        }
        return res;
    }

    public int[][] imageSmootherBruteForce(int[][] M) {
        int n = M.length, m = M[0].length, sum, cnt;
        int[][] res = new int[n][m];
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                sum = 0;
                cnt = 0;
                for (int k = 0; k < 9; k++)
                    if (0 <= i + dir[k][0] && i + dir[k][0] < n && 0 <= j + dir[k][1] && j + dir[k][1] < m) {
                        sum += M[i + dir[k][0]][j + dir[k][1]];
                        cnt++;
                    }
                res[i][j] = sum / cnt;
            }
        return res;
    }
}
