package com.rainytiger.www.PerfectSquares;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int numSquares(int n) {
        if (n <= 3) return n;
        int max = (int) Math.sqrt(n);
        if (max * max == n) return 1;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= max; i++) list.add(i * i);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < max; i++) queue.add(n - list.get(i));

        int length = queue.size();
        int level = 1;
        while (true) {
            while (length > 0) {
                int temp = queue.poll();
                length--;
                if (list.contains(temp)) {
                    return level + 1;
                }
                for (int i = 0; i < max; i++) {
                    int num = list.get(i);
                    if (num > temp) break;
                    queue.add(temp - num);
                }
            }
            length = queue.size();
            level++;
        }
    }
}
