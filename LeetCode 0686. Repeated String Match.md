# LeetCode 0686. Repeated String Match
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode-rick.jpeg?raw=true)

---

## 概要

#### 題目：[Repeated String Match](https://leetcode.com/problems/repeated-string-match/)

#### 難度：Medium

---

## 本文

#### 說明

題目給我們兩個字串，分別為「a」字串與「b」字串；然後要求我們去判斷「a」字串或是當其重覆了多次以後，是否能夠包含「b」字串；也就是問，「b」字串是否為「a」字串或是「n * a」字串的「子字串」。

###### 限制：字串「a」與「b」的長度至少為「1」。
###### 限制：字串「a」與「b」的組成皆為英文小寫字母。

---

#### 解析一、迴圈法

分析一下題目的描述，首先，題目的問題是「b」字串是否為「a」字串或是「n * a」字串的「子字串」；既然「b」字串是「子字串」，那麼也就意味著可能是「a」字串或是「n * a」字串的「母字串」，其長度必須大於或等於「b」字串的長度；這應該沒有問題吧？

假

接著，根據題目的敘述，我們知道母字串的「pattern」一定是「a」或是「n * a」，也就是說，它一定是重覆得益

先來說明「母子字串」的特性；在保證「母字串」的長度必大於或等於「子字串」的情況下，


所以，我們必須求出「母字串」，也就是「a」字串或是「n * a」字串的最小長度；也就是將「b」的字串長度除以「a」的字串長度。

此時

---

#### 解析二、數學運算法


---

###### tags: `LeetCode` `Easy`