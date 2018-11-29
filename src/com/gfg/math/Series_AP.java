package com.gfg.math;
/*
Given the first 2 terms A and B of an Arithmetic Series, tell the Nth term of the series.

Input:
First line contains an integer, the number of test cases 'T'. T testcases follow. Each test
case in its first line should contain two positive integer A and B(First 2 terms of AP).
In the second line of every test case it contains of an integer N.

Output:
For each testcase, in a new line, print the Nth term of the Arithmetic Progression.

Constraints:
1 <= T <= 30
-100 <= A <= 100
-100 <= B <= 100
1 <= N <= 100

Example:
Input:
2
2 3
4
1 2
10
Output:
5
10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Series_AP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int x=0,y=0,n=0;
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            x= Integer.parseInt(tk.nextToken());
            y= Integer.parseInt(tk.nextToken());
            n=Integer.parseInt(br.readLine());

            sb.append(x+(y-x)*(n-1)).append("\n");

        }
        System.out.println(sb);
    }
}
