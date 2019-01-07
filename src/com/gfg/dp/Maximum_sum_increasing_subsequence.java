package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Given an array A of N positive integers. Find the sum of maximum sum increasing subsequence of the given array.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case
is N(the size of array). The second line of each test case contains array elements.

Output:
For each test case print the required answer in new line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 ≤ Ai ≤ 106

Example:
Input:
2
7
1 101 2 3 100 4 5
4
10 5 4 3

Output:
106
10

Explanation:
Testcase 1: All the increasing subsequences are : (1,101); (1,2,3,100); (1,2,3,4,5). Out of these (1, 2, 3, 100)
 has maximum sum,i.e., 106.
 */
public class Maximum_sum_increasing_subsequence {
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
            //dp[0]=1;
            boolean flag=false;
            //int max=0;
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
                flag=false;
                for (int j = 0; j <i ; j++){
                    if(arr[j]<arr[i]) {
                        flag=true;
                        dp[i]=Math.max(dp[j]+arr[i],dp[i]);
                    }
                }
                if(!flag)
                    dp[i]=arr[i];

            }

            sb.append(Arrays.stream(dp).max().orElse(0)).append("\n");
        }
        System.out.print(sb);
    }
}
