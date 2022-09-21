# LeetCode 0389. Find the Difference
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Find the Difference](https://leetcode.com/problems/find-the-difference/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們兩個字串，分別為字串「s」和字串「t」。

將字串「s」的組成字元隨機排列以後，再將一個「隨機字元」在任意位置插入而形成的字串，就是字串「t」。

也就是說，字串「t」會比字串「s」多一個隨機字元，而題目的要求就是要我們返回那個的「隨機字元」。

###### 限制：為字串「s」和字串「t」皆為小寫英文字母。

---

#### 解析一、排序法

這題與之前解過的「[Missing Number](https://leetcode.com/problems/missing-number/)」、「[Single Number](https://leetcode.com/problems/single-number/)」非常類似，其解法思路基本上是一樣的。

同樣地，這題可以用排序的方式來解題。

根據題目的敘述，我們可以得知：字串「t」除了比字串「s」多一個「隨機字元」以外，其餘的組成字母是完全相同的。

所以，我們只要將字串「排序」後，就能夠輕易比較出差異？

但字串能排序？

在一般情況下的確是不能，但是若換成「字元」呢？在「Java」中，「字元」是可以根據「ASCII」表將之轉換成相應的「整數」。

概念如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0389_find_the_difference_sort.png?raw=true)

所以為了要讓字串的組成字母排序，我們必須先將將「字串」轉換為「字元們」；在轉換上，我們可以藉由「String.toCharArray()」來處理。

在轉換完成後，我們就可以藉由迴圈將兩者一一比較，代碼如下：

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

#### 解析二、容器法

與「排序法」的思路不同，「扣除法」的概念是字串「t」扣除字串「s」，剩下的部分就是那個被加入的「隨機字母」。

根據這個思路，其比較直覺的作法是利用「容器」。

首先，同樣是將「字串」轉換成「字元」。

然後先將組成字串「t」的所有字元都加入到容器之中；接著再依據字串「s」的組成，將相同的字元移出容器。

在上述步驟執行完畢後，我們只要查看容器中剩餘的「字元」，而該字元就是那個被插入字串「t」的隨機字母。

完整程式碼，如下：

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

---

#### 解析三、扣除法

但是，「容器法」畢竟牽涉到容器的進出，所以在效能上多少會被詬病。

既然問題出在容器，那仔細想想，容器是真的必要嗎？

還記得上述的「排序法」嗎？

其之所以能將字串進行排序，那是基於其組成字元的「ASCII」碼，對吧？

補充說明一下，「ACSII」是一套基於「拉丁字母」的編碼系統，在「ACSII 」中，每一個「英文字母」都有著對應的「唯一數值」；因為所有字母都有對應的「唯一數值」，所以我們是不是可以直接將「字元」視為整數來進行運算呢？

因為字串「t」比字串「s」多一個「隨機字元」，所以如果我們將字串「t」的所有「字元」加總，然後再扣去字串「s」的所有「字元」加總，那麼，兩者相減的「差」，不就是該「隨機字母」所對應的「ACSII」碼？

最後，我們只要將該數值根據「ACSII」表反向參照，我們就可以找到那「剩餘」的字母，完整程式碼，如下：

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

---

#### 解析四、互斥或法

同樣地，這題也能用「互斥或」的方式來解題；其概念也是利用「互斥或與同一數值運算兩次後，其會與原來的數值一樣。」的特性。

其概念也與上述解法類似。

因為字串「t」只比字串「s」多一個「隨機字母」，所以如果我們將兩字串合併，變成字串「ts」；然後依據題目的描述，我們可以知道，在字串「ts」中，除了「隨機字母」以外，其它的所有字母都會是「成對」的。

而我們先前說過，每個字元可以根據「ASCII」表來對應到一個「唯一數值」；再加上「互斥或」的特性，即「互斥或與同一數值運算兩次後，其會與原來的數值一樣。」。

所以，我們同樣可以藉由「String.toCharArray()」，將「ts」字串轉成「字元」，再將每個字元以「互斥或」運算，而其餘下的數值就是該「隨機字母」的「ASCII」碼，，代碼如下：

```java
class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : (t + s).toCharArray()) res ^= c;
        return res;
    }
}
```

---

###### tags: `leetcode` `java` `easy`