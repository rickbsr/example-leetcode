# LeetCode 0961. N-Repeated Element in Size 2N Array
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[N-Repeated Element in Size 2N Array](https://leetcode.com/problems/n-repeated-element-in-size-2n-array/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們一長度為「2n」的整數數列，其中共含有「n + 1」個不同的元素；但在這「n + 1」種不同的元素中，只有一個元素會重覆出現，其它「n」個元素為唯一值。

而題目的要求就是要我們找出該「重覆出現」的元素。

###### 限制：該陣列的長度必為「2 * n」。

---

#### 解析一、暴力破解法

首先，暴力破解法；思路就是一個一個比，比較相同的就返回。

程式碼如下：

```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) 
                if (nums[i] == nums[j]) return nums[i];       
        return -1;
    }
}
```

這代碼相當的直覺，就雙層迴圈；唯一可能要注意的，大概是在內層迴圈的部分，其起始索引要將排除重覆的部分，也就是從「`i + 1`」開始。

---

#### 解析二、「List」容器法

既然是找出「重覆元素」，除了「暴力破解法」外，同樣可以使用「容器法」以及「排序法」⋯等方式來解題；事實上，以這題來說，「容器法」更是相對直觀。

其核心就是「容器」，作為存放數列元素的空間，其不論是「List」、「Set」或是「Map」，都無所謂；解題思路就是，將陣列中的整數一一放入「容器中」，然後在每次放入時都去檢查其有沒有重覆；若無，則持續放入，若有，則返回「重覆」的值。

以「List」為例，完整程式碼如下：

```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        do list.add(nums[i++]);
        while (!list.contains(nums[i]));
        return nums[i];
    }
}
```

在「List」中，可以藉由「[`List.contains()`](https://docs.oracle.com/javase/8/docs/api/java/util/List.html#contains-java.lang.Object-)」來判斷容器內是否已存在重覆元素。

---

#### 解析三、「Set」容器法

上述實作我們也可以用「Set」來替代「List」；雖然一樣可以使用：「Collection」。

但是，既然已經是「Set」了，那就可以依賴「Set」的一個特性：會剔除重複元素；也就是說，我們亦可以藉由「Set.size()」來判斷，代碼如下：

```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        do set.add(nums[i++]);
        while (set.size() == i);
        return nums[i - 1];
    }
}
```

---

#### 解析四、「Map」容器法

若想「Map」為容器的話，由於「`Map.put()`」會將原本已經存在容器內的值吐出，因此，我們就可以藉此特性作為判斷的依據，完整代碼如下：

```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            if (map.put(i, i) != null) return i;
        return -1;
    }
}
```

---

#### 解析五、排序法

最後是「排序法」。

首先，先將數列依序排列；當該數列被依序排列後，其相同的值必然相鄰，因此我們可以逐個遍歷，比較當前索引的數值與其「左」、「右」相鄰的數值是否相同，若相同，則該值就是那個唯一會重覆的數值，其程式碼如下：

```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++)
            if (nums[i] == nums[i + 1]) return nums[i];
        return nums[nums.length - 1];
    }
}
```

但能否優化呢？

我們先來分析題目：「長度 2n」、「n + 1 種元素」、「僅一個重複」，根據這三個描述，我們可以得到一個總結，即數列的元素為「2n」個，而重複的元素為「n」個。

換句話說，在該數列中，有一半的元素其數值相同；在這個前提下，若重覆的「n」個元素是數列中的「最小值」，則代表該數列經排序後，其「前一半」的元素皆為「重覆的元素」，如下：

![](https://raw.githubusercontent.com/rickbsr/LeetCode/main/pics/0961_n-repeated_element_in_size_2n_array_min_a.png)

反之，若重覆的「n」個元素是數列中的「最大值」，則該數列經排序後，其「後一半」的元素就會都是重覆的元素，如下：

![](https://raw.githubusercontent.com/rickbsr/LeetCode/main/pics/0961_n-repeated_element_in_size_2n_array_max_a.png)

那如果重覆的「n」個元素非數列的「極端值」，那麼意味著其「中間項」，也就是第「n - 1」項和第「n」項必為重覆的元素，如下：

![](https://raw.githubusercontent.com/rickbsr/LeetCode/main/pics/0961_n-repeated_element_in_size_2n_array_normal_a.png)

根據上述的思路，我們整理一下邏輯。

若如果「首項」與「n - 1」項相同，即意味著重覆的「n」個元素是數列的「最小值」；返回「首項」數值即可。

反之，還剩下兩種情況，其一，是該數值非極值，所以其中間兩項相等，其二，是該數值為數列的「最大值」，所以其第「n」項，與最末項相等。

但注意喔，不論是中間兩項相等，還是後面「n」項相等的任一種情況，其第「n」項必為我們需要的目標值；也就是說，只要不是前「n」項相等的情況，我們返回第「n」項即可。

該邏輯實作如下：

```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        return nums[nums[0] == nums[nums.length / 2 - 1] ? 0 : nums.length / 2];
    }
}
```

---

###### tags: `leetcode` `java` `easy`