package com.gfg.dp;
/*
Given an array of integers where each element represents the max number of steps that can be made forward
from that element. Write a function to return the minimum number of jumps to reach the end of the array
(starting from the first element). If an element is 0, then cannot move through that element.

Input:
The first line contains an integer T, depicting total number of test cases.
Then following T lines contains a number n denoting the size of the array.
Next line contains the sequence of integers a1, a2, ..., an.

Output:
Each seperate line showing the minimum number of jumps. If answer is not possible print -1.

Constraints:
1 ≤ T ≤ 40
1 ≤ N ≤ 100
0<=a[N]<=100

Example:

Input:

1
11
1 3 5 8 9 2 6 7 6 8 9

Output:

3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minimum_number_of_jumps {
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
            System.out.print(minJumps(arr));
        }
    }

    static int minJumps(int[] arr){
        if(arr.length == 1) return 0;

        if(arr[0] == 0) return -1;

        int cur = 0, max = 0, jp = 0;

        for(int i = 0;i < arr.length -1; i++){
            if(arr[i] == 0 && i != cur) continue;

            max = Math.max(max,i + arr[i]);
            if(i == cur){
                jp++;
                cur = max;
            }
        }

        if(max < arr.length-1) return -1;
        return jp;
    }
}
