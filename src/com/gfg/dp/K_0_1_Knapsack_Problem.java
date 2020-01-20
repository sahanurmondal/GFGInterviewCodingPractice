package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum
total value in the knapsack. Note that we have only one quantity of each item, In other words, given two
integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items
respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset
of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item,
either pick the complete item, or don’t pick it (0-1 property).


Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
Each test case consists of four lines. The first line consists of N the number of items. The second line
consists of W, the maximum capacity of the knapsack. In the next  line are N space separated positive integers
denoting the values of the N items and in the fourth line are N space separated positive integers denoting the
 weights of the corresponding items.


Output:

Print the maximum possible value you can get with the given conditions that you can obtain for each test case
in a new line.


Constraints:

1≤T≤100

1≤N≤100

1≤W≤100

1≤wt[i]≤100

1≤v[i]≤100


Example:

Input:
1
3
4
1 2 3
4 5 1
Output:
3
 */
public class K_0_1_Knapsack_Problem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,W;
        // long x=0,y=0;
        StringTokenizer tk,tk1;
        int[] w,v;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            W=Integer.parseInt(br.readLine());
            v= new int[n+1];
            w= new int[n+1];
            tk = new StringTokenizer(br.readLine());
            tk1 = new StringTokenizer(br.readLine());
            for (int i = 1; i <=n ; i++) {
                v[i]=Integer.parseInt(tk.nextToken());
                w[i]=Integer.parseInt(tk1.nextToken());
            }
            int[][] c=new int[n+1][W+1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= W; j++){
                    if (i==0 || j==0)
                        c[i][j]=0;
                    else if(w[i]>j)
                        c[i][j]=c[i-1][j];
                    else{
                        c[i][j]=Math.max(v[i]+c[i-1][j-w[i]],c[i-1][j]);
                    }
                }
            }
            sb.append(c[n][W]).append("\n");
        }
        System.out.print(sb);
    }
}
