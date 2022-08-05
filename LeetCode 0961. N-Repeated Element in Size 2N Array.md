# LeetCode 0961. N-Repeated Element in Size 2N Array
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode-rick.jpeg?raw=true)

---

## 概要

#### 題目：[N-Repeated Element in Size 2N Array](https://leetcode.com/problems/n-repeated-element-in-size-2n-array/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們一長度為「2n」的整數數列，內含「n + 1」個不同的元素且其中的「n」個元素為唯一值，僅有一個元素會重覆出現；題目要求我們找出那個會「重覆出現」的元素。


###### 限制：「n」大於等於「2」。

---

#### 解析一、容器法

這題與「[Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)」類似，目標都是找出數列中重覆的元素。

那既然是找出「重覆元素」，其同樣地也可以使用「排序法」、「容器法」⋯等方式解題；事實上，以這題來說，「容器法」是相對直觀的方式。

首先，我們須要宣吿一個「容器」作為存放數列元素的空間，接著就將「數列元素」逐一放入該容器中；除了第一次放入外，其餘每次將數列元素放入容器前都要先檢查「當前容器中」是否已經存同樣地元素，若有，則返回該元素，若無，才能將該元素放被宣告出來的容器中。

以「List」為例，我們可以藉由「contains()」來檢查容器內是否已存在該元素，實作代碼如下：

```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        do list.add(nums[i++]);
        while (!list.contains(nums[i]));
        return nums[i];
    }
}
```

其實將上述代碼中的「List」換成「Set」也行，「Set」同樣擁有「contains()」，但是「Set」還有另外一個特性：會剔除重複元素；也就是說，我們亦可以藉由「Set.size()」來判斷，代碼如下：

```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        do set.add(nums[i++]);
        while (set.size() == i);
        return nums[i - 1];
    }
}
```

---

###### tags: `LeetCode` `Easy`