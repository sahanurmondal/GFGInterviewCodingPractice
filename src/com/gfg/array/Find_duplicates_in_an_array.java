package com.gfg.array;

/*
Given an array A[], Your task is to complete the function printDuplicates which prints the duplicate
elements of the given array. If no duplicate element is found  print -1.

Note: Auxiliary Space must be O(1) and Time complexity must be O(n).

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
Each test case contains an integer N which denotes number of elements of Array. Second line of each test
case contains N space separated integers denoting elements of Array A[].

Output:
Print the duplicate elements from the array.The order of the output should be as the element found to be repeated.

Constraints:
1<=T<=100
1<=N<=50
0<=A[]<N

Example:
Input:
2
4
0 3 1 2
5
2 3 1 2 3
Output:
-1
2 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Find_duplicates_in_an_array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        //int[] arr;
        int x=0;
        while(t-->0)
        {
            int[] count=new int[50];
            n=Integer.parseInt(br.readLine());
           // arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            boolean flag=false;
            for (int i = 0; i <n ; i++) {
                x=Integer.parseInt(tk.nextToken());
                if(count[x]<=1)
                count[x]++;
                if(count[x]==2) {
                    flag=true;
                    sb.append(x).append(" ");
                }
            }
            if (!flag)
                sb.append(-1);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
