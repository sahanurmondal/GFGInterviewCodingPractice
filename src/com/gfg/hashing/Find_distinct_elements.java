package com.gfg.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a N x N matrix. Write a program to find count of all the distinct elements common to all rows of
the matrix. Print count of such elements.

Input:
First line of input contains a single integer T which denotes the number of test cases. T test cases follows.
First line of each test case contains a single integer N which denotes the dimension of matrix. Second line
of each test case contains N*N space separated integers which denotes elements of the matrix.

Output:
For each test case, print count of all the distinct elements common to all rows of the matrix.

Constraints:
1 <= T <= 100
1 <= N <= 1000

Example:
Input:
2
4
2 1 4 3 1 2 3 2 3 6 2 3 5 2 5 3
5
12 1 14 3 16 14 2 1 3 35 14 1 14 3 11 14 25 3 2 1 1 18 3 21 14

Output:
2
3
 */
public class Find_distinct_elements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,x=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr1;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            //arr= new int[1000];
            arr1=new int[1000];
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j <n ; j++) {
                x = Integer.parseInt(tk.nextToken());
                if(arr1[x % 1000]<1)
                    arr1[x%1000]++;
            }
            for (int i = 1; i <n ; i++) {
                for (int j = 0; j <n ; j++){
                    x = Integer.parseInt(tk.nextToken());
                    if(arr1[x % 1000]==i)
                        arr1[x % 1000]++;
                }
            }
            int c=0;
            for (int i = 0; i <1000 ; i++) {
                if(arr1[i]==n)
                    c++;
            }

            sb.append(c).append("\n");
        }
        System.out.print(sb);
    }
}
