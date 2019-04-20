package com.rainytiger.www.String2Integer;

public class String2Integer {

    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty() ||
                (str.charAt(0) < '0' && str.charAt(0) > '9' && str.charAt(0) != '-' && str.charAt(0) != '+')) {
            return 0;
        }

        boolean flag = false;
        if (str.charAt(0) == '-') {
            flag = true;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }

        if (str.isEmpty() || (str.charAt(0) < '0' && str.charAt(0) > '9')) {
            return 0;
        }
        int i = 0;
        int temp = 0;
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            int r = str.charAt(i++) - '0';
            if (temp > Integer.MAX_VALUE / 10) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else if (temp == Integer.MAX_VALUE / 10) {
                if (flag && r > 8) return Integer.MIN_VALUE;
                else if (!flag && r > 7) return Integer.MAX_VALUE;
                else {
                    temp = temp * 10 + r;
                }
            } else {
                temp = temp * 10 + r;
            }
        }
        return (flag ? -1 : 1) * temp;
    }
}
