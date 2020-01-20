package com.gfg.math;
/*
Given two numbers A and B, find the GCD of those 2 numbers.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
Each test case contains two space separated integers A and B.

Output:
For each testcase, in a new line, print the GCD of the two numbers.

Constraints:
1 <= T <= 100
1 <= A, B <= 1000

Example:
Input:
98 56
48 18
Output:
14
6
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD_of_two_numbers {

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
            sb.append(GCD(a,b)).append("\n");
        }
        System.out.print(sb);
    }

    static long GCD(long a, long b){
        a = Math.abs(a); b = Math.abs(b);
        return (b==0) ? a : GCD(b, a%b);
    }
}
