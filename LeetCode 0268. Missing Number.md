# LeetCode 0268. Missing Number
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Missing Number](https://leetcode.com/problems/missing-number/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們一長度為「n」的整數數列，其內容為不重覆之「0」到「n」的整數，但因為陣列長度的限制，「0」到「n」之中會有一個「正整數」沒有被放到「數列」中；而題目的要求，就是要我們找出該整數。

###### 限制：所有整數皆為「唯一」存在。

---

#### 解析一、排序法

這題與「[Single Number](https://leetcode.com/problems/single-number/)」是類似的題目；同屬於在陣列中找出「差異」的題型。

事實上，對於這類型的問題，大多都可以使用「排序」來解決；而這題也不例外。

在題目敘述中，我們可以得知，組成該數列的整數為「0」到「n」的所有整數，總共「`n + 1`」個整數；但由於該數列的長度為「n」，所以必定會有個整數無法放到該數列中；而題目的要求，就是要我們返回「缺失」的那個整數。

因此，在暫不考慮「IndexOutOfBoundsException」的情況下，若將我們將該「數列」的數值依大小「排序」，以「升冪排列」為例，在無缺失任何的整數狀況，其數列內「元素」的數值就會與其「索引值」一致。

倘若「缺失」了其中之一，那麼就會出現數列內「元素」的數值與其「索引值」不一致的情形，概念圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0268_missing_number_sort.png?raw=true)

而實作代碼如下：

```java
class MissingNumberSoft {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) if (i != nums[i]) return i;
        return nums.length;
    }
}
```

---

#### 解析二、扣除法

若一「數列」的元素內容為「1」連續到「n」的正整數，即「$1 + 2 + 3 + ... + n$」；在數學中，這樣的數列稱為「[等差數列](https://en.wikipedia.org/wiki/Arithmetic_progression)」；公差為「1」。

而「等差數列和」的公式如下：

$$
S_n = (a_0 + a_n) * n / 2
$$

其中「$a_0$」為「首項」，「$a_n$」為「末項」。

回到題目的內容，依照題目的敘述，我們可以得知，題目所給的數列內容即為「從『1』連續到『n』的正整數，並隨機缺少當中的任一項。」；因此，我們只要將「從『1』連續到『n』」的「等差數列和」減去題目數列中所有元素的數值和，其計算後的剩餘的差，就為「缺失」的整數；完整程式碼如下：

```java
class Solution {
    public int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * nums.length / 2;
        for (int n : nums) sum -= n; // 減去陣列所有項之總和
        return sum;
    }
}
```

上述邏輯以「Stream」實作的「一行解」，如下：

```java
class Solution {
    public int missingNumber(int[] nums) {
        return (nums.length + 1) * nums.length / 2 - IntStream.of(nums).sum();
    }
}
```

---

#### 解析三、互斥或法

其核心概念仍然是藉用「索引值」來作處理的；簡單說，原理是利用「互斥或與同一數值運算兩次後，其會與原來的數值一樣。」的特性。

概念是這樣的，如果我們執行將「數列」中的所有的內容「數值」都「互斥或」運算一次，與此同時，也將之與「索引值」用「互斥或」再運算一次；如此一來，當全部執行結束時，只有缺失的那個整數是僅被運算一次，因此，它就是答案，程式碼如下：

```java
class Solution {
    public int missingNumber(int[] nums) {
        int check = 0;
        for (int i = 0; i < nums.length; i++) check ^= nums[i] ^ (i + 1);
        return check;
    }
}
```

---

###### tags: `leetcode` `java` `easy`