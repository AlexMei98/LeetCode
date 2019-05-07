package com.rainytiger.www;

import com.rainytiger.www.MinimumIndexSumOfTwoLists.MinimumIndexSumOfTwoLists;

public class Main {

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists x = new MinimumIndexSumOfTwoLists();
        String[] ret = x.findRestaurant(
                new String[]{"Shogun"},
                new String[]{"Shogun"}
        );
        for (String s : ret) {
            System.out.println(s);
        }
    }

}
