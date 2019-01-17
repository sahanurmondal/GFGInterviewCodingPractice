package com.gfg.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
Given an array A of integers. Find three numbers such that sum of two elements equals the third element and
 return the triplet in a container result, if no such triplet is found return the container as empty.

Input:
First line of input contains number of testcases. For each testcases there will two lines. First line contains
size of array and next line contains array elements.

Output:
For each test case output the triplets, if any triplet found from the array, if no such triplet is found,
output -1.

Your Task: Your task is to complete the function to find triplet and return container containing result.

Constraints:
1 <= T <= 100
1 <= N <= 103
0 <= Ai <= 105

Example:
Input:
3
5
1 2 3 4 5
3
3 3 3
6
8 10 16 6 15 25

Output:
1
-1
1

Explanation:
Testcase 1:
Triplet Formed: {2, 1, 3}
Hence 1
Test Case 2:
Triplet Formed: {}
Hence -1
Test Case 3:
Triplet Formed: {10, 15, 25}
Hence 1
 */
public class Triplet_Family {
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
            outer:for (int i = 0; i <n ; i++) {
                int j=i+1,r=n-1;
                while(j<r){
                    if (arr[i]==arr[j]+arr[r]){
                        ans=1;
                        break outer;
                    }else if(arr[i]<arr[j]+arr[r])
                        j++;
                    else
                        r--;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
