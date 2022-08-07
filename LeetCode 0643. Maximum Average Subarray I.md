# LeetCode 0643. Maximum Average Subarray I
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode-rick.jpeg?raw=true)

---

## 概要

#### 題目：[Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們一個由「n」個元素所組成的整數數列：「nums」，以及一個整數「k」；然後要求我們返回在「整數數列」中，連續「k」個元素數值總和的最大值。

###### 限制：整數數列「nums」的長度為「n」。

---

#### 解析一、暴力破解法

根據題目敘述，我們可以得知：字串「t」除了比字串「s」多一個「隨機字元」外，其組成的字母是一模一樣的。

所以我們只要將字串「排序」後，就能夠輕易比較出差異，概念如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0389_find_the_difference_sort.png?raw=true)

但這邊在實作上會有一個小問題，就是字串無法直接排列，因此，我們會藉由「toCharArray()」將字串轉換成一個個的字元，代碼如下：

```java
class Solution {
    public char findTheDifference(String s, String t) {
        char[] sChars, tChars;

        sChars = s.toCharArray();
        tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < s.length(); i++)
            if (tChars[i] != sChars[i]) return tChars[i];

        return tChars[t.length() - 1];  
    }
}
```

---

#### 解析二、扣除法

與「排序法」的思路不同，「扣除法」的概念是字串「t」扣除字串「s」，剩下的部分就是那個被加入的「隨機字母」。

根據這個思路，其比較直覺的作法是利用「容器」，我們可以先將組成「t」字串所有的「字元」加入一個容器中，再根據「s」字串的「字母」將之一個個移出容器；如此一來，當其執行完畢時，容器中的「剩餘字母」就是字串「t」中所加入的「字母」，其實作如下：

```java
class Solution {
    public char findTheDifference(String s, String t) {
        List<Character> characterList = new ArrayList<>();
        for (Character c : t.toCharArray()) characterList.add(c);
        for (Character c : s.toCharArray()) characterList.remove(c);
        return characterList.iterator().next();
    }
}
```

事實上，比起「排序法」，筆者更偏好此方式，因為它更直覺、更好懂；但是，因為它牽涉到容器的進出，所以在效能上多少會被詬病。

既然問題出在容器，仔細想想，容器是必要的嗎？

有學過「ACSII 」的人應該都知道，它是基於「拉丁字母」的一套編碼系統，在「ACSII 」中，每一個「英文字母」都有著對應的「數值」；這也就意味著，我們可以藉由「數學運算」來處理這個問題。

簡單地說就是將字串「t」的所有「字元」都轉換成「數值」後加總，再減去字串「s」的所有「字元」加總的「數值」，其剩下的「數值」所代表的「字母」就是字串「t」中被加入的「隨機字母」，代碼如下：

```java
class Solution {
    public char findTheDifference(String s, String t) {
        int res = 0;
        for (int c : t.toCharArray()) res += c; // 計算 t 的總值
        for (int c : s.toCharArray()) res -= c; // 扣去 s 的總值
        return (char) res; // 將剩餘的值轉乘對應照的文字
    }
}
```

如此一來，雖然「解題思路」與使用容器的方式是相同的，但是效能就會得到相當顯著的改善，事實上，此處也可以用「互斥或」的方式來解題，其也是利用「互斥或與同一數值運算兩次後，其會與原來的數值一樣。」的特性。

其概念也是類似，因為字串「t」只比字串「s」多一個「隨機字母」；也就是說，除了「隨機字母」以外，其它的所有字母都為可以被「成對」；既然「成對」，也就意味著，我只要用「互斥或」運算，它就會相互抵銷，代碼如下：

```java
class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : (t + s).toCharArray()) res ^= c;
        return res;
    }
}
```

是不是相當的簡潔優雅？

---

###### tags: `LeetCode` `Easy`