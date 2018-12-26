package com.gfg.dp;
/*
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either
1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does matter).

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases,
an integer N will be given.


Output:
Print number of possible ways to reach Nth stair. Answer your output % 10^9+7.


Constraints:
1<=T<=105
1<=N<=105

Example:
Input:
3
4
10
24
Output:
5
89
75025
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Count_ways_to_reach_the_n_th_stair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        long mod=1000000007L;
        long[] arr=new long[100001];
        arr[0]=arr[1]=1;
        int i=2;
        while(i<100001){
            arr[i]=(arr[i-1]+arr[i-2])%mod;
            i++;
        }
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());

            sb.append(arr[n]).append(" ");

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
