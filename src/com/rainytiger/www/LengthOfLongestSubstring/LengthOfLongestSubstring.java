package com.rainytiger.www.LengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> map = new HashSet<>();
        int ret = 0, i = 0, j = 0, n = s.length();
        while (i < n && j < n) {
            if (map.contains(s.charAt(j))) {
                map.remove(s.charAt(i++));
            } else {
                map.add(s.charAt(j++));
                ret = Math.max(ret, map.size());
            }
        }
        return ret;
    }
}
