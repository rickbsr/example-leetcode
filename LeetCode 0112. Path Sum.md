# LeetCode 0112. Path Sum
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Path Sum](https://leetcode.com/problems/path-sum/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們一個「二叉樹（Binary Tree）」物件和一個「目標整數」。

然後要我們判斷該「二叉樹」物件中，其任意一條「A Root-to-Leaf Path」的數值總和，是否等於該「目標整數」。

在「二叉樹」的資料結構中，每個「樹節點」都可以再連接兩個「子樹節點」，分為是「左子節點」與「右子節點」；當然也可以僅連接其中一個，或都不連接；而整個「二叉樹」起始點，也就是最頂端的那個節點，稱為「根（Root）」；而剛才說的，沒有連接任何子節點的，就稱為「葉（Leaf）」，「葉」是「二叉樹」結構中的末段，通常不止一個，示意圖如下：


![](https://raw.githubusercontent.com/rickbsr/LeetCode/main/pics/0112_path_sum_treenode.png)


而題目中的「A Root-to-Leaf Path」，其意思是從「根」到「葉」所有經過的節點；以上圖來說，就是從「紅色節點」到任一「綠色節點」的過程。

---

#### 解析ㄧ、遞迴法

什麼是「[遞迴](https://en.wikipedia.org/wiki/Recursion_(computer_science))」？

在程式中，因為某些特定需求，須要在自己的方法中呼叫自己，而這樣子的手法，就被稱為「遞迴」，也有人稱之為「遞歸」。

因為「遞迴」是一種呼叫自己的循環，所以一定要設置「終止條件」，否則將會陷入「無窮」的自我呼叫，直到永遠永遠⋯，永遠是太昂貴的誓言，呃，是直到「OOM」，如下圖：

![](https://raw.githubusercontent.com/rickbsr/LeetCode/main/pics/0112_path_sum_recursive.png)

事實上，「遞迴」是一種相當耗費記憶體的撰寫方式，就如上圖演示的那樣，遞迴是一種「重覆自我呼叫」的手法，也就是說，除非被呼叫的方法執行完畢，否則當前方法就是等待，一個等待一個，一個再等待一個，如此循環。

言歸正傳，所以，如果要用遞迴的方式來解開此題，我們就需要先找出「終止條件」。

以本題來說，其「終止的條件」是到達「葉節點」；而「葉節點」的特性就是沒有連接任何子節點，所以「終止條件」的程式碼實作如下：


```java
// 代表該節點為「葉」
if (root.left == null && root.right == null) return targetSum == root.val;
```

若不是「葉」的，那就代表其可能有「左子節點」或「右子節點」；因此，我們就必須將其各自遞迴，概念圖如下：

![](https://raw.githubusercontent.com/rickbsr/LeetCode/main/pics/0112_path_sum_unit.png)

完整程式碼如下：

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // 代表為葉
        if (root.left == null && root.right == null) return targetSum == root.val;

        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
```

在程式碼中，有一個部分要特別注意，就是「targetSum」。

因為遞迴是「重覆自我呼叫」的手法，所以在程式撰寫上，就需要考量程式碼的「獨立完整性」，也就是說，每個次呼叫後的處理邏輯都盡量一致且相對獨立；如上圖中的每一個框框，其實都應視為一個完整單位，它不僅是上層節點的子節點，同樣它也是下層節點的父節點；簡單的說，就是每一個節點都應視為一個完整的「樹節點」來作判斷。

但「targetSum」是所有路徑上的節點數值總和，所以我們必須斷開它們的鎖鏈；作法就是，在我們要往下個子節點呼叫時，我們所傳入的「targetSum」需要先扣除當前「節點」的數值。

因為對下一個樹節點而言，它所需要關注只有自身的邏輯；講人話就是，凡走過必留下痕跡，因為題目的要求是路徑上所有節點的數值總和，所以已經路過的就必須扣除。

另外，由於程式邏輯，「`root.left`」與「`root.right`」都有可能為「`null`」，所以必須再一開始就先做「`null`」判斷。

---

#### 解析二、迴圈法

由於「遞迴」是「重覆的自我呼叫」，且擁有固定的邏輯；這點與「迴圈」的特性一致，因此，如果一個題目有「遞迴式」的解題方式，那麼通常就也會有「迴圈式」的解題方式。

其實兩種方式的「解題思路」一樣的，只是改以「迴圈」的方式來實作而已，代碼如下：

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> trees = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        trees.push(root);
        sums.push(targetSum);
        while (!trees.isEmpty() && (root != null)) {
            int target = sums.pop();
            TreeNode top = trees.pop();
            if (top.left == null && top.right == null
                    && top.val == target) return true;
            if (top.right != null) {
                trees.push(top.right);
                sums.push(target - top.val);
            }
            if (top.left != null) {
                trees.push(top.left);
                sums.push(target - top.val);
            }
        }
        return false;
    }
}
```

有沒有注意到，其實在「while」內的邏輯與「遞迴法」的程式邏輯相當類似；只是這次是藉由迴圈來替代「重覆自我呼叫」，僅此而已，搞定，收工！

---

###### tags: `LeetCode` `Easy`