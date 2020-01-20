package com.gfg.dp;
/*
Given an integer N denoting the Length of a line segment. you need to cut the line segment in
such a way that the cut length of a line segment each time is integer either x , y or z. and after
performing all cutting operation the total number of cutted segments must be maximum.


Input
First line of input contains of an integer 'T' denoting number of test cases. First line of each testcase
contains N . Second line of each testcase contains 3 space separated integers x , y and z.

Output
For each test case print in a new line an integer corresponding to the answer .


Constraints
1<=t<=70
1<=N,x,y,z<=4000


Example

Input

2
4
2 1 1
5
5 3 2


Output
4
2

In first test case, total length is 4, and cut lengths are 2, 1 and 1.  We can make maximum 4 segments
each of length 1. In secon test case, we can make two segments of lengths 3 and 2.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cutted_Segments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        int x=0,y=0,z=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine().trim());
            tk = new StringTokenizer(br.readLine());
            x=Integer.parseInt(tk.nextToken());
            y=Integer.parseInt(tk.nextToken());
            z=Integer.parseInt(tk.nextToken());
            int dp[]=new int[n+1];
            Arrays.fill(dp,1,n+1,-1);
            int start=Math.min(x,Math.min(y,z));
            for(int i=start;i<=n;++i)
            {
                if(i>=x && dp[i-x]!=-1)
                    dp[i]=Math.max(dp[i],dp[i-x]+1);
                if(i>=y && dp[i-y]!=-1)
                    dp[i]=Math.max(dp[i],dp[i-y]+1);
                if(i>=z && dp[i-z]!=-1)
                    dp[i]=Math.max(dp[i],dp[i-z]+1);
            }

            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}
