package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given three strings A, B and C your task is to complete the function isInterleave which returns true if C
is an interleaving of A and B else returns false. C is said to be interleaving A and B, if it contains all
characters of A and B and order of all characters in individual strings is preserved.

Input:
The first line of input contains an input T denoting the no of test cases. Then T test cases follow. Each
test case contains three space separated strings A, B, C.

Output:
For each test case output will be 1 if C is interleaving of string A and B else 0.

Constraints:
1<=T<=100
1<=length of A, B, C <=100

Example(To be used only for expected output):
Input:
2
YX  X  XXY
XY X XXY

Output
0
1

Explanation:
1. For first test case XXY is not interleaving of YX and X
2. For the sec test case XXY is interleaving of XY and X.
 */
public class Interleaved_Strings {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  a,b,c;
            StringTokenizer tk;
            while(t-->0)
            {
                tk=new StringTokenizer(br.readLine());
                a=tk.nextToken();
                b=tk.nextToken();
                c=tk.nextToken();
                sb.append(isInterleave(a,b,c)).append("\n");
            }
            System.out.print(sb);
        }
    static int isInterleave(String A, String B, String C)
    {
        int n=A.length();
        int m=B.length();
        int[][] dp=new int[n+1][m+1];
        if(n+m!=C.length())
            return 0;

        dp[n][m]=1;

        for(int i=n-1;i>=0;i--)
            dp[i][m]=(A.charAt(i)==C.charAt(i+m) && dp[i+1][m]==1)?1:0;
        for(int j=m-1;j>=0;j--)
            dp[n][j]=(B.charAt(j)==C.charAt(n+j) && dp[n][j+1]==1)?1:0;

        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                dp[i][j]=(A.charAt(i)==C.charAt(i+j) && dp[i+1][j]==1)
                        ||(B.charAt(j)==C.charAt(i+j) && dp[i][j+1]==1)?1:0;
            }
        }
        return dp[0][0];
    }
}
