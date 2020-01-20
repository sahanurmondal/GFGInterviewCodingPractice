package com.gfg.math;

/*
Write a program to reverse digits of a number N.

Input:
The first line of input contains an integer T, denoting the number of test cases.
T testcases follow. Each test case contains an integer N.

Output:
For each test case, print the reverse digits of number N .

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 109

Example:
Input:
2
200
122
Output:
2
221
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse_digits {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            int n=0,r=0,rev=0,base=10;
            while(t-->0)
            {
                rev=0;
                n=Integer.parseInt(br.readLine());
                while(n>0){
                    r=n%10;
                    n/=10;
                    rev=rev*base+r;
                }
                sb.append(rev).append("\n");
            }
            System.out.print(sb);
        }
}
