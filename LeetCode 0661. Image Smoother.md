# LeetCode 0661. Image Smoother
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Image Smoother](https://leetcode.com/problems/image-smoother/)

#### 難度：Easy

---

## 本文

#### 說明

題目會提供一個二維的整數陣列以模擬一張圖片的灰階表示圖，該陣列中的每個數值皆代表圖片對應的位置的灰階值。

而題目需求是將圖片進行平滑演算，意即要將每個像素點的數值修正為與鄰近九宮格的平均值，若該像素與其鄰近的像素未達八個，則盡可能計算所有符合需求的像素點，例如四個角落的像素點，又或是位於邊上的像素點。

題目提供的示意圖如下：

![](https://assets.leetcode.com/uploads/2021/05/03/smoother-grid.jpg)

###### 限制：陣列長寬的數值為「1 ~ 150」。
###### 限制：灰階值為「0 ~ 255」。

---

#### 解析一、暴力破解法

以這題來說，我們首先要知道的是「九宮格」的座標推算方式。

為了方便演示，我們將「九宮格」的方格中分別標上「索引值」，並在「索引值」下方標示該「九宮格」的相對座標；假設「目標像素點」，也就是「中心座標」是「（x, y）」，那麼其「九宮格」的示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0661_9square_division.png?raw=true)

而本題的問題在於並不是所有的「像素點」都擁有完整的「九宮格」；事實上，在一張四邊形的相片中，其多數的「像素點」都是擁有完整「九宮格」的；只有兩種情況可能會出現九宮格殘缺的情況；一種是，位於「角落」的像素點，而另外一種是位於「邊界上」的像素點，如下圖：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0661_9square_division_3type.png?raw=true)

圖中，「藍色部分」就是擁有完整「九宮格」的像素點，而「紅色部分」因為位於「角落」的位置，僅會擁有四格，最後是「綠色部分」，位於「邊界上」的像素點，擁有六格。

而「暴力破解法」的思路就是將每個「像素點」逐一計算，因此，起手式是就是「雙層迴圈」；將所有的「像素點」逐一遍歷，然後針對每個「像素點」的「九宮格」進行計算，但由於不是每個「像素點」都擁有完整的「九宮格」，因此，我們必須針對例外進行處理，完整程式碼如下：

```java
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length, sum, pixelCounts;
        int[][] res = new int[m][n];
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                // Calc Smoother Value
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
```

上述的代碼雖非常直觀，核心代碼在「第二層迴圈」內。

在「第三層迴圈」中，會將「九宮格」根據「座標」依序遍歷一次；而「if」判斷式的目的是排除「座標」經計算後，其位置「小於零或大於邊界」的部分。

---

#### 解析二、標記法

事實上，「標記法」的概念也跟「暴力破解法」類似；與之不同的是，在「暴力破解法」中，「標記法」是在進入「九宮格」遍歷前就先將殘缺的部分標記。

而先前我們說，「九宮格殘缺」的情況只會發生在「角落」與「邊界上」，所以我們只須判斷「目標像素點」是否位於「角落」或「邊界上」即可。

因此我們會將位於「邊界上」的「像素點」，排除其「邊界外」部分，即座標「x」等於「0」時的「左方邊界」；「x」等於「Col」時的「右方邊界」；「y」等於「0」時的「上方邊界」，以及「y」等於「Row」時的「下方邊界」，如下圖：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0661_9square_division_boundary.png?raw=true)

接著是位於「角落」的「像素點」，事實上，這部分就不需要再額外排除了，因為「角落」即位於「兩邊界」的交界處，也就是說，當我們在排除「邊界例外」時，就會一併將「角落例外」也排除了，完整程式碼如下：

```java
class Solution {
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
```

---

#### 解析三、加框法

最後是「加框法」，其實就是逆向邏輯。

事實上，「殘缺九宮格」僅會在圖形最外框發生，也就是邊界處；所以，反向操作，我們就將該「圖形」外加一層邊界，如此一來，就不須要再考慮「IndexOutOfBoundsException」的情形會發生，示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0661_9square_frame.png?raw=true)

其程式碼如下：

```java
class Solution {
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
```

上面代碼有幾處可能要稍微注意一下，由於「int」陣列的預設值為「0」，而像素的數值為「0」到「255」；但因為程式邏輯，在程式後面會利用「0」來做例外判斷，所以為了避免衝突，我們應將陣列的預設值改成「-1」；但如此一來，我們就須要對「tempImg」逐一賦值，略顯麻煩。

因此筆者這邊利用一點巧思，改將「img」的值再「Mapping」時加「1」，其原理異曲同工，只是有一點要特別注意，就是在返回要將多加的「1」扣除。

---

###### tags: `LeetCode` `Easy`