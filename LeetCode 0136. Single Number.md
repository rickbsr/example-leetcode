# LeetCode 0136. Single Number
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Single Number](https://leetcode.com/problems/single-number/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們一個非空的「整數數列」，數列中除了「目標整數」之外，其它所有的整數皆為成對；而題目的要求就是找出該數列中的「目標整數」。

###### 備註：演算法須為「線性的時間複雜度」以及「常數的空間複雜度」。

---

#### 解析ㄧ、容器法

在沒有「常數空間複雜度」的限制下，「容器法」無疑是最簡單易懂的解題方式。

它的作法是：「先宣告一個容器，並將數列中的所有整數一一放入，而放入的邏輯是，如果容器內不含該整數就直接將該整數放入，如果容器內已存在該整數，就連容器內的整數一併移除。」。

於該邏輯下，當數列內所有元素都被執行過以後，「成對」的整數會因為上述的邏輯而導致該整數不存在於容器之中，反之，由於目標整數是「單個」的存在，因此，當所有元素都被操作過以後，它就會是那個唯一一個存在於容器中的整數，完整程式碼如下：

```java
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : nums)
            if (map.put(i, true) != null) map.remove(i);
        return map.keySet().iterator().next();
    }
}
```

雖然「容器法」是一個簡單易懂的解題方式，但它的「空間複雜度」不符合「常數空間複雜度」。

就「容器法」的解題代碼來說，當傳入的數列元素增加時，其所需要的空間也會呈現「線性增加」，因此，它的空間複雜度是「線性空間複雜度」。

另外，本題的「容器」，不一定是「Map」，其它如「Set」、「List」⋯等，甚至是一般陣列都行；之所以選用「Map」是因為想利用「Map.put()」的回傳值作為判斷依據，讓寫法較簡潔。

---

#### 解析二、排序法

相較於「容器法」，「排序法」就顯得優雅許多，筆者特別喜歡；其作法的核心就是將該「整數數列」依照「大小」排序，升降冪都可。

試想，當一整數數列依大小排列後，其「同樣數值」的整數會怎麼排列？必然是兩兩相鄰；也就是說，除了那個「唯一整數」之外，其它所有成對的整數，其左邊或右邊，必定有一邊是與自己數值相同的整數；唯有那個「唯一整數」，可以同時不等於左邊，也不等於右邊，示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0136_single_number_sort.png?raw=true)

原理說明完畢以後，程式碼實作如下：

```java
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1 || nums[0] != nums[1]) return nums[0];
        for (int i = 1; i < nums.length - 1; i++)
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) return nums[i];
        return nums[nums.length - 1];
    }
}
```

在上述的代碼中，在「排序」的部分，筆者偷懶藉由「Arrays.sort()」來處理。

事實上，「排序」是這個解法的核心，但也是這個解法最尷尬的地方；原因在於「排序」本身就沉載著一定的複雜度；而多數知名的「排序演算法」，如「氣泡排序法」、「單、雙軸插入排序法」、「選擇排序法」⋯等，都不符合本題的限制。

另外，由於索引「0」是邊界，且因為是依序排序，所以，索引「0」只要與索引「1」比較即可；若索引「0」是唯一整數，那麼其與索引「1」的數值必然不同，反之，則必定相同。

至於為什麼不用特別判斷數列「最末項」？因為若「唯一值」在最末項，那也意味著其前面的整數都不符合條件，所以如果們判斷到「最末項」的「前一項」也都不符合的話，就直接返回最後一項即可。

此外，再請各位思考一下，因為同樣數值的整數必會相鄰，假設我們由左而右遍歷，若當前索引的整數，與其「右邊」的整數數值相同，那麼，我們是不是就可以跳過檢查其右邊的整數？

舉例來說，假設索引「1」與索引「2」的數值相同，那當我們在檢查索引「1」時，就會因為與「右邊」整數相同而不符合，那麼，對於索引「2」，它也會因為與「左邊」整數相同的不符合，因此，當我們檢查索引「1」並發現它與右邊整數相同時，也就代表，我們可以跳過索引「2」的檢查。

同道理類推，結論就是我們不需要每個「整數」都一一去檢查其「左」、「右」。

而根據上述的邏輯，我們就可以在程式碼實作時，將「迴圈」設計成每次遞增「2」；此外，「迴圈」內的判斷式也可以稍微簡化，讓整體代碼更加簡潔，改寫後的程式碼如下：

```java
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length - 1; i += 2)
            if (nums[i] != nums[i + 1]) return nums[i];
        return nums[nums.length - 1];
    }
}
```

---

#### 解析三、互斥或法

然而，不論是一開始的「容器法」，還是後來的「排序法」，其實都無法滿足題目的限制，即「線性時間複雜度與常數空間複雜度」。

但目前介紹的「互斥或法」就可以滿足了；其主要是利用「x-or」的一個運算特性，即對同一數值互斥或兩次，會變回原來的數值，這與「互斥或」的運算規則有關。

因此，藉此特性，我們就可以簡單的找出「唯一值」，代碼如下：

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) res ^= i;
        return res;
    }
}
```

若「Java」的版本為「8」以上，我們還可以用「Stream」的方式來撰寫出「一行解」，如下：

```java
class Solution {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }
}
```

---

###### tags: `leetcode` `java` `easy`