package com.gfg.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements
equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
Each test case consists of two lines. First line of each test case contains an Integer N denoting size of
array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1<=T<=100
3<=N<=105
1<=A[i]<=106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1
 */
public class Count_the_triplets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        Integer[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            arr= new Integer[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }
            Arrays.sort(arr, Collections.reverseOrder());
            int ans=-1;
            for (int i = 0; i <n-2 ; i++) {
                int j=i+1,r=n-1;
                while(j<r){
                    if (arr[i]==arr[j]+arr[r]){
                        ans+=1;
                        j++;
                        r--;
                        //break ;
                    }else if(arr[i]<arr[j]+arr[r])
                        j++;
                    else
                        r--;
                }
            }
            if(ans==-1)
                sb.append(ans).append("\n");
            else
                sb.append(ans+1).append("\n");
        }
        System.out.print(sb);
    }
}
