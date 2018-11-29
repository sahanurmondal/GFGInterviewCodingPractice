package com.gfg.math;

/*
Calculate the factorial for a given number N.

Input:
The first line contains an integer 'T' denoting the total number of test cases. T testcases follow.
In each test cases, it contains an integer 'N'.

Output:
For each testcase, in a new line, output the answer to the problem.

Constraints:
1 <= T <= 19
0 <= N <= 18

Example:
Input:
1
1
Output:
1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int n=0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            n= Integer.parseInt(tk.nextToken());
            sb.append(factorial(n)).append("\n");
        }

        System.out.print(sb);
    }

    private static long factorial(int n)
    {
        // single line to find factorial
        long mod = (long) Math.pow(10, 9) + 7;
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1)%mod;
    }
}
