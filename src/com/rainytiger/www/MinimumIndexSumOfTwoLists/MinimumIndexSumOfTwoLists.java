package com.rainytiger.www.MinimumIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.List;

public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length - 1, len2 = list2.length - 1;
        List<String> list = new ArrayList<>();
        for (int i = 0, len = len1 + len2; i <= len; i++) {
            int left;
            if (i > len2) left = i - len2;
            else left = 0;
            while (left <= len1 && left <= i) {
                if (list1[left].equals(list2[i - left])) list.add(list1[left]);
                left++;
            }
            if (!list.isEmpty()) break;
        }
        String[] ret=new String[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
