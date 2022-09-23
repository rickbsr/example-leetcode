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

題目會給我們一個「目標整數」與一個「非空」的「整數數列」，然後要求我們在該非空的「整數數列」中找尋其總和等於「目標整數」的任意兩元素；然後返回該兩個元素的「索引」。

###### 限制：不允許重覆使用同樣的元素。

###### 限制：該陣列中；至少存在兩個以上的元素且僅會存在一組有效答案。

---

#### 解析一、暴力破解法

首先是「暴力破解法」；「暴力破解」，正所謂「一力降十會」；什麼「時間、空間複雜度」、「效能」的就暫且擱一邊吧！

總之，幹就對了，藉由雙層迴圈的代碼結構，將所有可能都逐一加總，完整程式碼如下：

```java=
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) return new int[]{i, j};
        return null;
    }
}
```

---

#### 解析二、「Map」法

在說明「暴力破解法」之後，接著，我們來說明「Map」法。

比起「暴力破解法」代碼中的「雙層迴圈結構」，「Map」就顯得簡潔許多；但其兩者的核心思路基本上是一致的，都是「逐一加總」，只是後者則是藉由「Map」的資料結構來處理。

具體作法如下：

第一步，基於「Map」的資料結構，建立之後用以比對的「樣版」。

而「樣版」的建立規則是以「陣列的索引」作為「Map」結構中的「Value」，並以「陣列的值」作為「Map」結構中的「Key」而成，其示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0001_two_sum_arr2map.png?raw=true)

建立「樣版」以後，我們再以「迴圈」遍歷一次陣列。

接著，我們就要找出總和等於「目標整數」的兩個元素。

其思路是，假設題目所需的兩個元素的其中之一是「當前索引」，那麼「所需的數值」就等於「目標整數的數值」減去「當前索引的數值」，因此，在第二次遍歷時，我們就可以根據索引逐一地先計算出「所需的數值」，然後再根據「所需的數值」去剛才建立起的樣版搜尋是否有同樣的「Key」，倘若有，則該兩個元素即為題目所需，反之，就在往下一個索引繼續尋找，完整程式碼如下：

```java=
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need) && map.get(need) != i) return new int[]{i, map.get(need)};
        }
        return null;
    }
}
```

事實上，其效能佳的原因在於「[`Map.containsKey()`](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html#containsKey-java.lang.Object-)」。

相關實作請參考「[`HashMap.containsKey()`](https://github.com/rickbsr/Java-Src/blob/main/temurin-1.8.0_345/src/java/util/HashMap.java#L596)」，關鍵代碼在「[`HashMap.getNode()`](https://github.com/rickbsr/Java-Src/blob/main/temurin-1.8.0_345/src/java/util/HashMap.java#L568)」。

關於源碼解析的部分，就不在此多做說明，若未來有機會筆者再另闢戰場。

另外，關於上述代碼，其實我們還能再一些優化，如下

```java=
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; map.put(target - nums[i], i++))
            if (i != 0 && map.containsKey(nums[i]))
                return new int[]{i, map.get(nums[i])};
        return null;
    }
}
```

其實優化的主要部分是將兩個「迴圈」合併在一起處理，其它部分大同小異，就不多說明了。

---

###### tags: `leetcode` `java` `easy`