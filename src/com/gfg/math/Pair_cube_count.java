package com.gfg.math;

/*
Given N, count all ‘a’(>=1) and ‘b’(>=0) that satisfy the condition a3 + b3 = N.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
 Each test case contains integer N.

Output:
For each testcase, in a new line, print count of all 'a' and 'b' that satisfy the above equation.

Constraints:
1 <= T <= 100
a>=1, b>=0
1 <= N <= 105

Example:
Input:
2
9
28

Output:
2
2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pair_cube_count {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long n=0;
        //long x=0,y=0;
       // StringTokenizer tk;
        int c=0;
        while(t-->0)
        {
            n=Long.parseLong(br.readLine());
            c=0;
            for (int i = 1; i <= Math.cbrt(n) ; i++) {
                for (int j = 0; j <= i; j++){
                  if ((int)(Math.pow(i,3)+Math.pow(j,3))==n ){
                      if(i==j)
                          c++;
                      else {
                          if(j == 0 )c = c + 1 ;
                          else c = c + 2;
                      }
                  }
                }
            }


            sb.append(c).append("\n");
        }
        System.out.print(sb);
    }
}
