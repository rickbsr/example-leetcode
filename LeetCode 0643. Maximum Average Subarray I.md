# LeetCode 0643. Maximum Average Subarray I
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們一個整數「k」以及一個由「n」個元素所組成的整數數列「nums」；而題目的要求是要我們找出在該數列中連續「k」個元素數的「最大平均值」。

###### 限制：整數數列「nums」的長度為「n」。

---

#### 解析一、暴力破解法

開工！首先是「暴力破解法」。

老樣子，「雙層迴圈」的結構，其思路為，「外層迴圈」指向連續「k」的元素的起始索引，而「內層迴圈」則是計算連續「k」個元素的「總和」；然後逐一比較，擇其大者，程式碼如下：

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int tempSum, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            tempSum = 0;
            for (int j = 0; j < k; j++) tempSum += nums[i + j];
            maxSum = Math.max(maxSum, tempSum);
        }
        return ((double) maxSum) / k;
    }
}
```

在上述代碼中，外層的迴圈是針對「整個數列」遍歷，當中，目的是找出所有不同的連續「k」個元素，從索引「`0`」至「`k - 1`」、「`1`」至「`k`」⋯，一直到「`n - k`」至「`nums.length - k`」，示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0643_maximum_average_subarray_i_nk.png?raw=true)

而「內層迴圈」的目的是計算連續「k」個元素的「總和」。

但為什麼是「總和」，而不是「平均值」呢？

原因其實很簡單，因為「最大平均值」也意味著其也是「最大總和」，但「平均值」等於「總和」除以「k」，所以與其在每次迴圈中都要計算一次「平均」，不如在迴圈內時，僅比較總和，等到最後要返回時，再計算其平均；如此一來，就可以省去多次計算平均的步驟。

接著，當所有可能的連續「k」個元素的總和都被比較過以後，最後再將「最大總和」除以「k」後返回，就完成了。

但當筆者將代碼放到「LeetCod」上執行，顯示如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0643_maximum_average_subarray_i_error.png?raw=true)

無法通過，原因是「Time Limit Exceeded」，呃⋯，「暴力破解」的效能本來就是爛啊！

但代碼應該是沒問題的，事實上，在數年前筆者曾以同樣的代碼在「LeetCod」上執行並且「通過」，這到底是什麼巫術！幹！

---

#### 解析二、差異法

竟然「暴力破解法」，就想辦法優化吧！

在前面我們說過，在整數數列中，連續「k」個總和，其依序是從索引「`0`」至「`k - 1`」、「`1`」至「`k`」⋯，一直到「`n - k`」至「`nums.length - k`」；那其每一組連續「k」個總和的差異是什麼？

假設第一組的連續「k」個總和，我們稱為「1st k-subarray」，而第二組的連續「k」個總和，我們稱為「2nd k-subarray」，第三組的連續「k」個總和⋯，以此類推，因此，最後一組的連續「k」個總和，我們稱為「`(n - k + 1)th` k-subarray」，如下圖：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0643_maximum_average_subarray_i_diff.png?raw=true)

觀察上圖，我們就會發現，其每一組之間的差異都是差了「k」個索引，例如「1st k-subarray」減去「`nums[0]`」，再加上「`nums[k]`」就等於「2nd k-subarray」，而「2nd k-subarray」減去「`nums[1]`」，再加上「`nums[k + 1]`」就等於「3rd k-subarray」⋯，以此類推；而這就是「差異法」的解題關鍵；簡單的說，就是「差異法」不再是一個一個的將所有的「k-subarray」加總比較；而是直接去比較每個「k-subarray」差異的部分。

實作的程式碼如下：

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int tempSum = 0, maxSum;
        for (int i = 0; i < k; i++) tempSum += nums[i]; // 建立基準值

        maxSum = tempSum;
        for (int i = k; i < nums.length; i++) {
            tempSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, tempSum);
        }
        return ((double) maxSum) / k;
    }
}
```

上述代碼中，我們以「1st k-subarray」的總和作為基準值；而這樣設計的好處就是可以省去「暴力破解法」代碼中的「內迴圈加總」的部分，從原本的「雙層迴圈」結構變成「兩次迴圈」。

同樣將代碼放到「LeetCode」上執行，結果「輕鬆通過」，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0643_maximum_average_subarray_i_pass.png?raw=true)

由此可見，「兩次迴圈」遠比「雙層迴圈」有效率許多；那能不能「一個迴圈」呢？

事實上是可以的，同樣是以「差異法」的思路，我們只是將「第一個迴圈」，也就是建立基準值的部分與比較差異的部分合併處理而已，代碼如下：

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int tempSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            tempSum += (i <= k - 1) ? nums[i] : nums[i] - nums[i - k];
            if (i >= k - 1 && tempSum > maxSum) maxSum = tempSum;
        }
        return ((double) maxSum) / k;
    }
}
```

收工！

---

###### tags: `leetcode` `java` `easy`