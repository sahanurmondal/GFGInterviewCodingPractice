package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits
(operations) required to convert ‘str1′ into ‘str2′.

Insert
Remove
Replace
All of the above operations are of cost=1.
Both the strings are of lowercase.

Input:
The First line of the input contains an integer T denoting the number of test cases. Then T test cases follow.
Each tese case consists of two lines. The first line of each test case consists of two space separated integers
P and Q denoting the length of the strings str1 and str2 respectively. The second line of each test case
coantains two space separated strings str1 and str2 in order.


Output:
Corresponding to each test case, pirnt in a new line, the minimum number of operations required.

Constraints:
1<=T<=50
1<= Length(str1) <= 100
1<= Length(str2) <= 100


Example:
Input:
1
4 5
geek gesek

Output:
1
 */
public class Edit_Distance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String  s,a,b;
        StringTokenizer tk;
        while(t-->0)
        {
            int[] arr1=new int[26],arr2=new int[26];
            s=br.readLine();
            tk=new StringTokenizer(br.readLine());
            a=tk.nextToken();
            b=tk.nextToken();
            int n=a.length(),m=b.length();
            int[][] l=new int[n+1][m+1];
            for( int i=0;i<=n;i++)
            {
                for( int j=0;j<=m;j++)
                {
                    if((i==0 && j!=0))
                        l[i][j]=j;
                    else if(i!=0 && j==0){
                        l[i][j]=i;
                    }else{
                       if(i==0 && j==0)
                             l[i][j]=0;
                       else {
                           if (a.charAt(i-1) == b.charAt(j-1))
                               l[i][j]=l[i-1][j-1];
                           else
                               l[i ][j] = Math.min(Math.min(l[i][j - 1] , l[i - 1][j] ), l[i-1][j-1]) +1;
                       }
                    }
                }
            }
            sb.append(l[n][m]).append("\n");
        }
        System.out.print(sb);
    }
}
