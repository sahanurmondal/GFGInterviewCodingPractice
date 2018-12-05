package com.gfg.array;
/*
Given an array A of size N, construct a Product Array P (of same size) such that P is equal to the
 product of all the elements of A except A[i].

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow.
 Each testcase contains two lines of input. The first line is N. The second line contains N elements
 separated by spaces.

Output:
For each testcase, print the Product array P.

Constraints:
1 <= T <= 10
1 <= N <= 1000
1 <= Ai <= 20

Example:
Input
2
5
10 3 5 6 2
2
12 20
Output
180 600 360 300 900
20 12

Explanation:
Testcase1: For the product array P, at i=0 we have 3*5*6*2. At i=1 10*5*6*2. At i=2 we have 10*3*6*2.
At i=3 we have 10*3*5*2. At i=4 we have 10*3*5*6
So P is 180 600 360 300 900
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Product_array_puzzle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
       // long x=0,y=0;
        StringTokenizer tk;
        int[] arr,p;
        long prod;
        while(t-->0)
        {
            //int l=0,r=0;
            prod=1;
            n=Integer.parseInt(br.readLine());
            arr= new int[n];
            //p=new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
                prod*=arr[i];
            }

            for (int i = 0; i <n ; i++) {
                sb.append(prod/arr[i]).append(" ");
            }

            /*for (int i = 0; i < n; i++) {
                l=i-1; r=i+1;
                prod=1;
                while(l>=0 || r<n){
                    if(l>=0){
                       prod*=arr[l];
                       l--;
                    }
                    if(r<n){
                        prod*=arr[r];
                        r++;
                    }
                }
               // p[i]=prod;
                sb.append(prod).append(" ");
            }*/

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
