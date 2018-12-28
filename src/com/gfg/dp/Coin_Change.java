package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of
S = { S1, S2, .. , Sm} valued coins. The order of coins doesn’t matter. For example, for N = 4 and S = {1,2,3},
there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6},
there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

Input:

The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first
line contains an integer 'M' denoting the size of array. The second line contains M space-separated integers A1,
A2, ..., AN denoting the elements of the array. The third line contains an integer 'N' denoting the cents.

Output:

Print number of possible ways to make change for N cents.

Constraints:

1 ≤ T ≤ 50
1 ≤ N ≤ 300
1 1 ≤ A[i] ≤ 300

Example:

Input:

2
3
1 2 3
4
4
2 5 3 6
10

Output:

4
5
 */
public class Coin_Change {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,m=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            m=Integer.parseInt(br.readLine());
            arr= new int[m];

            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <m ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }
            n=Integer.parseInt(br.readLine());
            int[] dp=new int[n+1];
            dp[0]=1;
            for(int coin=0;coin<m;coin++)
                for(int i=1;i<=n;i++){
                    if(i>=arr[coin])
                        dp[i]+=dp[i-arr[coin]];
                }
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}
