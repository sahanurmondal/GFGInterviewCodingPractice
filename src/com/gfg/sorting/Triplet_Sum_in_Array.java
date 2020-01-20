package com.gfg.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Given an array A[] of N numbers and another number x, determine whether or not there exist three elements
in A[] whose sum is exactly x.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains n and x.
Next line contains array elements.

Output:
Print 1 if there exist three elements in A whose sum is exactly x, else 0.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 103
1 ≤ A[i] ≤ 105

Example:
Input:
2
6 13
1 4 45 6 10 8
5 10
1 2 4 3 6

Output:
1
1

Explanation:
Testcase 1: There is one triplet with sum 13 in the array. Triplet elements are 1, 4, 8, whose sum is 13.
 */
public class Triplet_Sum_in_Array {
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
            tk = new StringTokenizer(br.readLine());
            n=Integer.parseInt(tk.nextToken());
            m=Integer.parseInt(tk.nextToken());
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }
            Arrays.sort(arr);
            boolean flag=false;
            for (int i = 0; i <n-2 ; i++) {
                int j=i+1,k=n-1;
                while (j<k){
                    if (arr[i]+arr[j]+arr[k]==m){
                        flag=true;
                        break;
                    }else if (arr[i]+arr[j]+arr[k]>m)
                        k--;
                    else
                        j++;

                }
            }
            if (flag)
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }
        System.out.print(sb);
    }
}
