package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains
 valid digits from 0 to 9 and If there are leading 0’s, extra trailing 0’s and two or more consecutive 0’s then
 it is an invalid string.

Example :
Given encoded message "123",  it could be decoded as "ABC" (1 2 3) or "LC" (12 3) or "AW"(1 23).
So total ways are 3.

Input:
First line contains the test cases T.  1<=T<=1000
Each test case have two lines
First is length of string N.  1<=N<=40
Second line is string S of digits from '0' to '9' of N length.

Example:
Input:
2
3
123
4
2563
Output:
3
2
 */
public class Total_Decoding_Messages {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            int n;
            String  s;
            while(t-->0)
            {
                n=Integer.parseInt(br.readLine());
                s=br.readLine();
                int[] dp=new int[n];
                dp[0]=1;
                int x;
                boolean check=false;
                if(s.charAt(0)=='0')
                    check=true;
                else{
                    for(int i=1;i<s.length();i++)
                    {
                        if(s.charAt(i)-'0'>0) dp[i] = dp[i-1];
                        x = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
                        if(x>9 && x<27)
                            if(i==1) dp[i]+=1;
                            else dp[i] +=dp[i-2];
                    }
                }
                if(check)
                    sb.append(0).append("\n");
                else
                    sb.append(dp[n-1]).append("\n");
            }
            System.out.print(sb);
        }

}
