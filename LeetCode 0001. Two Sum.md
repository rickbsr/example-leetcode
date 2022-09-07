# LeetCode 0001. Two Sum
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Two Sum](https://leetcode.com/problems/two-sum/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們一個「目標數」與一「非空整數數列」，然後要求我們在該整數數列中找尋兩個元素其總和恰好等於「目標數」，並返回該兩個元素的「索引」。

###### 限制：不允許重覆使用同樣的元素。
###### 限制：該陣列中；至少存在兩個以上的元素且僅會存在一組有效答案。

---

#### 解析一、暴力破解法

既然是「暴力破解法」的解題方式，其思路就相當直觀，基本上將邏輯順過，兩層「迴圈」就可以輕鬆搞定了，完整代碼如下：

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums.length; j++)
                if (i != j && (nums[i] + nums[j] == target))
                    return new int[]{i, j};
        return null;
    }
}
```

---

#### 解析二、「Map」樣版法

在讀完「暴力破解法」的代碼之後，我們來介紹一下「『Map』樣版法」。

比起「暴力破解法」，它優雅許多；但其兩者的思路基本上是相同的，只是「樣版法」巧妙地利用「Map」的資料結構來「建立樣版」。

事實上，「暴力破解法」與「『Map』樣版法」同樣都需要執行兩次迴圈，但前者兩次迴圈是「雙層迴圈」，而後者的兩次迴圈就真的只是執行「兩次」迴圈，這樣的巧思，不僅讓程式碼變得優雅可讀，效能部分也有相當程度的優化。

在樣版法的兩次迴圈中，第一次的「迴圈」是負責塞值，目的在於建立一個「Map」樣版，其樣版的建立規則是以「陣列的值」當作為「Map」結構的 「key」，再以「陣列的索引」作為「Map」結構的 「value」，示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0001_two_sum_arr2map.png?raw=true)

代碼如下：

```java
for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
```

當「Map」樣版建立完成後，再由關鍵的第二個迴圈負責比對邏輯，程式碼如下：

```java
for (int i = 0; i < nums.length; i++) {
    // 所需數值 = 目標值 - 當前值
    int complement = target - nums[i];
    if (map.containsKey(complement) && map.get(complement) != i)
        return new int[]{i, map.get(complement)};
}
```

此處的做法，就是逐一比對，毫無花俏；其會從陣列的第一個元素開始比對，而「complement」代表「所需數值」，即「目標值」減去「當前值」；當前值為「`num[i]`」。

接著，我們只要在「Map」中，找尋「所需數值」即可，由於我們在建立「Map」樣版時，我們已經將「陣列的值」作為「Key」；也就是說，我們只要在「Map」中，找尋「Key」等於「所需數值」的對象即可。

但有一點須特別注意，由於一個元素僅能使用一次；所以，我們還須確認該「元素」不等於「當前元素」；換句話說也就是我們必須去判斷其兩個元素的「索引值」是不同的。

最後，找到元素，將之返回，收工；完整程式碼如下：

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) return new int[]{0, 1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i)
                return new int[]{i, map.get(complement)};
        }
        return null;
    }
}
```

---

###### tags: `leetcode` `java` `easy`