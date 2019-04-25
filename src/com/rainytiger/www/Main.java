package com.rainytiger.www;

import com.rainytiger.www.WordBreak.WordBreak2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        WordBreak2 wordBreak = new WordBreak2();
        System.out.println(wordBreak.wordBreak(
                "pineapplepenapple",
                new ArrayList<>(Arrays.asList("pine", "pineapple", "apple", "pen", "applepen"))
        ));
    }

}
