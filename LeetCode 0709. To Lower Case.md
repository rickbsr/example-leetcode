# LeetCode 0709. To Lower Case
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[To Lower Case](https://leetcode.com/problems/to-lower-case/)

#### 難度：Easy

---

## 本文

#### 說明

題目會給我們一個字串，並要求我們將其中的「大寫英文字元」轉為「小寫英文字元」。

---

#### 解析一、「ASCII」加法

首先，說明一下「[ASCII](https://en.wikipedia.org/wiki/ASCII)」，它的中文全名為「美國標準資訊交換碼」，是一套基於「[拉丁字符](https://en.wikipedia.org/wiki/Latin_script)」的「電腦編碼」體系；其當中將「現代英語」的常用字符，如英文字母、阿拉伯數字、標點符號⋯等，和一些與操作相關的字符，進行編碼；使之都能對應到一個相對的「唯一整數值」。

所以我們就可以該「唯一整數值」來進行「英文字母大小寫」的轉換，完整程式碼如下：

```java
class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
            if (chars[i] >= 'A' && chars[i] <= 'Z') chars[i] += 32;
        return String.valueOf(chars);
    }
}
```

代碼相當直覺，就是先將「字串」轉成「字元陣列」，然後再利用「ASCII」來判斷該字元是否為「大寫英文字母」；若是，將之加上「32」，該字元就會轉換成與之對應的「小寫英文字母」，概念圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0709_to_lower_case_add32.png?raw=true)

那為什麼是加「32」？

根據「ASCII」，我們可以查到「英文字母」的「A」到「Z」所對應的「十進位」整數值是「65」到「90」；而「a」到「z」則是對應「97」到「122」；也就是說，「大寫英文字母」與對應的「小寫英文字母」的「ASCII」編碼中，其相差「32」。

#### 解析二、「ASCII」互斥或法

其實就只是將「加」改為「互斥或」，如此而已。

實作的代碼如下：

```java
class Solution {
    public String toLowerCase(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray())
            builder.append((char) (Character.isUpperCase(c) ? c ^ ' ' : c));
        return builder.toString();
    }
}
```

咦？不是說好只是將「加」改為「互斥或」嗎？

啊原本的加「32」怎麼不見了？

事實上，並沒有不見喔，由於「32」剛好是「[Space](https://en.wikipedia.org/wiki/Space_(punctuation))」的「ASCII」編碼，所以我們也可以用「Space」字元來取代「32」。

所以這邊如果改成「`c ^ 32`」，也是可以的。

那為什麼可以用「互斥或」取代「加」？

剛才我們說過，根據「ASCII」編碼，我們可以知道「英文字母」的「A」到「Z」所對應的整數值是「65」到「90」；而「a」到「z」則是對應「97」到「122」，對吧？

| Upper | Dec |  Binary  | Lower | Dec |  Binary  |
|:-----:|:---:|:--------:|:-----:|:---:|:--------:|
|   A   | 65  | 01000001 |   a   | 97  | 01100001 |
|   B   | 66  | 01000010 |   b   | 98  | 01100010 |
|   C   | 67  | 01000011 |   c   | 99  | 01100011 |
|   D   | 68  | 01000100 |   d   | 100 | 01100100 |
|   E   | 69  | 01000101 |   e   | 101 | 01100101 |
|   F   | 70  | 01000110 |   f   | 102 | 01100110 |
|   G   | 71  | 01000111 |   g   | 103 | 01100111 |
|   H   | 72  | 01001000 |   h   | 104 | 01101000 |
|   I   | 73  | 01001001 |   i   | 105 | 01101001 |
|   J   | 74  | 01001010 |   j   | 106 | 01101010 |
|   K   | 75  | 01001011 |   k   | 107 | 01101011 |
|   L   | 76  | 01001100 |   l   | 108 | 01101100 |
|   M   | 77  | 01001101 |   m   | 109 | 01101101 |
|   N   | 78  | 01001110 |   n   | 110 | 01101110 |
|   O   | 79  | 01001111 |   o   | 111 | 01101111 |
|   P   | 80  | 01010000 |   p   | 112 | 01110000 |
|   Q   | 81  | 01010001 |   q   | 113 | 01110001 |
|   R   | 82  | 01010010 |   r   | 114 | 01110010 |
|   S   | 83  | 01010011 |   s   | 115 | 01110011 |
|   T   | 84  | 01010100 |   t   | 116 | 01110100 |
|   U   | 85  | 01010101 |   u   | 117 | 01110101 |
|   V   | 86  | 01010110 |   v   | 118 | 01110110 |
|   W   | 87  | 01010111 |   w   | 119 | 01110111 |
|   X   | 88  | 01011000 |   x   | 120 | 01111000 |
|   Y   | 89  | 01011001 |   y   | 121 | 01111001 |
|   Z   | 90  | 01011010 |   z   | 122 | 01111010 |

有沒有發現一件很有趣的事情？

就是「A」跟「a」、「B」跟「b」⋯，直到「Z」跟「z」，它們在二進制表示上，只有第「6」位的「位數不同」；也就是說，只要我們將其二進制表示中的第「6」位改變，就可以改變該字母的大小寫。

而改變第「6」位的方式就是，與「`0x100000`」作「Xor」運算，概念圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0709_to_lower_case_xor32.png?raw=true)

而「`0x100000`」的十進制數值就是「32」。

所以我們可以用「Xor」來進行「大小寫英文字母」的轉換。

#### 淺談源碼

在判斷「英文字母」是否為大寫時，在「ASCII」加法的實作代碼中，筆者是用「`ch >= 'A' && ch <= 'Z'`」的方式來判斷；但是在「ASCII」互斥或法的實作代碼中，筆者則是用「[`Character.isUpperCase()`](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isUpperCase-char-)」來判斷。

但兩者是相同的嗎？

當然不同，只是對以「英文」為主的使用者而言，沒有什麼差異而已；至於其中的區別，詳細內容可以參考「Oracle」的官方教程：「The Java™ Tutorials」中「[Checking Character Properties](https://docs.oracle.com/javase/tutorial/i18n/text/charintro.html)」的說明。

另外，就本題來說，在「Java」中也有提供同樣功能的「API」：「[String.toLowerCase()](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#toLowerCase--)」，那它又是如何實現的呢？

其主要實作在「[`String.toLowerCase(Locale locale)`](https://github.com/rickbsr/Java-Src/blob/main/temurin-1.8.0_345/src/java/lang/String.java#L2561)」中，源碼如下：

```java=
public String toLowerCase(Locale locale) {
    
    ...
        
    String lang = locale.getLanguage();
    boolean localeDependent =
            (lang == "tr" || lang == "az" || lang == "lt");
    char[] lowerCharArray;
    int lowerChar;
    int srcChar;
    int srcCount;
    for (int i = firstUpper; i < len; i += srcCount) {
        srcChar = (int)value[i];
        if ((char)srcChar >= Character.MIN_HIGH_SURROGATE
                && (char)srcChar <= Character.MAX_HIGH_SURROGATE) {
            srcChar = codePointAt(i);
            srcCount = Character.charCount(srcChar);
        } else {
            srcCount = 1;
        }
        if (localeDependent ||
            srcChar == '\u03A3' || // GREEK CAPITAL LETTER SIGMA
            srcChar == '\u0130') { // LATIN CAPITAL LETTER I WITH DOT ABOVE
            lowerChar = ConditionalSpecialCasing.toLowerCaseEx(this, i, locale);
        } else {
            lowerChar = Character.toLowerCase(srcChar);
        }
        
        ...
            
    }
    return new String(result, 0, len + resultOffset);
}
```

代碼當中，第「26」行：「`lowerChar = Character.toLowerCase(srcChar);`」，其就是負責將大寫的「英文字母」轉成小寫「英文字母」的部分。

至於其它的部分，像是「MIN_HIGH_SURROGATE」、「MAX_HIGH_SURROGATE」⋯等，因為它牽扯到「Unicode」、「UCS-2」和「UTF-16」⋯等相關知識，所以暫時先略過，挖個坑，以後有機會再填，若讀者想自行了解的可以參考「Oracle」的官方文件：「[Supplementary Characters in the Java Platform](https://www.oracle.com/technical-resources/articles/javase/supplementary.html)」。

接著，我們來看「`Character.toLowerCase()`」的內容，如下：

```java
public static int toLowerCase(int codePoint) {
    return CharacterData.of(codePoint).toLowerCase(codePoint);
}
```

其實源碼追到此處，我們不難看出「CharacterData」才是關鍵的類別，點擊「`of()`」方法，如下：

```java
static final CharacterData of(int ch) {
    if (ch >>> 8 == 0) {     // fast-path
        return CharacterDataLatin1.instance;
    } else {
        switch(ch >>> 16) {  //plane 00-16
        case(0):
            return CharacterData00.instance;
        case(1):
            return CharacterData01.instance;
        case(2):
            return CharacterData02.instance;
        case(14):
            return CharacterData0E.instance;
        case(15):   // Private Use
        case(16):   // Private Use
            return CharacterDataPrivateUse.instance;
        default:
            return CharacterDataUndefined.instance;
        }
    }
}
```

這是一個工廠模式的實踐，此處會根據字元的不同來給予不同的「CharacterData」實作實體。

至於其判斷的依據為何？它同樣牽涉到「Unicode」、「UCS-2」和「UTF-16」⋯等相關知識，所以暫時先略過，以後有機會再補坑。

而以本題的題目限制，其會使用的是「[CharacterDataLatin1](https://github.com/rickbsr/Java-Src/blob/main/temurin-1.8.0_345/src/java/lang/CharacterDataLatin1.java)」；因此，在「CharacterDataLatin1」中，我們就可以找到「[CharacterDataLatin1.toLowerCase(int ch)](https://github.com/rickbsr/Java-Src/blob/main/temurin-1.8.0_345/src/java/lang/CharacterDataLatin1.java#L132)」的源碼實作內容，如下：

```java
int toLowerCase(int ch) {
    int mapChar = ch;
    int val = getProperties(ch);

    if (((val & 0x00020000) != 0) && 
            ((val & 0x07FC0000) != 0x07FC0000)) { 
        int offset = val << 5 >> (5+18);
        mapChar = ch + offset;
    }
    return mapChar;
}
```

其中，「[`CharacterDataLatin1.getProperties(int ch)`](https://github.com/rickbsr/Java-Src/blob/main/temurin-1.8.0_345/src/java/lang/CharacterDataLatin1.java#L70)」是一個查表的方法，

```java
int getProperties(int ch) {
    char offset = (char) ch;
    int props = A[offset];
    return props;
}
```

而「[`A[]`](https://github.com/rickbsr/Java-Src/blob/main/temurin-1.8.0_345/src/java/lang/CharacterDataLatin1.java#L259)」的內容同樣在「CharacterDataLatin1」類別中能夠找到。

最後，我們根據「JDK8」中「`String.toUpperCase()`」實作方式，稍微修改一下，程式碼，如下：

```java
class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
            if (Character.isUpperCase(chars[i])) chars[i] = (char) toLowerCase(chars[i]);
        return String.valueOf(chars);
    }

    int toLowerCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if (((val & 0x00020000) != 0) &&
                ((val & 0x07FC0000) != 0x07FC0000)) {
            int offset = val << 5 >> (5 + 18);
            mapChar = ch + offset;
        }
        return mapChar;
    }

    int getProperties(int ch) {
        char offset = (char) ch;
        int props = A[offset];
        return props;
    }

    static final int A[] = new int[256];
    
    static final String A_DATA =
            "\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800" +
                    "\u100F\u4800\u100F\u4800\u100F\u5800\u400F\u5000\u400F\u5800\u400F\u6000\u400F" +
                    "\u5000\u400F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800" +
                    "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F" +
                    "\u4800\u100F\u4800\u100F\u5000\u400F\u5000\u400F\u5000\u400F\u5800\u400F\u6000" +
                    "\u400C\u6800\030\u6800\030\u2800\030\u2800\u601A\u2800\030\u6800\030\u6800" +
                    "\030\uE800\025\uE800\026\u6800\030\u2000\031\u3800\030\u2000\024\u3800\030" +
                    "\u3800\030\u1800\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u1800" +
                    "\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u3800\030\u6800\030" +
                    "\uE800\031\u6800\031\uE800\031\u6800\030\u6800\030\202\u7FE1\202\u7FE1\202" +
                    "\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1" +
                    "\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202" +
                    "\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1" +
                    "\202\u7FE1\uE800\025\u6800\030\uE800\026\u6800\033\u6800\u5017\u6800\033\201" +
                    "\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2" +
                    "\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201" +
                    "\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2" +
                    "\201\u7FE2\201\u7FE2\201\u7FE2\uE800\025\u6800\031\uE800\026\u6800\031\u4800" +
                    "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u5000\u100F" +
                    "\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800" +
                    "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F" +
                    "\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800" +
                    "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F" +
                    "\u3800\014\u6800\030\u2800\u601A\u2800\u601A\u2800\u601A\u2800\u601A\u6800" +
                    "\034\u6800\030\u6800\033\u6800\034\000\u7005\uE800\035\u6800\031\u4800\u1010" +
                    "\u6800\034\u6800\033\u2800\034\u2800\031\u1800\u060B\u1800\u060B\u6800\033" +
                    "\u07FD\u7002\u6800\030\u6800\030\u6800\033\u1800\u050B\000\u7005\uE800\036" +
                    "\u6800\u080B\u6800\u080B\u6800\u080B\u6800\030\202\u7001\202\u7001\202\u7001" +
                    "\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202" +
                    "\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001" +
                    "\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\u6800\031\202\u7001\202" +
                    "\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\u07FD\u7002\201\u7002" +
                    "\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201" +
                    "\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002" +
                    "\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\u6800" +
                    "\031\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002" +
                    "\u061D\u7002";

    static {
        { // THIS CODE WAS AUTOMATICALLY CREATED BY GenerateCharacter:
            char[] data = A_DATA.toCharArray();
            int i = 0, j = 0;
            while (i < (256 * 2)) {
                int entry = data[i++] << 16;
                A[j++] = entry | data[i++];
            }
        }
    }
}
```

或者，就如下：

```java
class Solution {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
```

收工。

---

###### tags: `leetcode` `java` `easy`