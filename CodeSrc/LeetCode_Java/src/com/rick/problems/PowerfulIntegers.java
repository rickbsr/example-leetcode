package com.rick.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {

    public static void main(String[] args) {
        int x = 3, y = 5, bound = 15;
        List<Integer> res = new PowerfulIntegers().powerfulIntegers(x, y, bound);
        System.out.println(res);
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet<>();
        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                res.add(a + b);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(res);
    }
}
