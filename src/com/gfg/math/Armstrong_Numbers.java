package com.gfg.math;
/*
For a given 3 digit number, find whether it is armstrong number or not. An Armstrong number of
three digits is an integer such that the sum of the cubes of its digits is equal to the number
itself. For example, 371 is an Armstrong number since 33 + 73 + 13 = 371

Input:
First line contains an integer, the number of test cases 'T'. T testcases follow. Each test case contains
a positive integer N.

Output:
For each testcase, in a new line, print "Yes" if it is a armstrong number else print "No".

Constraints:
1 <= T <= 31
100 <= N < 1000

Example:
Input:
1
371
Output:
Yes
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Armstrong_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int n=0,r=0,armStrong=0,temp=0;
        StringBuilder sb = new StringBuilder();
        while(t-->0)
        {
            armStrong=0;
            n=Integer.parseInt(br.readLine());
            temp=n;
            while(n>0){
              r=n%10;
              n/=10;
              armStrong+=r*r*r;
          }
          if(armStrong==temp)
              sb.append("YES").append("\n");
          else
              sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}
