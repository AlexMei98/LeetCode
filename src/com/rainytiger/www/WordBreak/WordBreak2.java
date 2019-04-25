package com.rainytiger.www.WordBreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {

    private Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, false);
    }

    private List<String> wordBreak(String s, List<String> wordDict, boolean flag) {
        if (wordDict.isEmpty()) return new ArrayList<>();
        if (map.containsKey(s)) return map.get(s);
        List<String> ret = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            if (flag) ret.add("");
            return ret;
        }
        for (String left : wordDict) {
            if (s.startsWith(left)) {
                List<String> temp = wordBreak(s.substring(left.length()), wordDict, true);
                for (String right : temp) {
                    ret.add(left + (right.equals("") ? "" : " ") + right);
                }
            }
        }
        map.put(s, ret);
        return ret;
    }
}
