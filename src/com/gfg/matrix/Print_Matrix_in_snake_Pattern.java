package com.gfg.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given an n x n matrix .In the given matrix, you have to print the elements of the matrix in the snake pattern.
Input:
First line consists of T test cases. First line of every test case consists of N, denoting number of
elements(N x N) in Matrix. Second line of every test case consists of N x N spaced integers denoting
elements of Matrix elements.

Output:
Single line output, print the matrix in snake pattern.

Constraints:
1<=T<=100
1<=N<=50

Example:
Input:
1
3
45 48 54 21 89 87 70 78 15
Output:
45 48 54 87 89 21 70 78 15
 */
public class Print_Matrix_in_snake_Pattern {
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
            n=Integer.parseInt(br.readLine());
            arr= new int[n][n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <n ; j++){
                    arr[i][j]=Integer.parseInt(tk.nextToken());
                }

            }
            for (int i = 0; i <n ; i++) {
                  for (int j = 0; j <n; j++){
                           if (i%2==0)
                               sb.append(arr[i][j]).append(" ");
                           else
                               sb.append(arr[i][n-1-j]).append(" ");
                  }
            }

            sb.append("").append("\n");
        }
        System.out.print(sb);
    }
}
