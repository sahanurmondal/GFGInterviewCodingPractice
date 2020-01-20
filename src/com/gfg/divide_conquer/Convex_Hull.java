package com.gfg.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Convex Hull of a set of points, in 2D plane, is a convex polygon with minimum area such that each point
lies either on the boundary of polygon or inside it. Now given a set of points the task is to find
 the convex hull of points.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
Each test case contains an integer N denoting the no of points. Then in the next line are N*2 space
separated values denoting the points ie x and y.

Output:
For each test case in a new line print the points x and y of the convex hull separated by a space in
sorted order where every pair is separated from the other by a ','. If no convex hull is possible print -1.

Constraints:
1<=T<=100
1<=N<=100
1<=x,y<=1000

Example:
Input:
2
3
1 2 3 1 5 6
3
1 2 4 4 5 1

Output:
1 2, 3 1, 5 6
1 2, 4 4, 5 1
 */
public class Convex_Hull {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0 , k=0;
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


           // sb.append(timeTakenToPaint(arr,k)).append("\n");
        }
        System.out.print(sb);
    }
}
