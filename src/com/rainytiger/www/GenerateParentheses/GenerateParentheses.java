package com.rainytiger.www.GenerateParentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {

    private List<String>[][] cache;

    private List<String> dfs(int stack, int res) {
        if (cache[stack][res] != null) return cache[stack][res];
        List<String> temp = new ArrayList<>();
        if (res == 0) {
            if (stack == 0) {
                cache[stack][res] = temp;
                return temp;
            }
            char[] cs = new char[stack];
            Arrays.fill(cs, ')');
            String right = String.valueOf(cs);
            temp.add(right);
            cache[stack][res] = temp;
            return temp;
        }
        List<String> t;
        if (stack != 0) {
            t = dfs(stack - 1, res);
            for (String s : t) {
                temp.add(")" + s);
            }
        }
        t = dfs(stack + 1, res - 1);
        for (String s : t) {
            temp.add("(" + s);
        }
        cache[stack][res] = temp;
        return temp;
    }

    public List<String> generateParenthesis(int n) {
        cache = new List[n + 1][n + 1];
        return dfs(0, n);
    }
}
