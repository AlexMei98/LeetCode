package com.rainytiger.www;

import com.rainytiger.www.WordBreak.WordBreak;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(
                "pineapplepenapple",
                new ArrayList<>(Arrays.asList("pine", "pineapple", "apple", "pen", "applepen"))
        ));
    }

}
