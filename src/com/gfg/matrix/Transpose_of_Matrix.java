package com.gfg.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Write a program to find transpose of a square matrix of size N. Transpose of a matrix is obtained by changing
rows to columns and columns to rows.

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow.
Each test case contains an integer N, denoting the size of the square matrix. Then in the next line are N*N
space separated values of the matrix.

Output:
For each test case output will be the space separated values of the transpose of the matrix

Constraints:
1 <= T <= 1000
1 <= N <= 20

Example:
Input:
2
4
1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4
2
1 2 -9 -2

Output:
1 2 3 4 1 2 3 4 1 2 3 4 1 2 3 4
1 -9 2 -2

Explanation:
Testcase 1: The matrix after rotation will be: 1 2 3 4 1 2 3 4 1 2 3 4 1 2 3 4.
 */
public class Transpose_of_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,x=0;
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
                  for (int j = 0; j <n ; j++){
                      if (j>i){
                          x=arr[i][j];
                          arr[i][j]=arr[j][i];
                          arr[j][i]=x;
                      }
                      sb.append(arr[i][j]).append(" ");
                  }
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
