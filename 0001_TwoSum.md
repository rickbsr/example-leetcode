# LeetCode 0001. Two Sum
Leetcode：Java

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

#### 雙迴圈法

這題的解題方式並不特別，基本上就是將邏輯逆推即可；也許實作代碼可能不同，但思路大致上都類似。

首先是特例排除，由於題目的限制，因此我們可以在一開始的時候就藉由「if」來判斷「nums」數列的元素是否只有兩個，若是，依題目的敘述，它們就必為題目的答案，直接返回「0」、「1」陣列即可，如下：

```java
if (nums.length == 2) return new int[]{0, 1};
```

但事實上，這行「特例排除」與其它題目的「特例排除」比較不同，它並不必要，拿掉也不會影響邏輯的正確性，也對效能優化的幫助也不大，因此可有可無，沒寫也沒關係；重點在於接下來的兩個迴圈內容。

其中，第一個「迴圈」負責塞值，目的在於建立一個容易比對的樣板；此處筆者偏好以「Map」的結構作為樣板的容器；而樣板的建立邏輯是以「陣列的值」當作為「Map」結構的 「key」，「陣列的索引」作為「Map」結構的 「 value」，示意圖如下：

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