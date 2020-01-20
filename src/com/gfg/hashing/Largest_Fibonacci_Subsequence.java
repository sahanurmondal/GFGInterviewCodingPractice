package com.gfg.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
Given an array with positive number the task to find the largest subsequence from array that contain elements
which are Fibonacci numbers.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each
test case contains an integer N denoting the size of the array. Then in the next line are N space separated
values of the array.

Output:
For each test case in a new line print the space separated elements of the  longest fibonacci subsequence.

Constraints:
1<=T<=100
1<=N<=100
1<=A[]<=1000

Example:
Input:
2
7
1 4 3 9 10 13 7
9
0 2 8 5 2 1 4 13 23

Output:
1 3 13
0 2 8 5 2 1 13
 */
public class Largest_Fibonacci_Subsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0; long x=0;
        // long x=0,y=0;
        StringTokenizer tk;
        long[] arr=new long[101];
        arr[0]=0;arr[1]=1;
        HashMap<Long,Integer> hm=new HashMap<Long,Integer>();
        int j=2;
        hm.put(0l,0);
        while(j<101){
            arr[j]=arr[j-1]+arr[j-2];
            hm.put(arr[j],j);
            j++;
        }
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
           // arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                x=Long.parseLong(tk.nextToken());
                if(hm.containsKey(x))
                    sb.append(x).append(" ");
            }

           sb.append("\n");
        }
        System.out.print(sb);
    }
}
