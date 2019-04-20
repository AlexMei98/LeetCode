package com.rainytiger.www.ZigZagConversion;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int N = (numRows << 1) - 2;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        for (int j = 0; j < s.length(); j++) {
            int k = j % N;
            if (k < numRows) {
                sbs[k].append(s.charAt(j));
            } else {
                sbs[N - k].append(s.charAt(j));
            }
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb: sbs) {
            ret.append(sb);
        }
        return ret.toString();
    }
}
