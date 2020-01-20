package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Input:
First line consists of T test cases. First line of every test case consists of N, denoting the size of array.
Second line of every test case consists of price of ith length piece.

Output:
Single line output consists of maximum price obtained.

Constraints:
1<=T<=100
1<=N<=100
1<=Ai<=100

Example:
Input:
1
8
1 5 8 9 10 17 17 20
Output:
22
 */
public class Rod_Cutting {
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
            for (int i = 1; i <=n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }
            int[] b=new int[n+1];
            b[0]=0;
            for(int i=1;i<n+1;i++){
                int max=Integer.MIN_VALUE;
                for(int j=i;j>-1;j--){
                    if(arr[j]+b[i-j]>max)
                        max=arr[j]+b[i-j];
                    //System.out.println(max);
                }
                b[i]=max;
            }
            sb.append(b[n]).append("\n");
        }
        System.out.print(sb);
    }

}
