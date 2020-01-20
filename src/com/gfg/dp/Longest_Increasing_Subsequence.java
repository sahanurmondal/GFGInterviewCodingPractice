package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Given a sequence, find the length of the longest increasing subsequence from a given sequence .
The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's
elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible.
This subsequence is not necessarily contiguous, or unique.

Note: Duplicate numbers are not counted as increasing subsequence.

For example:
 length of LIS for
{ 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.



Input:

The first line contains an integer T, depicting total number of test cases.
Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.


Output:

Print the Max length of the subsequence in a separate line.


Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 1000
0 ≤ A[i] ≤ 300

Example:

Input
1
16
0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
Output
6
 */
public class Longest_Increasing_Subsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            int[] dp=new int[n];
            dp[0]=1;
            boolean flag=false;
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
                flag=false;
                for (int j = 0; j <i ; j++){
                    if(arr[j]<arr[i]) {
                        flag=true;
                        if(dp[i]<dp[j]+1)
                            dp[i]=dp[j]+1;
                    }
                }
                if(!flag)
                    dp[i]=1;

            }
            sb.append(Arrays.stream(dp).max().orElse(0)).append("\n");
        }
        System.out.print(sb);
    }
}
