package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
You are given a sorted array containing only numbers 0 and 1. Find the transition point efficiently.
Transition point is a point where "0" ends and "1" begins.

Input:

You have to complete the method which takes 2 argument: the array arr[] and size of array N. You should not
 read any input from stdin/console. There are multiple test cases. For each test cases, this method will
  be called individually.

Output:

Your function should return transition point.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 500000
0 ≤ C[i] ≤ 1

Example:

Input
1
5
0 0 0 1 1

Output
3
 */
public class Find_Transition_Point {
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
            int l=0,r=n-1,mid=0,ans=0;
            while(true){
                mid=(l+r)/2;
                if (arr[mid]==0){
                    if(arr[mid+1]==1) {
                        ans=mid+1;
                        break;
                    }else
                        l=mid+1;
                }else{
                    if(arr[mid-1]==0) {
                        ans=mid;
                        break;
                    }else
                        r=mid-1;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

}
