# LeetCode 0389. Find the Difference
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode-ric.jpeg?raw=true)

---

## 概要

#### 題目：[Find the Difference](https://leetcode.com/problems/find-the-difference/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們兩個字串，分別為字串「s」和字串「t」，而字串「t」為字串「s」的所有字元隨機排列後，再在任意一個位置插入一個「隨機字元」後組成；也就是說字串「t」會比字串「s」多一個隨機字元，而題目的要求就是要我們找出該字元。

###### 限制：為字串「s」和字串「t」皆為小寫英文字母。

---

#### 解析一、排序法

根據題目敘述，我們可以得知：字串「t」會比字串「s」多一個「隨機字元」。

所以我們可以將「英文字串」拆成一個個「英文字母」，經過「排序」後，再逐一比較，如下：

```java
class Solution {

}
```

---

#### 解析二、扣除法

說實在的，「排序法」雖然直覺，但效能依然是個問題，其關鍵在於「排序」。

所以換個思路，如果我們將「t」字串所有的「英文字母」加入一個容器，再根據「s」字串的「字母」將之一個個移出容器；如此一來，當其執行完畢時，容器中的「剩餘字母」就是字串「t」中所加入的「字母」。



---

###### tags: `LeetCode` `Easy`