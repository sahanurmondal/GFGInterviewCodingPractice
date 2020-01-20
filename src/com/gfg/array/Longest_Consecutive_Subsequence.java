package com.gfg.array;
/*
Given an array A of integers. The task is to complete the function which returns an integer denoting the
length of the longest sub-sequence such that elements in the sub-sequence are consecutive integers, the
consecutive numbers can be in any order.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each
test case contains an integer N. Then in the next line are N space separated values of the array A.

Output:
For each test case in a new line output will be the length of the longest consecutive increasing sub-sequence
present in the array A[ ].

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= Ai <= 108

Example(To be used only for expected output):
Input:
2
7
1 9 3 10 4 20 2
11
36 41 56 35 44 33 34 92 43 32 42
Output:
4
5

Explanation:
Testcase 1: Logest consecutive subsequence is 1, 2, 3, 4 of length 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Longest_Consecutive_Subsequence {
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
            Arrays.sort(arr);
            int c=0,max=1;
            for (int i = 1; i <n ; i++) {
                if(arr[i]==arr[i-1]+1){
                   c++;
                }else if(arr[i]==arr[i-1]){
                    continue;
                }else{
                    if( c>=max)
                        max=c+1;
                    c=0;
                }
                if(i==n-1){
                    if(c>=max)
                        max=c+1;
                }
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}
