package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element
K. The task is to find the index of the given element K in the array A.

Input:
The first line of the input contains an integer T, denoting the total number of test cases. Then T test cases
follow. Each test case consists of three lines. First line of each test case contains an integer N denoting
the size of the given array. Second line of each test case contains N space separated integers denoting the
elements of the array A. Third line of each test case contains an integer K denoting the element to be
searched in the array.

Output:
Corresponding to each test case, output the index of the element found in the array.  If element is not
present, then output -1.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
0 ≤ Ai ≤ 108
1 ≤ K ≤ 108

Example:
Input:
3
9
5 6 7 8 9 10 1 2 3
10
3
3 1 2
1
4
3 5 1 2
6

Output:
5
1
-1

Explanation:
Testcase 1: 10 is found at index 5
 */
public class Search_in_a_Rotated_Array {
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
            n=Integer.parseInt(br.readLine());
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            int rotation_index=0;
            boolean flag=true;
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
                if(flag){
                    if (i!=0 && arr[i-1]>arr[i]) {
                        rotation_index = i;
                        flag=false;
                    }
                }
            }
            k=Integer.parseInt(br.readLine());
            int ans=search(arr,0,rotation_index-1,k);
            if(ans==-1)
                ans=search(arr,rotation_index,n-1,k);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
    static  int search(int[] arr,int l,int r,int k){
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
        return ans;
    }
}
