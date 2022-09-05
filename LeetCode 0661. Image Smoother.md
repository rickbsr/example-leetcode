# LeetCode 0661. Image Smoother
Leetcode：Java

![](https://github.com/rickbsr/LeetCode/blob/main/pics/leetcode.png?raw=true)

---

## 概要

#### 題目：[Image Smoother](https://leetcode.com/problems/image-smoother/)

#### 難度：Easy

---

## 本文

#### 說明

題目會提供一個二維的整數陣列以模擬一張圖片的灰階表示圖，該陣列中的每個數值皆代表圖片對應的位置的灰階值。

而題目需求是將圖片進行平滑演算，意即要將每個像素點的數值修正為與鄰近九宮格的平均值，若該像素與其鄰近的像素未達八個，則盡可能計算所有符合需求的像素點，例如四個角落的像素點，又或是位於邊上的像素點。

###### 限制：陣列長寬的數值為「1 ~ 150」。
###### 限制：灰階值為「0 ~ 255」。

---

#### 解析一、暴力破解法

既然是「暴力破解法」，其概念就是直覺、暴力。

而思路就是將「長形花圃」的「花槽」逐一判斷；若槽內原本就有花，就跳過，若槽內為空，就接續判斷該索引位置的前後一格是否也為空，直到「花」全部被栽種到「花圃」中或是「花圃」內已無符合之「空地」；實作代碼如下：

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n != 0; i++)
            if (flowerbed[i] == 0 && // 代表當前格為空
                    (i == 0 || flowerbed[i - 1] == 0) && // 第一格 or 前一格
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) { // 最後一格 or 後一格
                flowerbed[i++] = 1; // 種植花後的下一格，必須為空
                n--;
            }
        return n == 0;
    }
}
```

上述的代碼雖非常直觀，但有幾點還是要特別注意一下，例如當「i」處於邊界時，即「i」為「0」與「flowerbed.length() - 1」時；因為邊界代表陣列的「起端」或「末端」，若對其進行「前後一格」的判斷，則必然有一邊會因為超出數列邊界而拋出「ArrayIndexOutOfBoundsException」。

---

#### 解析二、連續三個空地法

其實「連續三個空地法」只是一種換句話說而已；思考一下，「禁止花與花相鄰」的這個限制，若從「單一朵花」的角度來看，是不是就可以解讀成「須連續三個空地才能種植一朵花」？概念圖如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0605_can_place_flowers_a_set.png?raw=true)

所以，我們可以設置一個「flag」，作為連續空地的標記，當該「flag」等於「3」時，代表已經有連續三塊空地，意即，可以栽種「一朵花」。

接著，我們將以上述的核心思路來實作代碼。

代碼邏輯可以分為以下幾個部分，首先是「起點」的判斷，如下：

仔細思考一下，由於「起點」是數列邊界，也就是說，它的左邊就是「長形花圃」的範圍外，也因此，該位置不可能種植「花」；而題目的要求是「禁止兩朵花相鄰」，也就是說，我們其實可以將左邊界視為「一塊空地」，如下：

![](https://github.com/rickbsr/LeetCode/blob/main/pics/0605_can_place_flowers_0.png?raw=true)

既然左邊界是ㄧ塊空地，所以我們只須將「flag」初始值設置為「1」，就解決了。

搞定「起點」的邏輯之後，就是核心的迴圈內邏輯，如下：

```java
int idx = 0, flag = 1; // 起點

do {
    if (flowerbed[idx] == 1) { // 空格
        flag = 1;
        idx++;
    } else if (++flag == 3) {
        flag = 1;
        n--;
    }
} while (++idx < flowerbed.length && n != 0);
```

這邊會有兩個情況，第一是當前索引為「花」，第二是當前索引為「空地」。

若遇到「花」，代表「連續空地」必須重新計算，因此，將「flag」歸「0」；事實上，這個邏輯並沒有問題，但是稍微推導一下就會發現：「由於題目的條件限制，既然這格為「花」，那麼下一個必然是「空地」，一個無法種植「花」的空地。

那既然確定了下一格必定是不能種花的空地，所以，我們可以直接略過它，直接從下一格在判斷起即可；但因為略過了空地，所以我們必須將「idx」加「1」，以及將「flag」設置為「1」。

反之，倘若遇到的是「空地」，那會有兩種情況，第一種情況是當前這塊空恰為「第三塊」的連續空地；這意味著，我們可以在這連續三塊空地中的「第二塊」空地種植花；但因為「第二塊空地」種花了，所以「第三塊空地」必然還是空地，既然是空地，我們當然可以將它視為下一個「連續三塊空地」的「第一塊空地」，也就是將「flag」設置為「1」。

最後，末端的部分，同樣地它也是邊界值，於是就當個特地判斷即可，用一個「if」判斷式解決即可，如下：

```java
if (flowerbed[flowerbed.length - 1] == 0 && n == 1 && flag > 1) return true;
```

上面代碼中的「flag > 1」，其實等同於「flowerbed[flowerbed.length - 2] == 0」；但是考量到題目提供的數列長度可能為「2」，此時，若用「flowerbed[flowerbed.length - 2] == 0」會超出邊界，丟出「ArrayIndexOutOfBoundsException」；因此建議使用「flag > 1」取代。

代碼如下：

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int idx = 0, flag = 1; // 起點

        do {
            if (flowerbed[idx] == 1) { // 代表空格有花
                idx++;
                flag = 1;
            } else if (++flag == 3) { // 代表空格無花且已經累積連續三塊空地
                n--; // 種花
                flag = 1;
            }
        } while (++idx < flowerbed.length && n != 0);

        // 末端
        if (n == 1 && flowerbed[flowerbed.length - 1] == 0 && flag > 1)
            return true;

        return n == 0;
    }
}
```

雖然代碼已經可以通過「LeetCode」的測試了，但後面的「if」判斷式多少顯得有些格格不入；其實「末項」也是「邊界值」，如同「起點」一樣，我們同樣可以將「邊界」視為一塊空地，因此，我們就稍微調整一下，代碼如下：

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] newFlowerbed = Arrays.copyOf(flowerbed, flowerbed.length + 1);

        for (int i = 0, flag = 1; i < newFlowerbed.length && n != 0; i++) {
            if (newFlowerbed[i] == 1) i++;
            else if (++flag == 3) n--;
            else continue;
            flag = 1;
        }
        return n == 0;
    }
}
```

其實邏輯都一樣，最主要的差異在於「我們產生了一個長度多『1』的新陣列」，其前面「數值」全部相同，最後一項為「0」；如此一來，我們就可以不用將最後一項當作特例判斷，自然就可以拿掉礙眼的「if」判斷式。

其餘中間迴圈邏輯全部相同，此處只是筆者手癢，將「do-while Loop」改成「for Loop」，僅此而已。

---

###### tags: `LeetCode` `Easy`