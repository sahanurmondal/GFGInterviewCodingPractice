package com.gfg.dp;
/*
Stickler is a thief and wants to loot money from a society of n houses placed in a line. He is a weird person
and follows a rule while looting the houses and according to the rule he will never loot two consecutive houses.
At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money
but is unable to find the maximum amount he can end up with. He asks for your help to find the maximum money he
can get if he strictly follows the rule. Each house has a[i] amount of money present in it.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains an
integer n which denotes the number of elements in the array a[]. Next line contains space separated n elements
in the array a[].

Output:
Print an integer which denotes the maximum amount he can take home.

Constraints:
1<=T<=200
1<=n<=1000
1<=a[i]<=10000

Example:
Input:
2
6
5 5 10 100 10 5
3
1 2 3

Output:
110
4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stickler_Thief {
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
            int[] dp=new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }

            dp[0]=arr[0];
            if(n>1) {
                dp[1] = Math.max(arr[0], arr[1]);
                for (int i = 2; i < n; i++) {
                    dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
                    dp[i] = Math.max(arr[i],dp[i]);
                }
            }
           // sb.append(dp[n-1]).append("\n");
            sb.append(FindMaxSum(arr,n)).append("\n");
        }
        System.out.print(sb);
    }
    static int FindMaxSum(int arr[], int n)
    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++)
        {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }
}
