package com.gfg.math;

/*
For a given number N check if it is prime or not. A prime number is a number which is only divisible
by 1 and itself.

Input:
First line contains an integer, the number of test cases 'T'. T testcases follow. Each test case should
 contain a positive integer N.

Output:
For each testcase, in a new line, print "Yes" if it is a prime number else print "No".

Constraints:
1 <= T <= 30
1 <= N <= 100

Example:
Input:
1
5
Output:
Yes
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prime_Numbe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long n=0;
       // long x=0,y=0;
        //StringTokenizer tk;
        String ans="";
        while(t-->0)
        {
            ans="Yes";
            n=Long.parseLong(br.readLine());
            if (n%2==0)
                ans="No";
            else{
                for (int i = 3; i <= Math.sqrt(n); i+= 2) {
                    if(n%i ==0){
                        ans="No";
                        break;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
