package com.rainytiger.www.WordBreak;

import java.util.Collections;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        if (wordDict == null || wordDict.isEmpty()) return false;

        s = s.toLowerCase();
        wordDict.sort(Collections.reverseOrder());

        int n = wordDict.size();
        int l = s.length();
        boolean[] cs = new boolean[26];
        boolean[][] flag = new boolean[l][l];
        int[][] map = new int[26][2];

        char t = wordDict.get(0).charAt(0);
        for (int i = 0; i < n; i++) {
            String string = wordDict.get(i).toLowerCase();
            char c = string.charAt(0);
            if (string.length() == 1) {
                cs[c - 'a'] = true;
            }
            if (t != c) {
                map[t - 'a'][1] = i;
                t = c;
                map[t - 'a'][0] = i;
            }
        }
        map[t - 'a'][1] = n;

        for (int i = 0; i < l; i++) {
            flag[i][i] = cs[s.charAt(i) - 'a'];
        }
        for (int delta = 1; delta < l; delta++) {
            for (int left = 0; left + delta < l; left++) {
                char c = s.charAt(left);
                String sub = s.substring(left, left + delta + 1);
                for (int i = map[c - 'a'][0], end = map[c - 'a'][1]; i < end; i++) {
                    if (sub.equalsIgnoreCase(wordDict.get(i))) {
                        flag[left][left + delta] = true;
                        break;
                    }
                }
                for (int mid = left; mid < left + delta; mid++) {
                    if (flag[left][left + delta]) break;
                    flag[left][left + delta] = flag[left][mid] && flag[mid + 1][left + delta];
                }
            }
        }
        return flag[0][l - 1];
    }
}
