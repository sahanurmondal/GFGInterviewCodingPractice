package com.gfg.matrix;
/*
Given a MxN matrix, count the number of squares in the matrix.
Input:

The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
Each test case contains two space seperated integers M and N, denoting the size of the Matrix.
Output:

For each test output a single integer denoting the total number of squares.
Constraints:

1<=T<=102
1<=M,N<=10^4

Example:

Input:

2
2 2
4 3

Output:

5
20
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Squares_in_a_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,m=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            n=Integer.parseInt(tk.nextToken());
            m=Integer.parseInt(tk.nextToken());
            long ans=0;
            while (m>1 && n>1){
                ans+=m*n;
                m--;n--;
            }
            ans+=m*n;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
