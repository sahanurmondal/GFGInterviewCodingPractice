package com.gfg.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix (mat[][]) the task to check if
the configuration has a solution or not.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each
test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state
where a 0 represents empty block.

Output:
For each test case in a new line print 1 if the sudoku configuration is valid else print 0.

Constraints:
1<=T<=10
0<=mat[]<=9

Example:
Input:
2
3 0 6 5 0 8 4 0 0 5 2 0 0 0 0 0 0 0 0 8 7 0 0 0 0 3 1 0 0 3 0 1 0 0 8 0 9 0 0 8 6 3 0 0 5 0 5 0 0 9 0 6 0 0 1 3 0 0 0 0 2 5 0 0 0 0 0 0 0 0 7 4 0 0 5 2 0 6 3 0 0
3 6 7 5 3 5 6 2 9 1 2 7 0 9 3 6 0 6 2 6 1 8 7 9 2 0 2 3 7 5 9 2 2 8 9 7 3 6 1 2 9 3 1 9 4 7 8 4 5 0 3 6 1 0 6 3 2 0 6 1 5 5 4 7 6 5 6 9 3 7 4 5 2 5 4 7 4 4 3 0 7

Output:
1
0
 */
public class Is_Sudoku_Valid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[][] arr;
        while(t-->0)
        {
            //n=Integer.parseInt(br.readLine());
            arr= new int[9][9];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <9 ; i++) {
                for (int j = 0; j <9 ; j++){
                    arr[i][j]=Integer.parseInt(tk.nextToken());
                }

            }
            int ans=1;
            for (int i = 0; i <9 ; i++) {
                  for (int j = 0; j <9 ; j++){
                          if(!inBox(arr,i,j) || !inRow(arr,i,j)||!inCol(arr,i,j))
                          {
                              ans=0;
                              break;
                          }
                  }
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
    private static boolean inBox(int[][] arr,int r,int c){
        int x=arr[r][c],count=0;
        if(x==0)
            return true;
        for (int i = 3*(r/3); i <3*(r/3 +1) ; i++) {
              for (int j = 3*(c/3); j < 3*(c/3 +1); j++){
                           if(x==arr[i][j])
                               count++;
                           if(count>1)
                               return false;
              }
        }
        return true;
    }

    private static boolean inRow(int[][] arr,int r,int c){
        int x=arr[r][c],count=0;
        if(x==0)
            return true;
        for (int i =0; i <9 ; i++) {
            if(x==arr[r][i])
                count++;
            if(count>1)
                return false;

        }
        return true;
    }

    private static boolean inCol(int[][] arr,int r,int c){
        int x=arr[r][c],count=0;
        if(x==0)
            return true;
        for (int i = 0; i <9 ; i++) {
            if(x==arr[i][c])
                count++;
            if(count>1)
                return false;
        }
        return true;
    }
}
