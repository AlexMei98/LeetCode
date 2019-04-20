package com.rainytiger.www.LongestPalindrome;

import java.util.Arrays;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String str = "#" + String.join("#", s.split("")) + "#";
        int[] RL = new int[str.length()];
        int maxRight = 0, pos = 0, maxLength = 0, POS = 0;

        for (int i = 0, length = RL.length; i < length; i++) {
            if (i < maxRight) {
                RL[i] = Math.min(RL[2 * pos - i], maxRight - i);
            } else {
                RL[i] = 1;
            }
            while (i - RL[i] >= 0 && i + RL[i] < length && str.charAt(i - RL[i]) == str.charAt(i + RL[i])) {
                RL[i]++;
            }
            if (RL[i] + i > maxRight) {
                maxRight = RL[i] + i;
                pos = i;
            }
            if (maxLength <= RL[i]) {
                maxLength = RL[i];
                POS = i;
            }
        }

        String sub = str.substring(POS - maxLength + 1, POS + maxLength);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < sub.length(); i += 2) {
            sb.append(sub.charAt(i));
        }
        return sb.toString();
    }
}
