package com.rick.problems;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

    public static void main(String[] args) {
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        Codec codec = new Codec();
        codec.decode(codec.encode(longUrl));
    }
}

class Codec {
    Map<String, String> map = new HashMap<>();

    public String encode(String longUrl) {
        String shortUrl = toBase36(longUrl.hashCode());
        map.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    private String toBase36(int hashCode) {
        StringBuilder result = new StringBuilder();
        while (hashCode > 0) {
            int rem = hashCode % 36;
            if (rem < 10) result.append('0' + rem);
            else result.append('a' + rem - 10);
            hashCode /= 36;
        }
        return result.reverse().toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));