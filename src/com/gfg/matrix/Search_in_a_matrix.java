package com.gfg.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given an n x m matrix, where every row and column is sorted in increasing order, and a number x . The task is to
find whether element x is present in the matrix or not.

Expected Time Complexity : O(m + n)

Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consists of three lines.
First line of each test case consist of two space separated integers N and M, denoting the number of element in a row and column respectively.
Second line of each test case consists of N*M space separated integers denoting the elements in the matrix in row major order.
Third line of each test case contains a single integer x, the element to be searched.
Output:

Corresponding to each test case, print in a new line, 1 if the element x is present in the matrix, otherwise simply print 0.

Constraints:
1<=T<=200
1<=N,M<=30

Example:

Input:
2
3 3
3 30 38 44 52 54 57 60 69
62
1 6
18 21 27 38 55 67
55

Output:
0
1
 */
public class Search_in_a_matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,m=0,k=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[][] arr;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            m=Integer.parseInt(tk.nextToken());
            n=Integer.parseInt(tk.nextToken());
            arr= new int[m][n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++){
                    arr[i][j]=Integer.parseInt(tk.nextToken());
                }

            }
            k=Integer.parseInt(br.readLine());
            int ans=0,i=0;
            while(i<n){
                if( k>arr[i][n-1] )
                    i++;
                else {
                    for (int j = 0; j <=n-1; j++){
                        if(k==arr[i][j]){
                            ans=1;
                            break;
                        }

                    }
                    break;
                }

            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
