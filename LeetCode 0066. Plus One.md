# LeetCode 0066. Plus One
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Plus One](https://leetcode.com/problems/plus-one/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們一個「非空」的「整數數列」，而該「整數數列」代表著一個「整數」；舉例來說，若數列內容為「`{1, 2, 3}`」，那所代表的整數就是「123」。

而題目的要求就如同其名稱：「Plus One」；也就是對題目給的整數執行「加一」的動作，以「123」來說，其「加一」後，就等於「124」，然後將計算後整數以表示數列返回，以本例來說，返回的就是「124」的表示陣列，即「`{1, 2, 4}`」。

###### 限制：數列表示的「整數數值」不存在先導「0」。

---

#### 解析一、字串轉換法

這題是入門款的「陣列與整數互相轉換」，難度不高；就算是以「土法煉鋼」的方式來解題，其程式邏輯也不會太複雜。

事實上，這題我們可以粗略地將其分為兩個階段來探討，第一階段是將「數列」轉換成「數值」；想當然耳，第二階段就是將「數值」轉換回「數列」，示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0066_plus_one_stepbystep.png?raw=true)

然而，不論是將「數列」轉換成「數值」，亦或是將「數值」轉換回「數列」，在筆者的認知中，其方式不外乎就兩種，分別是「字串轉換」的方式，以及「數學運算」的方式。

首先是「字串轉換」的方式，程式碼如下：

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int[] plusOne(int[] digits) {

        StringBuilder builder = new StringBuilder();

        // 第一階段：將「數列」轉換成「數值」
        for (int digit : digits) builder.append(digit);

        int idx = lastIndexOfNotNineRegEx(builder.toString());

        // 第二階段：將「數值」轉換回「數列」
        if (idx != -1) { // 若「位數不變」
            for (int i = 0; i < digits.length; i++)  // 加「1」
                if (i == idx) digits[i] = builder.charAt(i) - '0' + 1;
                else if (i > idx) digits[i] = 0;
        } else { // 全為「9」的情況，位數改變，須建立新數列
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }

    private int lastIndexOfNotNineRegEx(String sourceStr) {
        int idx = -1;
        Matcher matcher = Pattern.compile("[0-8]").matcher(sourceStr);
        while (matcher.find()) idx = matcher.start();
        return idx;
    }
}
```

代碼非常地直覺，首先是「第一階段」的將「數列」轉換成「數值」的部分。

在該步驟，我們藉由「迴圈」和「StringBuilder」來轉換，這部分並沒有什麼特別的。

然後是「第二階段」的將「數值」轉換成「數列」的部分；若以純字串的處理方式，我們就必須找出在該「數值字串」中，最後一位非「9」的索引值；在找索引值的部分，我們可以藉由「正規表示式」來搜尋。

在找到索引後，我們有兩件事情要做，第一，是將最後一位非「9」整數的數值「加一」，所以程式碼如下：

```java
if (i == idx) digits[i] = builder.charAt(i) - '0' + 1;
```

這邊要特別注意，由於我們是用「`charAt()`」，所以回傳的是「字元」，根據「ASCII」的規則，因此，我們只要將該數值減去字元「`'0'`」，就可以得到整數值；然後就是「Plus One」。

另外一件事情，若最後一位非「9」整數的索引值不是「個位數」，則代表，該整數後的「位數」，其數值全部是「9」，因此，須將它們都都置換為「0」。

唯一比較須要注意的是該數列的數值全部都為「9」的情況，此時的進位將會改變「位數」，如下圖：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0066_plus_one_10n_sub_1.png?raw=true)

此時，我們就必須建立一個新陣列且陣列長度為原陣列加一，然後再將陣列首項的數值改為「1」。

---

#### 解析二、數學運算法

其思路就是利用「四則運算」來轉換，代碼如下：

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int digit = 0;

        // 第一階段：將「數列」轉換成「數值」
        for (int i = 0; i < digits.length; i++)
            digit += digits[i] * Math.pow(10, (digits.length - 1 - i));

        // 加一 && 判斷位數
        if ((int) Math.log10(++digit) + 1 == digits.length) {
            // 第二階段：將「數值」轉換回「數列」
            for (int i = 0; digit != 0; digit /= 10, i++) {
                int idx = digits.length - 1 - i;
                digits[idx] = digit % 10;
            }
        } else {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
```

在上述代碼中，因為想強調是「數學運算」，因此筆者改用「Math.log10()」來判斷該目標整數的「位數」；輕鬆搞定，然後筆者用愉悅的心情把這段程式碼放到「LeetCode」上去驗證，結果顯示：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0066_plus_one_wrong_answer.png?raw=true)

幹，人生好難！

事實上，思路應該是沒問題的，而失敗的原因在於「int」的大小不足。

所以筆者又嘗試了改以「long」、「double」來實作；但全部都闖關失敗；不是數值不夠，就是精度不足；簡單一句話總之，數字太大；既然如此，只好拿出殺手鐧：「躺平」⋯，恩，不是啦，是「Big Number」。

碼農魂燃燒後，程式碼，「Pass」的程式碼如下：

```java
import java.math.BigDecimal;
import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {

        BigInteger digit = BigInteger.ZERO;

        // 第一階段：將「數列」轉換成「數值」
        for (int i = 0; i < digits.length; i++)
            digit = digit.add(BigInteger.valueOf(digits[i]).multiply(BigDecimal.TEN.pow(digits.length - 1 - i).toBigInteger()));

        // 加「1」
        digit = digit.add(BigInteger.ONE);

        // 第二階段：將「數值」轉換回「數列」
        if (bigIntegerLog10(digit) == digits.length)
            for (int i = 0; i < digits.length; i++) {
                digits[digits.length - 1 - i] = digit.mod(BigInteger.TEN).intValue();
                digit = digit.divide(BigInteger.TEN);
            }
        else {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
    
    private int bigIntegerLog10(BigInteger digit) {
        int digitSize = 0;

        for (; !digit.equals(BigInteger.ZERO); digitSize++) 
            digit = digit.divide(BigInteger.TEN);
        return digitSize;
    }
}
```

呃⋯，別問！

天知道這是什麼鬼！

其實程式的邏輯架構與前面都解法都是相同的，只是程式碼須改成「Big Number」的方式；其中有個比較特別的地方是在「長度判斷」的部分，也就是「bigIntegerLog10()」中的程式碼。

事實上，計算「Big Number」比較常見的兩種，一種是「字串轉換」；也就是將「目標整數」的數值轉換成字串後，再藉由「String.length()」去計算該字串的長度；這也是最直覺且容易理解的方式。

而另一種就是透過「數學運算」，簡單說，就是透過除以「10」的方式；其實，該方式就等同於對目標數值取「$Log_{10}$」。

只是在必須使用「Big Number」的情況下，我們就無法直接使用「Math.log10()」而已。

---

#### 解析三、逐一判斷法

雖然「土法煉鋼式」的思路非常直接，但它們或多或少都存在一些問題，如「效能不差」、「代碼不直覺、可讀性差」⋯等；在多數時候，只要稍微調整一下思路，往往就會有更好的解決方式。

以本題來說：「加一」，其運算邏輯一定是從「個位數」開始，也就說，假設不管進位的話，題目給予的陣列與要求我們回傳的陣列，其差異只會在陣列的最末項元素，對其「加一」，如下：

```java
public int[] plusOne(int[] digits) {
    digits[digits.length - 1] += 1;
    return digits;
}
```

但問題在於「進位」，因為是「十進制」，所以當該項元素為「9」時，就必須「進位」；而「進位」的邏輯是下一個位數加一，起當前位數歸零。

也就是說，個位數進位，就代表「十位數加一」且「個位數歸零」；而同樣邏輯，「十位數進位」就代表「百位數加一」且「十位數歸零」⋯以此類推；所以這題我們只須要從「個位數」開始往前逐「位數」檢查；當前位數不是「9」的，就直接將之加一，並返回即可；若是「9」的，將該項元素歸零後，再往下一個位數尋找，若下一位數仍為「9」的話，就同樣歸零再往前找，直接找到非「9」的元素，並對該元素「加一」後返回。

萬一都是「9」呢？就如前述一樣，新增一個陣列，並將首項設為「1」即可；因為「整數陣列」預設值為「0」，代碼如下：

```java
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--)
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else digits[i] = 0;
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
```

---

###### tags: `LeetCode` `Easy`