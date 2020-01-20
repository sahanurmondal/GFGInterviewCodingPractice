package com.gfg.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given a positive integer N, write a program to find the last digit of the N'th term from the Fibonnaci
series and print it.

Input
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
The first line of each test case contains a positive integer N.


Output
Print out the last digit of N'th Fibonacci number.


Constraints
1 <= T <= 100
0 <   N  <= 1000

Examples

Input
4
1
5
14
300

Output
1
5
7
0
 */
public class The_Nth_Fibonnaci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int  n = 0;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            sb.append(findLastDigit(n)).append("\n");
        }
        System.out.print(sb);
    }

   static void fib(int f[])
    {
        // 0th and 1st number of
        // the series are 0 and 1
        f[0] = 0;
        f[1] = 1;

        // Add the previous 2 numbers
        // in the series and store
        // last digit of result
        for (int i = 2; i <= 59; i++)
            f[i] = (f[i - 1] + f[i - 2]) % 10;
    }

    // Returns last digit of n'th Fibonacci Number
   static int findLastDigit(long n)
    {
        // In Java, values are 0 by default
        int f[] = new int[60];

        // Precomputing units digit of
        // first 60 Fibonacci numbers
        fib(f);

        int index = (int)(n % 60L);

        return f[index];
    }
}
