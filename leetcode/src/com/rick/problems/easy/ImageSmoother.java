package com.rick.problems.easy;

import static com.rick.constant.Constant.BLANK_STRING;

public class ImageSmoother {

    public static void main(String[] args) {
        int[][] img = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}}, res;
        res = new ImageSmootherBruteForce().imageSmoother(img);
        res = new ImageSmootherLabel().imageSmoother(img);
        res = new ImageSmootherFrame().imageSmoother(img);
        for (int[] arr : res) {
            for (int i : arr) System.out.print(i + "\t" + BLANK_STRING);
            System.out.println();
        }
    }
}

/**
 * 方式一、暴力演算法
 */
class ImageSmootherBruteForce {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length, sum, pixelCounts;
        int[][] res = new int[m][n];
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                sum = 0;
                pixelCounts = 0;
                for (int k = 0; k < 9; k++)
                    if (0 <= i + dir[k][0] &&
                            i + dir[k][0] < m &&
                            0 <= j + dir[k][1] &&
                            j + dir[k][1] < n) {
                        sum += img[i + dir[k][0]][j + dir[k][1]];
                        pixelCounts++;
                    }
                res[i][j] = sum / pixelCounts;
            }
        return res;
    }
}

/**
 * 方式二、標記法
 */
class ImageSmootherLabel {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length, pixelCounts;
        int[][] res = new int[m][n];
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int i = 0; i < m; i++) {
            int[] labels = {0, 1, 2, 3, 4, 5, 6, 7, 8};

            if (i == 0) {
                labels[0] = -1;
                labels[1] = -1;
                labels[2] = -1;
            }

            if (i == m - 1) {
                labels[6] = -1;
                labels[7] = -1;
                labels[8] = -1;
            }

            for (int j = 0; j < n; j++) {
                int[] mLabels = labels.clone();

                if (j == 0) {
                    mLabels[0] = -1;
                    mLabels[3] = -1;
                    mLabels[6] = -1;
                }

                if (j == n - 1) {
                    mLabels[2] = -1;
                    mLabels[5] = -1;
                    mLabels[8] = -1;
                }

                pixelCounts = 0;
                for (int l : mLabels) {
                    if (l == -1) continue;
                    int x = dir[l][0];
                    int y = dir[l][1];
                    pixelCounts++;
                    res[i][j] += img[i + x][j + y];
                }

                res[i][j] /= pixelCounts;
            }
        }
        return res;
    }
}

/**
 * 方式三、加框法
 */
class ImageSmootherFrame {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length, sum, pixelCounts;
        int[][] tempImg = new int[m + 2][n + 2], res = new int[m][n];
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                // Mapping 時，加 1
                tempImg[i + 1][j + 1] = img[i][j] + 1;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                sum = 0;
                pixelCounts = 0;
                for (int k = 0; k < 9; k++) {
                    int tempVal = tempImg[i + 1 + dir[k][0]][j + 1 + dir[k][1]];
                    if (tempVal != 0) {
                        sum += tempVal;
                        pixelCounts++;
                    }
                }
                // 扣除 1
                res[i][j] = sum / pixelCounts - 1;
            }
        return res;
    }
}