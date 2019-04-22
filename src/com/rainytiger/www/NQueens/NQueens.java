package com.rainytiger.www.NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    int n;
    String[] cache;
    int[] map;
    List<List<String>> ret;

    private void getCache() {
        cache = new String[n];
        char[] cacheC = new char[n];
        Arrays.fill(cacheC, '.');
        StringBuilder sb = new StringBuilder(String.valueOf(cacheC));
        for (int i = 0; i < n; i++) {
            StringBuilder tsb = new StringBuilder(sb);
            tsb.setCharAt(i, 'Q');
            cache[i] = tsb.toString();
        }
        map = new int[n];
        ret = new ArrayList<>();
    }

    private List<String> getStrings() {
        List<String> r = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            r.add(cache[map[i]]);
        }
        return r;
    }

    private boolean pass(int x, int y) {
        for (int i = 0; i < x; i++) {
            if (map[i] == y) return false;
            if (map[i] - i == y - x) return false;
            if (map[i] + i == y + x) return false;
        }
        return true;
    }

    private void dfs(int x, int y) {
        if (pass(x, y)) {
            map[x] = y;
            if (x == n - 1) {
                ret.add(getStrings());
                return;
            }
            for (int i = 0; i < n; i++) {
                dfs(x + 1, i);
            }
        }
    }

    public List<List<String>> solveNQueens(int N) {
        n = N;
        getCache();
        for (int i = 0; i < n; i++) {
            dfs(0, i);
        }
        return ret;
    }
}
