# LeetCode 0001. Two Sum
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode-ric.jpeg?raw=true)

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

#### 解析二、「Map」樣板法

接著是「『Map』樣板法」，比起「暴力破解法」，它優雅許多；其兩者的思路類似，但後者巧妙地利用「Map」的結構來「建立樣板」；同樣是兩次迴圈，但前者是「雙層」，後者就單純是「兩次」，這樣的巧思，不僅讓程式碼變得優雅可讀，效能部分也有相當程度的優化。

兩次的迴圈中，第一次的「迴圈」負責塞值，目的在於建立一個容易比對的樣板；以「Map」的結構作為樣板的容器；而樣板的建立邏輯是以「陣列的值」當作為「Map」結構的 「key」，「陣列的索引」作為「Map」結構的 「 value」，示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0001_two_sum_arr2map.png?raw=true)

代碼如下：

```java
for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
```

當樣板建立完成後，再由關鍵的第二個迴圈負責比對邏輯，如下：

```java
for (int i = 0; i < nums.length; i++) {
    // 所需數值 = 目標值 - 當前值
    int complement = target - nums[i];
    if (map.containsKey(complement) && map.get(complement) != i)
        return new int[]{i, map.get(complement)};
}
```

此處的做法，就是逐一比對，毫無花俏；其會從陣列的第一個元素開始比對，而「complement」代表「所需數值」，即「目標值」減去「當前值」；當前值為「num[i]」。

接著，我們只要在「Map」中，找尋「所需數值」即可，由於我們在建立「Map」樣板時，我們已經將「陣列的值」作為「Key」；也就是說，我們只要在「Map」中，找尋「Key」等於「所需數值」的對象即可。

但有一點須特別注意，由於一個元素僅能使用一次；所以，我們還須確認該「元素」不等於「當前元素」；換句話說也就是我們必須去判斷其兩個元素的「索引值」是不同的。

最後，找到元素，返回；完整程式碼如下：

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

###### tags: `LeetCode` `Easy`