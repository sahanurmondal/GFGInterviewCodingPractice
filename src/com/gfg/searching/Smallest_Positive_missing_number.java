package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
You are given an array arr[] of N integers including 0. The task is to find the smallest positive number
missing from the array.
Note: Expected solution in O(n) time using constant extra space.

Input:
First line consists of T test cases. First line of every test case consists of N, denoting the number of
elements in array. Second line of every test case consists of elements in array.

Output:
Single line output, print the smallest positive number missing.

Constraints:
1 <= T <= 100
1 <= N <= 106
-106 <= arr[i] <= 106

Example:
Input:
2
5
1 2 3 4 5
5
0 -10 1 3 -20
Output:
6
2

Explanation:
Testcase 1: Smallest positive missing number is 6.
Testcase 2: Smallest positive missing number is 2.
 */
public class Smallest_Positive_missing_number {
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
            arr= new int[n+1];
            tk = new StringTokenizer(br.readLine());
            int x=0,temp=0;
            for (int i = 1; i <=n ; i++) {
                x=Integer.parseInt(tk.nextToken());
                if(x>0 && x<n)
                {
                    arr[x]=x;
                }
            }
            int ans=0;
            for (int i = 1; i <= n; i++) {
                if(arr[i]==0){
                    ans=i;
                    break;
                }
            }
            if(ans==0)
                ans=n+1;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static int solution(int[] A) {//Our original array

        int m = Arrays.stream(A).max().getAsInt(); //Storing maximum value
        if (m < 1) // In case all values in our array are negative
        {
            return 1;
        }
        if (A.length == 1) {

            //If it contains only one element
            if (A[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }
        int i = 0;
        int[] l = new int[m];
        for (i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                if (l[A[i] - 1] != 1) //Changing the value status at the index of our list
                {
                    l[A[i] - 1] = 1;
                }
            }
        }
        for (i = 0; i < l.length; i++) //Encountering first 0, i.e, the element with least value
        {
            if (l[i] == 0) {
                return i + 1;
            }
        }
        //In case all values are filled between 1 and m
        return i+1;
    }
}
