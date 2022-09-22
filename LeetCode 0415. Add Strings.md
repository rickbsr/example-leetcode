# LeetCode 0415. Add Strings
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Add Strings](https://leetcode.com/problems/add-strings/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們兩個代表「非負整數」的字串；而題目的要求是讓我們返回其兩字串所代表的整數相加後的結果字串。

###### 限制：整數不會有前導「0」。
###### 限制：不能直接使用字串轉整數的「API」，亦不能使用「BigNumber」相關的庫的功能。

---

#### 解析一、遞迴法



```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null) return false;
        else if (q == null) return false;
        else if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

稍微把程式碼寫得簡短一些，如下：



---

###### tags: `leetcode` `java` `easy`