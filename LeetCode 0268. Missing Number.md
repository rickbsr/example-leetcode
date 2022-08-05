# LeetCode 0268. Missing Number
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode-rick.jpeg?raw=true)

---

## 概要

#### 題目：[Missing Number](https://leetcode.com/problems/missing-number/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們一長度為「n」的整數數列，其內容為不重覆之「0」到「n」的整數，但因為陣列長度的限制，「0」到「n」之中會有一個「正整數」沒有被放到「數列」中；而題目的要求，就是要我們找出該整數。

###### 限制：所有整數皆為「唯一」存在。

---

#### 解析一、排序法

這題其實與「[Single Number](https://leetcode.com/problems/single-number/)」、「[Find the Difference](https://leetcode.com/problems/find-the-difference/)」⋯等類型的題目類似；所以解題思路也相對雷同；首先是「排序法」，在題目敘述中，我們可以了解「數列」的內容組成是由「0」到「n」的所有整數，但因為數列長度的關係，無法齊全，會缺失一個。

這就意味著，如果我們將「數列」排序，其內容就會是由「0」到「n」的升冪排列；也就是說，在不碰到缺失的情況下，其數列的內容「數值」就會與「數列索引值」相同，概念圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0268_missing_number_sort.png?raw=true)

而實作代碼如下：

```java
class MissingNumberSoft {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) if (i != nums[i]) return i;
        return nums.length;
    }
}
```

---

#### 解析二、扣除法

以數學來說，「1 + 2 + 3 + ... + n」的模式，我們會稱之為「階層」；而計算「階層總和」的方式之一就是鼎鼎有名的：「梯形面積公式」。

其概念是先計算出「0」到「n」的「梯形總和」，在扣除數列中所有內容「數值」；由於數列中會少一個整數，所以當「梯形總和」扣除「數列總和」，其剩餘的部分就是就是缺失的整數。

```java
class Solution {
    public int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * nums.length / 2;
        for (int n : nums) sum -= n; // 減去陣列所有項之總和
        return sum;
    }
}
```

以上述的邏輯加入「Stream」的方式，一行解，如下：

```java
class Solution {
    public int missingNumber(int[] nums) {
        return (nums.length + 1) * nums.length / 2 - IntStream.of(nums).sum();
    }
}
```

---

#### 解析三、互斥或法

其核心概念仍然是藉用「索引值」來作處理的；簡單說，其也是利用「互斥或與同一數值運算兩次後，其會與原來的數值一樣。」的特性。

概念是這樣的，如果我們執行將「數列」中的所有的內容「數值」都「互斥或」運算一次，與此同時，也將之與「索引值」用「互斥或」再運算一次；如此一來，當全部執行結束時，只有缺失的那個整數是僅被運算一次，因此，它就是答案，程式碼如下：

```java
class Solution {
    public int missingNumber(int[] nums) {
        int check = 0;
        for (int i = 0; i < nums.length; i++) check ^= nums[i] ^ (i + 1);
        return check;
    }
}
```

---

###### tags: `LeetCode` `Easy`