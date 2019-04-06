package com.rainytiger.www;

import com.rainytiger.www.OpenTheClock.Solution;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] deadends = {"8888"};
        System.out.println(solution.openClock(deadends, "0009"));
    }

}
