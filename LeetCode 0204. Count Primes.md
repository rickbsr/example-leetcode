# LeetCode 0204. Count Primes
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Count Primes](https://leetcode.com/problems/count-primes/)

#### 難度：Medium

---

## 本文

#### 說明

題目會給我們一個整數「n」，並要求我們算出小於「n」的「質數」共有幾個。

###### 限制：整數不會是負數。

---

#### 解析一、暴力破解法

如果兩個整數之間存在整除關係，「被除數」就是「除數」的「倍數」，反之，「除數」就是「被除數」因數；而質數，代表該數除了「1」與「本身」以外，沒有任何的因數。

而題目要求我們找出小於「n」的所有「質數」的數量；所以，關鍵就是「質數的判斷」。

所以「暴力破解法」就是我們將小於「n」的整數，從「2」開始逐一判斷它是否為質數，代碼如下：

```java
class Solution {
    public int countPrimes(int n) {
        int res = 0;
        for (int i = 2; i < n; i++)
            if (isPrime(i)) res++;
        return res;
    }

    private boolean isPrime(int i) {
        for (int j = 2; j < i; j++)
            if (i % j == 0) return false;
        return true;
    }
}
```

雖然「暴力破解法」的效能本來就不可能太好，但我們還是多少地優化一下；試想，除了「2」以外，還有其它的「偶數」有可能會是「質數」嗎？

當然沒有，因此，我們在遍歷小於「n」的整數時，我們不須要一一去檢查每個正整數是否為「質數」，而是只針對「奇數」去檢查即可，因此，我們上述的代碼稍微調整一下，如下：

```java
class Solution {
    public int countPrimes(int n) {
        int res = 0;
        if (n < 3) return res;
        for (int i = 3; i < n; i += 2) // 從 3 開始, 一次加 2
            if (isPrime(i)) res++;
        return res + 1; // 因為 2 也為質數，故須加 1
    }

    public boolean isPrime(int i) {
        for (int j = 2; j < i; j++)
            if (i % j == 0) return false;
        return true;
    }
}
```

其兩段程式碼的差異，就在第一個「迴圈」，因為只要檢查「奇數」，所以我們從「3」開始，每次加「2」；最後，返回的時候別忘了，因為我們是從「3」開始，所以其實也忽略了「2」，因此，要把「2」補回去，故必須再加「1」，搞定。

是不是簡單，也非常直觀？但要注意的是，雖然上述代碼的邏輯都沒有問題，不過若實際將代碼拿到「LeetCode」上執行，其結果是：「Time Limit Exceeded」；幹，就是效能太差！

好啦，這題好歹也是「Medium」難度的題目，如果蠻幹就能輕鬆過關，也太辱沒它「Medium」的標籤。

---

#### 解析二、埃拉托斯特尼篩法

既然蠻幹不行，只好掏出「找質數」的知名演算法：「[Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)」。

其實它的原理很簡單，簡單說，就是排除「質數的倍數」，因為「質數的倍數」必為「合數」；舉例來說，假如我們要找出「120」以下的所有質數，那我們就將「2」到「120」的整數都依序列出，然後從最小的質數開始遍歷。

首先是「2」，「2」是質數，但「2」的「倍數」卻不是，所以我們可以將「2 * n」的數通通排除；同理，「3」也是，所以也將「3 * n」排除；接著是「4」，但由於「4」是「2 * n」，已經被排除了，接著就是「5」，排除「5 * n」⋯等，並以此類推直到最後；維基百科的示意圖，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0204_count_primes_sieve_of_eratosthenes_wiki.gif?raw=true)

而實作的代碼如下：

```java
class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        Set<Integer> notPrimes = new HashSet<>();
        for (int i = 3; i * i < n; i += 2)
            if (!notPrimes.contains(i))
                for (int j = i * i; j < n; j += i * 2) notPrimes.add(j);
        return n / 2 - notPrimes.size();
    }
}
```

其實上面那段代碼有小部分的優化，由於考量程式邏輯的「流暢性」，我們將第一個「迴圈」的起始值改成「3」；因為以「2」作為起始值，下一個質數是「3」，其差距僅「1」，但由於「偶數」必然不會是「質數」，所以下一個質數仍會跳過「4」，並到「5」；試想，「2」、「3」、「5」、「7」⋯，而其數列間距為「1」、「2」、「2」、「2」⋯，所以為了程式邏輯的流暢，直接以「3」作為起點，如此一來，我們每次都可以直接加「2」。

那「偶數」的部分怎麼辦？

有看到返回時的程式碼嗎？因為「偶數」會恰好是「整個整數」數量的一半，因此「`n / 2`」就是解決方案。

另外，在外層迴圈中，我們將終止條件設為「`i * i < n`」，而不是設為「`i < n`」，這是因為「`a * b`」與「`b * a`」是一樣的，所以我們不需要重覆計算；舉例來說，假設「n」值為「100」，那麼相乘為「100」的可能組合是「`2 * 50`」、「`4 * 25`」、「`5 * 20`」以及「`10 * 10`」；而之後呢？是不是就變成反向的部分了，也就是「`20 * 5`」、「`25 * 4`」、「`50 * 2`」，示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0204_count_primes_pair.png?raw=true)

而以上述例子來說，「`2 * 50`」跟「`50 * 2`」是相同的，「`4 * 25`」跟「`25 * 4`」也是如此，以此類推；因此，我們的終止條件僅須設為「`i * i < n`」即可。

此外，內部迴圈的「終止條件」也是一樣道理。

```java
for (int j = i * i; j < n; j += i * 2) notPrimes.add(j);
```

另外，之所以起點是「`i * i`」，這是因為去找小於「i」數值相乘意義不大，舉例來說，若「i」是「5」，那麼「`5 * 2`」，在「i」為「2」時，「`2 * 5`」，就已經處理過了；「`5 * 3`」也一樣，在「i」為「3」時，「`3 * 5`」；因此，此處的起點為「`i * i`」即可。

然後，比較須要注意的是「每次增加的數值」部分，因為此處為內部「迴圈」，是「乘積」；因此，每次加的不是「1」，而是「ｉ」；又因為須跳過「偶數」，因此每次是加「`i * 2`」。

最後，別忘了在返回時，要先將「n」除以「2」；也就是去除「偶數」的部分。

當完成後，崩潰的事情又來了，因為這樣的代碼仍然無法通過「LeetCode」的測試；原因同樣是「Time Limit Exceeded」。

於是乎，為了效能考量，我們將容器的部分改成「布林陣列」來實作，維持一樣的邏輯，實作如下：

```java
class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] notPrime = new boolean[n];
        int res = n / 2;
        for (int i = 3; i * i < n; i += 2)
            if (!notPrime[i])
                for (int j = i * i; j < n; j += i * 2)
                    if (!notPrime[j]) {
                        notPrime[j] = true;
                        res--;
                    }
        return res;
    }
}
```

然後就趴斯了，幹！

但老實說，以平常開發而言，筆者並不喜歡使用陣列；主要原因是不好操作，即便有「Arrays」這個工具類輔助，但比起「Collocation」，仍是被甩三條街，至少，打印就是比較醜。

此外，陣列具有長度不可變的特性，所以⋯，什麼，都是藉口？對，筆者就是討厭它。

---

###### tags: `leetcode` `java` `easy`