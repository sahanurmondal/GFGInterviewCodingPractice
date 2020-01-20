package com.gfg.dp;
/*
Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test
cases follows. The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 1000
-100 ≤ A[i] <= 100

Example:
Input
2
3
1 2 3
4
-1 -2 -3 -4
Output
6
-1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kadane_s_Algorithm {
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
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }

            sb.append(maxSubArray(arr,n)).append("\n");
        }
        System.out.print(sb);
    }

    static int maxSubArray(int arr[], int size)
    {
        int i, maxSum, maxGlobalSum;

        maxSum = maxGlobalSum = arr[0];

        for (i = 1; i < size; ++i) {
            maxSum = arr[i] > arr[i] + maxSum ? arr[i] : arr[i] + maxSum;
            maxGlobalSum = maxSum > maxGlobalSum ? maxSum : maxGlobalSum;
        }

        return maxGlobalSum;
    }
}
