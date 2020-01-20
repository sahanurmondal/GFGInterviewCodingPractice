package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given an integer x , Your task is to find the  square root of it. If x is not a perfect square, then return
floor(√x).

Input Format:
First line of input contains number of testcases T. For each testcase, the only line contains the number x.

Output Format:
For each testcase, print square root of given integer.

User Task:
The task is to complete the function floorSqrt() which should return the square root of given number x.

Constraints:
1 ≤ T ≤ 1000
1 ≤ N ≤ 1000000

Example:
Input:
2
5
4

Output:
2
2

Explanation:
Testcase 1: Since, 5 is not perfect square, so floor of square_root of 5 is 2.
Testcase 2: Since, 4 is a perfect square, so its square root is 2.
 */
public class Square_root {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());

            double a=0.0;
            double b=(double)n;
            int ans =0;
            while(true)
            {
                double mid=a+(b-a)/2;

                if(mid*mid==(double)n)
                    ans=(int) mid;
                if((int)a==(int)b)
                break;
                if(mid*mid>n)
                    b=mid;
                else
                    a=mid;
            }
            ans=(int)a;
            sb.append(ans).append(" ").append(actualRoot(n)).append("\n");
        }
        System.out.print(sb);
    }
    static double actualRoot(int n){
        double a=0.0;
        double b=(double)n;
        double ans =0.0;
        double mid=0.0;
        while(true)
        {
            mid=a+(b-a)/2;

            if(Math.abs(mid*mid - (double)n)<0.000001)
                break;
            if(mid*mid>n)
                b=mid;
            else
                a=mid;
        }
       return Double.parseDouble(String.format("%.3f",mid));
    }
}
