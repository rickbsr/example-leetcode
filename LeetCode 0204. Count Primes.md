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

答案是沒有，因此，我們在遍歷小於「n」的整數時，我們不須要逐個整數去檢查是否為「質數」，而是僅須針對「奇數」去檢查即可，因此，我們上述的代碼稍微調整一下，如下：

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

是不是簡單，也非常直觀？但要注意的是，雖然上述代碼的邏輯都沒有問題，不過若實際將代碼拿到「LeetCode」上執行，其結果是：「Time Limit Exceeded」。

沒錯，問題就出在效能，好歹這題也是「中等」難度的題目，如果蠻幹就能輕鬆過關，是不是也太不符合其難度了。

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

那「2」怎麼辦？

有看到返回值的部分嗎？因為「偶數」會恰好是「整個整數」數量的一半，因此「n / 2」就是答案。

雖然我們可以設定為「i < n」；但思考一下，假設「n」值為「100」，那麼相乘為「100」的可能組合是「2 * 50」、「4 * 25」、「5 * 20」以及「10 * 10」，然後是反向的「20 * 5」、「25 * 4」、「50 * 2」，示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0204_count_primes_pair.png?raw=true)

而以上述例子來說，「2 * 50」跟「50 * 2」是相同的，「4 * 25」跟「25 * 4」也是如此，以此類推的都是；所以，我們的終點只要設定「i * i < n」即可。

而內部的迴圈其實邏輯也類似，如下：

```java
for (int j = i * i; j < n; j += i * 2) notPrimes.add(j);
```

之所以起點是「i * i」，這是因為去找小於「i」數值相乘意義不大，舉例來說，若「i」是「5」，那麼「5 * 2」，在「i」為「2」時，「2 * 5」，就已經處理過了；「5 * 3」也一樣，在「i」為「3」時，「3 * 5」；因此，此處的起點為「i * i」即可，而終點邏輯則是相同的。

比較須要注意的是「每次增加的數值」部分，因為此處為內部「迴圈」，是「乘積」；因此，每次加的不是「1」，而是「ｉ」；又因為須跳過「偶數」，因此每次是加「i * 2」。

最後，要說一點是，再返回時，記得先將「n / 2」；這部分就是去除「2」的部分，也就是「偶數」的部分。

但其實這樣的代碼依然無法順利通過「LeetCode」的測試，原因同樣是「Time Limit Exceeded」；因此，我們再將它優化，將容器的部分改成布林陣列來處理，但其實邏輯完全相同，實作如下：

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

---

###### tags: `LeetCode` `Medium`