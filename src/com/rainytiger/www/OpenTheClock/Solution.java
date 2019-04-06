package com.rainytiger.www.OpenTheClock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int openClock(String[] deadends, String target) {
        Set<String> front = new HashSet<>();
        Set<String> back = new HashSet<>();
        Set<String> swap = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        front.add("0000");
        back.add(target);
        int level = 0;
        while (!front.isEmpty() && !back.isEmpty()) {
            if (front.size() > back.size()) {
                swap = back;
                back = front;
                front = swap;
            }
            swap = new HashSet<>();
            for (String temp : front) {
                if (back.contains(temp)) return level;
                if (deads.contains(temp)) continue;
                deads.add(temp);
                StringBuilder stringBuilder = new StringBuilder(temp);
                for (int i = 0; i < 4; i++) {
                    char c = temp.charAt(i);
                    String up = stringBuilder.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + stringBuilder.substring(i + 1);
                    String down = stringBuilder.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + stringBuilder.substring(i + 1);
                    if (!deads.contains(up))
                        swap.add(up);
                    if (!deads.contains(down))
                        swap.add(down);
                }
            }
            level++;
            front = swap;
        }
        return -1;
    }
}
