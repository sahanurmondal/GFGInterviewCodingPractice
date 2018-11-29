package com.gfg.math;
/*
Given a Binary Number B, Print its decimal equivalent.

Input:
The first line of input contains an integer T denoting the number of test cases.
The description of T test cases follow. Each test case contains a single Binary number B.

Output:
For each testcase, in a new line, print each Decimal number in new line.

Constraints:
1 < T < 100
1 <= Digits in Binary <= 16

Example:
Input:
2
10001000
101100
Output:
136
44
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Binary_number_to_decimal_number {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int i=0,sum=0;
        long a=0,base=1;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        while(t-->0)
        {
            sum=0;
            base=1;
            tk = new StringTokenizer(br.readLine());
            a= Long.parseLong(tk.nextToken());

            while(a>0) {
                sum += (a % 10)*base;
                a /= 10;
                base*=2;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
