package com.rainytiger.www;

import com.rainytiger.www.NQueens.*;

public class Main {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }

}
