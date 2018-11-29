package com.gfg.math;
/*
Given two integers N and M. The problem is to find the number closest to N and divisible by M.
 If there are more than one such number, then output the one having maximum absolute value.

Input:
The first line consists of an integer T i.e number of test cases. T testcases follow.
The first and only line of each test case contains two space separated integers N and M.

Output:
For each testcase, in a new line, print the closest number to N which is also divisible by M.

Constraints:
1 <= T <= 100
-1000 <= N, M <= 1000

Example:
Input:
2
13 4
-15 6
Output:
12
-18
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Closest_Number {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int x=0,y=0,r=0;
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            x= Integer.parseInt(tk.nextToken());
            y= Integer.parseInt(tk.nextToken());
            r=Math.abs(x) % y;
            if(r==0 || x==0)
                sb.append(x).append("\n");
            else if(Math.abs(y) >Math.abs(x) && Math.abs(y)<= 2*Math.abs(x)) {
                if(x>0)
                    sb.append(Math.abs(y)).append("\n");
                else
                    sb.append( (-1)*Math.abs(y)).append("\n");
            }
            else if(Math.abs(y) >Math.abs(x) && Math.abs(y)> 2*Math.abs(x))
                sb.append(0).append("\n") ;
            else {
                if (r *2< Math.abs(y) ) {
                    if (x < 0)
                        sb.append(x + r).append("\n");
                    else
                        sb.append(x - r).append("\n");
                } else {
                    if (x < 0)
                        sb.append(x - (Math.abs(y)-r)).append("\n");
                    else
                        sb.append(x + (Math.abs(y)-r)).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
