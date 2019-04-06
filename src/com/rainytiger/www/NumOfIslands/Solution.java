package com.rainytiger.www.NumOfIslands;

class Solution {

    char[][] grid;
    int[] direction = {0, -1, 0, 1, 0};

    int expand(int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == '0') return 0;
        grid[x][y] = '0';

        for (int i = 0; i < 4; i++) {
            expand(x + direction[i], y + direction[i + 1]);
        }

        return 1;
    }

    public int numIslands(char[][] grid) {
        int island = 0;
        this.grid = grid;
        for (int i = 0, x = grid.length; i < x; i++) {
            for (int j = 0, y = grid[i].length; j < y; j++) {
                island += expand(i, j);
            }
        }
        return island;
    }
}
