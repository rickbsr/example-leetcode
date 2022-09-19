# LeetCode 0028. Find the Index of the First Occurrence in a String
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)

#### 難度：Medium

---

## 本文

#### 說明

題目會給我們兩個字串，其分別為「needle」和「haystack」。然後題目的要求是，倘若字串「needle」為字串「haystack」的子字串，則將「haystack」中的匹配「needle」的部分，其第一個字母的索引值返回；但如果若字串「needle」並非字串「haystack」的子字串，則回傳「`-1`」。

###### 限制：字串的組成皆為小寫英文字母。

---

#### 解析一、暴力破解法

這題是演算法標準題型之一：實作「字串搜索」。

題目所描述規則其實就是「Java」中的「`String.indexOf()`」方法。

廢話不多說，最先介紹的是「暴力破解法」；若一言以蔽之，即「逐一匹配」。

所謂「逐一匹配」是指，我們會將「目標文本」的每個索引值都作為「匹配字串」的起始位置，並與「樣版字串」作匹配，若「匹配失敗」，就會將「目標文本」的索引值往下一個字元移動，再以該索引值的字元為起始位置，同樣與「樣版字串」作匹配，若還是「匹配失敗」，就再將「目標文本」的索引值往下一個字元移動⋯，以此類推，直到「匹配失敗」或是將「目標文本」檢索完畢。

上敘述中，「目標文本」指的是要被檢索的字串，也就是字串「haystack」；而「樣版字串」指的就是字串「needle」，示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_brute_force.png?raw=true)

程式碼如下：

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        outer:
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++)
                if (haystack.charAt(i + j) != needle.charAt(j)) continue outer;
            return i;
        }
        return -1;
    }
}
```

在代碼部分，這是一個「雙層迴圈」的結構；其「外層迴圈」的目的是遍歷字串「haystack」，如先前介紹所說的，其索引值指向的是「匹配字串」的起始位置。

而「內層迴圈」的就是在執行「字串匹配」的部分。

至此，「暴力破解法」算是已經介紹完畢了。

但筆者在搜尋資料時，發現一個很有趣的解法，它主要是藉由「`String.startWith()`」來判斷，程式碼如下：

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++)
            if (haystack.substring(i).startsWith(needle)) return i;
        return -1;
    }
}
```

---

事實上，它仍是個「暴力破解法」，筆者覺得有趣的部分是，在該段程式碼中，其以「`String.startWith()`」來實現，而不是更常見的「`String.equals()`」。

但說真的，不論是「`String.startWith()`」或是「`String.equals()`」，若是在實際的演算法測驗中，通常都是不能使用的。

然後，筆者再分享一個相當有意思的思路，就是藉由「計算字元總和」先過濾以減少「字串匹配」的字數。

聽起來很酷，對吧？我們來說明一下。

事實上，它仍是基於「暴力破解」的解題方式。

在先前，我們曾說過，所有「英文字母」都可以依據「ASCII」編碼對應到一個「唯一的數值」；而這也意味著，若兩個字串相同，其字串中所有組成字母的「ASCII」碼總和也要相同，對吧？

根據這個概念，我們就可以在字串開始比對之前，先分別將要比較的兩個字段依據其字母組成計算其「ASCII」碼的總和。

若兩者的總和一致，才進一步去做該字段的字串完整比對，反之，就略過此次匹配，其概念圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_sum.png?raw=true)

實作的程式碼如下：

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int needleSum = 0, haystackBaseSum = 0;
        if (needle.isEmpty()) return 0;
        if (haystack.length() >= needle.length()) {
            for (int i = 0; i < needle.length(); i++) {
                needleSum += needle.charAt(i);
                haystackBaseSum += haystack.charAt(i);
            }

            for (int i = 0; i <= haystack.length() - needle.length(); i++)
                if (haystackBaseSum == needleSum && haystack.substring(i).startsWith(needle)) return i;
                else if (i == haystack.length() - needle.length()) break;
                else haystackBaseSum += (haystack.charAt(i + needle.length()) - haystack.charAt(i));
        }
        return -1;
    }
}
```

其實說穿了，就是在「字串匹配」之前，多增加一個「字元總和」的判斷條件；雖然這個思路的確很有趣；但筆者認為，其應該不能為代碼優化提供多少效益，加上它有一定的侷限性，實際上用處並不大。

但酷，就值得分享。

---

#### 解析二、「KMP」法

在上述「暴力破解法」的代碼中，其邏輯是以「逐一匹配」，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_kmp_bf.png?raw=true)

但「逐一匹配」的效率並不好，所以，就有科學家想，是不是有什麼辦法能減少「字串匹配」的次數，進而提高「字串搜尋」的效率；例如在「字串匹配」失敗後，可以多略過幾個「字元」，再執行下次的「字串匹配」。

有的，「[KMP Algorithm](https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm)」就是其中之一種方式；「KMP」是三個人的名字開頭，他們分別是「Knuth」、「Morris」以及「Pratt」；而「KMP Algorithm」就是由他們三人共同發表關於「字串搜尋」的演算法。

在「KMP Algorithm」中，有個關鍵的參考表：「Partial Match Table（PMT）」。

我們可以根據「PMT」上的訊息來判斷執行每次「字串匹配」後，其可以略過的字元數。

為什麼「PMT」那麼厲害？可以知道能跳過幾個字元？

其原理是利用「樣板字串」的「共同前後綴」作為判斷的依據；它的作法是先從找出「樣版字串」中，所有不含自己的「前綴字串們」，再根據這些字串一一的找出其各自的「最長共同前後綴」。

呃⋯，嗯⋯，還是看例子吧。

假設「目標文本」為「haystack」，值為「`abaacabababc`」；而「樣版字串」為「needle」，值為「`ababc`」。

首先，我們會依據「樣版字串」來建立「PMT」；第一步，先將字串中不含自己的所有「前綴字串」列出，以「needle」來說，其結果分別為「`a`」、「`ab`」、「`aba`」、「`abab`」，如下圖：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_ps.png?raw=true)

接著，我們再分別依據這些「前綴字串們」的「前綴」與「後綴」，再去求出其最大的「共同前後綴」的長度。

第一個「前綴字串」是「`a`」，由於「`a`」沒有非自己的「前綴」或「後綴」，所以也沒有「共同前後綴」，因此也沒有長度問題，填「0」；接著，下一個的「前綴字串」是「`ab`」，其非自己的「前綴」字串僅有「`a`」，同樣的，其非自己的「前綴」字串只有「`b`」，所以，它倆沒有共同的「項目」，同上，填「0」，示意圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_pmt_ab.png?raw=true)

再下一個「前綴字串」是「`aba`」，其非自己的「前綴」有「`a`」、「`ab`」，而非自己的「後綴」則是有「`a`」、「`ba`」，其共同字串為「`a`」，長度為「1」，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_pmt_aba.png?raw=true)

最後一個「前綴字串」是「`abab`」，其長度小於自己的「前綴」有「`a`」、「`ab`」、「`aba`」，而長度小於自己的「後綴」則是有「`b`」、「`ab`」、「`bab`」，所以其「共同項」為「`ab`」，長度為「2」，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_pmt_abab.png?raw=true)

根據上面的資訊建立「PMT」，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_kmp_pmt.png?raw=true)

之後，我們就可以根據「PMT」來比對，我們將一步一步來講解比對的過程，第一次比對如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_kmp_step_1.png?raw=true)

一開始，起始的索引為在在「目標文本」的「第一項」；即字串「haystack」中的的第一個「`a`」。

根據「樣版字串」執行字串比對後，其結果為前三個字元匹配，即「`aba`」。

對應「PMT」，其值為「1」；意思是「`aba`」的「最大共同前後綴」的長度為「1」。

那這個資訊有什麼用處呢？

如果「PMT」值為「0」，也就是不存在「最大共同前後綴」，代表其「前綴」與「後綴」沒有重疊的部分，既然不存在「相同的前後綴」，就代表字串不可以重用，所以將之移出，代表下次的比對，我們可以「比對失敗」的位置對齊「樣版字串」的第一項。

若「PMT」值非「0」呢？

那就代表該字串有存在「相同的前後綴」，而重覆的部分，我們可以重用，因此，我們就需要將「needle」往前退，而偏移多少則是根據「PMT」值。

這邊要注意，此處的偏移是指「needle」，而不是「haystack」，「haystack」的索引仍是在剛才「比對失敗」的位置。

第一次「字串匹配」結束後，我們接著第二次「字串匹配」，如下圖：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_kmp_step_2.png?raw=true)

直接「匹配失敗」，此時，「PMT」值是根據「`a`」；雖然在這次字串匹配中，我們並沒有去比對「`a`」，但「`a`」的確是匹配成功的部分。

而這次「PMT」值就是「0」，所以將「needle」的第一項對齊剛才「比對錯誤」的位置。

執行第三次「字串比對」，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_kmp_step_3.png?raw=true)

此次結果與上次相同，「匹配字串」為「`a`」，值為「0」，同樣是將「needle」的第一項對齊剛才「比對錯誤」的位置。

接著是第四次匹配，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_kmp_step_4.png?raw=true)

這是一個「完全不匹配」的例子，作法就是「完全移出」，也就是將「needle」的第一項移到「比對錯誤」之後；有些人會將其「PMT」值定義為「`-1`」，意思是一樣的，但口語上更為一致；說法就是：將「needle」的「`-1`」項對齊原本「比對錯誤」的位置。

然後是第五次匹配，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_kmp_step_5.png?raw=true)

同樣地，「匹配字串」為「`abab`」，「PMT」為「2」，就一樣畫葫蘆；然後就再下一次「匹配」，完全匹配，收工！

完整的流程圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_kmp_step_all.png?raw=true)

原理懂了，實作就簡單了，代碼，如下：

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() <= haystack.length()) {
            int[] f = failureFunction(needle.toCharArray());
            int i = 0, j = 0;
            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                    if (j == needle.length()) return i - j;
                } else if (j > 0) j = f[j];
                else i++;
            }
        }
        return -1;
    }

    private int[] failureFunction(char[] str) {
        int[] pmt = new int[str.length + 1];
        for (int i = 2; i < pmt.length; i++) {
            int j = pmt[i - 1];
            while (j > 0 && str[j] != str[i - 1]) j = pmt[j];
            if (j > 0 || str[j] == str[i - 1]) pmt[i] = j + 1;
        }
        return pmt;
    }
}
```

在上述代碼中的「failureFunction()」方法中，其目的就是建立「PMT」；根據上述，我們就會知道，在「PMT」中，第一個值是「-1」、第二個值是「0」，所以我們只要從索引「2」開始判斷就可以。

---

#### 解析五、「BM」法

接著「KMP」演算法之後的是使用「[BM Algorithm](https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_string-search_algorithm)」的解題方式。

與「KMP」演算法相同，「BM」演算法也是一個用於文字搜尋的演算法；「BM」也同樣是「Boyer」跟「Moore」兩位科學家名字的開頭。

接著我們就來介紹一下其原理，其實「BM」演算法的核心是「壞字符」與「好後綴」兩種算法。

首先是「壞字符」算法，我們直接舉例來說明，假設字串「haystack」的值為「`abcfaacddabcd`」，「needle」的值為「`abcd`」；其第一步驟的示意圖，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_bm_step_1.png?raw=true)

在「BM」演算法中，字串比對都是從「樣版字串」的最末位開始比對，因此，第一個比對是「haystack」的「`f`」與「needle」的「`d`」，匹配失敗；此時，我就們將「`f`」稱為的壞字符。

又因為「`f`」並非，「needle」中的任何字元，也就說，只要字串的比對區間內有「`f`」，其就不可能比對成功；因此，我們可以將「needle」移到「`f`」之後，而這樣的行為，我們就稱之為「完全移出」。

接著是第二步驟，如下圖：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_bm_step_2.png?raw=true)

同樣從「最後一位」開始比對，先匹配「`d`」，匹配成功，接著，匹配「`c`」，同樣也成功，然後是「`a`」，「匹配失敗」，所以這次的壞字符是「`a`」。

但這次要注意，「`a`」是「needle」中的字元；而且在「needle」中，仍有其它的「`a`」字符位於剛才匹配失敗的字元，也就是「`b`」字元之前；所以我們這次不能完全移除，而是必須將「needle」的「`a`」與之對齊。

順帶一提，若前面有兩個「`a`」，則須對齊的靠近剛才匹配失敗的那個字元，也就是靠後的那個。

然後是下次匹配，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_bm_step_3.png?raw=true)

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0028_find_the_index_of_the_first_occurrence_in_a_string_bm_step_all.png?raw=true)

---

#### 解析六、巨人的肩膀法

---

###### tags: `leetcode` `java` `easy`