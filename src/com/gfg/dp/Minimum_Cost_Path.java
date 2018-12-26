package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a square grid of size n, each cell of which contains integer cost which represents a cost to traverse
through that cell, we need to find a path from top left cell to bottom right cell by which total cost incurred
is minimum.

Note : It is assumed that negative cost cycles do not exist in input matrix.

Input:

The first line of input will contain number of test cases T . Then T test cases follow . Each test case contains
2 lines. The first line of each test case contains an integer n denoting the size of the grid. Next line of each
test contains a single line containing N*N space separated integers depecting cost of respective cell from (0,0)
to (n,n).


Output:

For each test case output a single integer depecting the minimum cost to reach the destination.


Constraints:

1<=T<=50
1<= n<= 50


Example:

Input

2
5
31 100 65 12 18 10 13 47 157 6 100 113 174 11 33 88 124 41 20 140 99 32 111 41 20
2
42 93 7 14


Output
327
63

Explanation:

Test Case 1:

Grid is:
31, 100, 65, 12, 18,
10, 13, 47, 157, 6,
100. 113, 174, 11, 33,
88, 124, 41, 20, 140,
99, 32, 111, 41, 20

A cost grid is given in below diagram, minimum
cost to reach bottom right from top left
is 327 (= 31 + 10 + 13 + 47 + 65 + 12 + 18 +
6 + 33 + 11 + 20 + 41 + 20)
 */
public class Minimum_Cost_Path {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s;
            int n;
            StringTokenizer tk;
            while(t-->0)
            {
                n=Integer.parseInt(br.readLine());
                tk=new  StringTokenizer(br.readLine());
                int[][] arr=new int[n][n];
                for (int i = 0; i <n ; i++) {
                      for (int j = 0; j <n ; j++){
                           arr[i][j] =Integer.parseInt(tk.nextToken());
                      }
                }
               sb.append(shortestPath(arr,n)).append("\n");
            }
            System.out.print(sb);
        }


    public static boolean isSafe(boolean [][]visited,int i,int j,int n)
    {
        if(i<0 || i>=n)
            return false;
        if(j<0 || j>=n)
            return false;
        if(visited[i][j])
            return false;
        return true;
    }

    public static int min(int a,int b)
    {
        if(a<b)
            return a;
        return b;
    }

    public static int shortestPath(int [][]arr,int n)
    {
        boolean [][]visited=new boolean[n][n];

        visited[0][0]=true;

        int distance[][]=new int[n][n];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                distance[i][j]=Integer.MAX_VALUE;

        distance[0][0]=arr[0][0];

        int currI=0;
        int currJ=0;

        int incX[]={-1,1,0,0};

        int incY[]={0,0,-1,1};


        while(true)
        {
            if(currI==n-1 && currJ==n-1)
            {
                break;
            }
            for(int k=0;k<4;k++)
            {
                if(isSafe(visited,currI+incX[k],currJ+incY[k],n))
                {
                    int i=currI+incX[k];
                    int j=currJ+incY[k];
                    distance[i][j]=min(distance[i][j],
                            distance[currI][currJ]+arr[i][j]);
                }
            }
            int minDistance=Integer.MAX_VALUE;
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    if(!visited[i][j])
                        if(minDistance>distance[i][j])
                        {
                            currI=i;
                            currJ=j;
                            minDistance=distance[i][j];
                        }

            visited[currI][currJ]=true;

        }

        return distance[n-1][n-1];

    }
}
