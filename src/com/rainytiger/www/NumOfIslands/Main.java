package com.rainytiger.www.NumOfIslands;

public class Main {

    public static void main(String[] args) {
        char[][] map = {
                "11000".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00101".toCharArray()
        };
        Solution solution = new Solution();
        System.out.println(solution.numIslands(map));
    }
}
