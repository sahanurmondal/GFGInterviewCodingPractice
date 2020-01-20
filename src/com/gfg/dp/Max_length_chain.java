package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
You are given N pairs of numbers. In every pair, the first number is always smaller than the second number.
A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Your task
is to complete the function maxChainLen which returns an integer denoting the longest chain which can be formed
from a given set of pairs.

Input:
The first line of input contains an integer T denoting the no of test cases then T test cases follow .Then T test
cases follow . The first line of input contains an integer N denoting the no of pairs . In the next line are 2*N
space separated values denoting N pairs.

Output:
For each test case output will be the length of the longest chain formed.

Constraints:
1<=T<=100
1<=N<=100

Example(To be used only for expected output):
Input
2
5
5  24 39 60 15 28 27 40 50 90
2
5 10 1 11

Output
3
1
â€‹
Explanation
(i) the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },the longest chain that can be formed
is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}
(ii) The max length chain possible is only of length one.


 */
public class Max_length_chain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[][] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            arr= new int[n][2];
            tk = new StringTokenizer(br.readLine());
            int[] dp=new int[n];
            dp[0]=1;
            boolean flag=false;
            for (int i = 0; i <n ; i++) {
                arr[i][0]=Integer.parseInt(tk.nextToken());
                arr[i][1]=Integer.parseInt(tk.nextToken());
            }
            sortbyColumn(arr,0);
            for (int i = 0; i < n; i++) {
                flag=false;
                for (int j = 0; j <i ; j++){
                    if(arr[j][1]<arr[i][0] /*&& arr[j][1]<arr[i][1]*/) {
                        flag=true;
                        if(dp[i]<dp[j]+1)
                            dp[i]=dp[j]+1;
                    }/*else if(arr[j][0]>arr[i][1]){
                        flag=true;
                            dp[i]=Math.max(dp[i]);
                    }*/
                }
                if(!flag)
                    dp[i]=1;
            }
            sb.append(Arrays.stream(dp).max().orElse(0)).append("\n");
        }
        System.out.print(sb);
    }
    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }
}
