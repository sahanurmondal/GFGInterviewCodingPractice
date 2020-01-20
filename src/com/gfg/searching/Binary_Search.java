package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a sorted array A[]  ( 0 based index ) and a key "k"  you need to complete the function bin_search to
determine the position of the key if the key is present in the array. If the key is not  present then you have
to return -1. The arguments left and right denotes the left most index  and right most index of the array A[] .
There are multiple test cases. For each test case, this function will be called individually.

Example

Input:
The first line contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each
test case consists of 3 lines. First line of each test case contains an integer N denoting the size of the
array.Second line of each test case consists of 'N' space separated integers denoting the elements of the
array A[]. The third line contains a key 'k' .

Output:
Prints the position of the key if its present in the array else print -1 if the key is not present in the array.

Constraints:
1<=T<=600
1<=N<=200

Example:
Input:
2
5
1 2 3 4 5
4
5
11 22 33 44 55
445

Output:
3
-1
 */
public class Binary_Search {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,k=0;
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
            k=Integer.parseInt(br.readLine());
            int l=0,r=n-1;
            int mid=0;
            int ans=-1;
            while (l<=r ){
                mid=(l+r)/2;
                if (k==arr[mid]){
                    ans=mid;
                    break;
                }else if(k>arr[mid]){
                    l=mid+1;
                }else
                    r=mid-1;
             }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
