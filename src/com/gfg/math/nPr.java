package com.gfg.math;

/*
Write a program to calculate nPr. nPr represents n permutation r and value of nPr is (n!) / (n-r)!.

Input:
The first line of the input contains T denoting the number of testcases. T testcases follow.
First line of the test case will be the value of n and r respectively.

Output:
For each test case, in a new line, output will be the value of nPr.

Constraints:
1 <= T <= 100
1 <= n,r <= 20
n >= r

Example:
Input:
2
2 1
10 4
Output:
2
5040
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nPr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int n=0;
        long a=0,b=0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            a= Long.parseLong(tk.nextToken());
            b= Long.parseLong(tk.nextToken());
            sb.append(factorial(a,a-b)).append("\n");
        }

        System.out.print(sb);
    }

    private static long factorial(long n)
    {
        // single line to find factorial
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }

    private static long factorial(long n, long r)
    {
        // single line to find factorial
        if(n>=r) {
            long res = 1;

            for (long i = n; i > r; i--) {
                res *= i;

            }
            return res;
        }else
            return  0;
    }

}

