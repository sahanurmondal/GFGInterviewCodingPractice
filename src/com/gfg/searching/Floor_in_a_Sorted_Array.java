package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a sorted array arr[] without duplicates, and a value x. Find the floor of x in given array.
Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number
of elements in the array and element whose floor is to be searched. Last line of input contains array elements.

Output:
Output the index of floor of x if exists, else print -1.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
1 ≤ arr[i] ≤ 1018
0 ≤ X ≤ arr[n-1]

Example:
Input:
3
7 0
1 2 8 10 11 12 19
7 5
1 2 8 10 11 12 19
7 10
1 2 8 10 11 12 19

Output:
-1
1
3

Explanation:
Testcase 1: No element less than 0 is found. So output is "-1".
Testcase 2: Number less than 5 is 2, whose index is 1(0-based indexing).
 */
public class Floor_in_a_Sorted_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,k;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            tk=new StringTokenizer(br.readLine());
            n=Integer.parseInt(tk.nextToken());
            k=Integer.parseInt(tk.nextToken());
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }

            int l=0,r=n-1;
            int mid=0;
            int ans=-1;
            if(k>=arr[0] && k<=arr[n-1]) {
                while (l <= r) {
                    ans = mid;
                    mid = (l + r) / 2;
                    if (k == arr[mid]) {
                        ans = mid;
                        break;
                    } else if (k > arr[mid]) {
                        l = mid + 1;
                    } else
                        r = mid - 1;

                }
            }else if(k>arr[r])
                ans=r;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
