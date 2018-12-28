package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given two sequences, find the length of longest subsequence present in both of them. Both the strings are
of uppercase.

Input:
First line of the input contains no of test cases  T,the T test cases follow.
Each test case consist of 2 space separated integers A and B denoting the size of string str1 and str2
respectively
The next two lines contains the 2 string str1 and str2 .


Output:
For each test case print the length of longest  common subsequence of the two strings .


Constraints:
1<=T<=200
1<=size(str1),size(str2)<=100


Example:
Input:
2
6 6
ABCDGH
AEDFHR
3 2
ABC
AC

Output:
3
2
 */
public class Longest_Common_Subsequence {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s,a,b;
            while(t-->0)
            {
                int[] arr1=new int[256],arr2=new int[256];
                s=br.readLine();
                a=br.readLine();
                b=br.readLine();
                int n=a.length(),m=b.length();
                int[][] l=new int[n+1][m+1];
                for( int i=0;i<=n;i++)
                {
                    for( int j=0;j<=m;j++)
                    {
                        if(i==0||j==0)
                            l[i][j]=0;
                        else if(a.charAt(i-1)==b.charAt(j-1))
                            l[i][j]=l[i-1][j-1]+1;
                        else
                            l[i][j]=Math.max(l[i-1][j],l[i][j-1]);
                    }
                }
                sb.append(l[n][m]).append("\n");
            }
            System.out.print(sb);
        }
}
