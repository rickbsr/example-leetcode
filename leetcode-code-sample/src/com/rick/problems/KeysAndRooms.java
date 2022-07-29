package com.rick.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {

    private Set<Integer> keys;

    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(3);
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(0);
        row2.add(1);
        List<Integer> row3 = new ArrayList<>();
        row3.add(2);
        List<Integer> row4 = new ArrayList<>();
        row4.add(2);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(row1);
        rooms.add(row2);
        rooms.add(row3);
        rooms.add(row4);
        boolean res = new KeysAndRooms().canVisitAllRooms(rooms);
        System.out.println(res);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        keys = new HashSet<>();
        dfs(0, rooms);
        return keys.size() == rooms.size();
    }

    private void dfs(int key, List<List<Integer>> rooms) {
        if (keys.add(key)) for (int i : rooms.get(key)) dfs(i, rooms);
    }
}
