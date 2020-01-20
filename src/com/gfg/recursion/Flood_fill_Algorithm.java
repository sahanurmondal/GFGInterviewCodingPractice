package com.gfg.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a 2D screen, location of a pixel in the screen ie(x,y) and a color(K), your task is to replace color of the given pixel and all adjacent(excluding diagonally adjacent) same colored pixels with the given color K.

Example:

                     {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 2, 2, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 2, 2, 0},
                      {1, 1, 1, 1, 1, 2, 1, 1},
                      {1, 1, 1, 1, 1, 2, 2, 1},
                      };

                        x=4, y=4, color=3

                    {{1, 1, 1, 1, 1, 1, 1, 1},
                     {1, 1, 1, 1, 1, 1, 0, 0},
                     {1, 0, 0, 1, 1, 0, 1, 1},
                     {1, 3, 3, 3, 3, 0, 1, 0},
                     {1, 1, 1, 3, 3, 0, 1, 0},
                     {1, 1, 1, 3, 3, 3, 3, 0},
                     {1, 1, 1, 1, 1, 3, 1, 1},
                     {1, 1, 1, 1, 1, 3, 3, 1}, };


Note: Use zero based indexing.


Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The first line of each test case contains Two integers N and M denoting the size of the matrix. Then in the next line are N*M space separated values of the matrix. Then in the next line are three values x, y and K.

Output:
For each test case print the space separated values of the new matrix.

Constraints:
1<=T<=100
1<=M[][]<=100

Example:
Input:
3
3 4
0 1 1 0 1 1 1 1 0 1 2 3
0 1 5
2 2
1 1 1 1
0 1 8
4 4
1 2 3 4 1 2 3 4 1 2 3 4 1 3 2 4
0 2 9

Output:
0 5 5 0 5 5 5 5 0 5 2 3
8 8 8 8
1 2 9 4 1 2 9 4 1 2 9 4 1 3 2 4
 */
public class Flood_fill_Algorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,m=0,x=0,y=0,k=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[][] arr;
        boolean [][]visited;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            m=Integer.parseInt(tk.nextToken());
            n=Integer.parseInt(tk.nextToken());
            arr = new int[m][n];
            visited = new boolean[m][n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++){
                    if(tk.hasMoreTokens())
                        arr[i][j]=Integer.parseInt(tk.nextToken());
                }

            }
            tk = new StringTokenizer(br.readLine());
            x=Integer.parseInt(tk.nextToken());
            y=Integer.parseInt(tk.nextToken());
            k=Integer.parseInt(tk.nextToken());
            int pixel = arr[x][y];
            int[][] coordinates =  {{1,-1,0,0},{0,0,1,-1}};

            floodFill(visited,arr,coordinates,x,y,pixel,k);
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++){
                        sb.append(arr[i][j]).append(" ");
                }

            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void floodFill(boolean [][]visited,int[][] arr, int[][] coordinates, int x, int y,int pixel, int k) {
        if (isSafe(visited,x,y,arr.length,arr[0].length)) {
            if (arr[x][y] == pixel) {
                arr[x][y] = k;
                    for (int j = 0; j <4 ; j++) {
                        floodFill(visited,arr, coordinates, x + coordinates[0][j], y + coordinates[1][j], pixel, k);
                    }
            }
        }
    }
    private static boolean isSafe(boolean [][]visited,int i,int j,int m,int n)
    {
        if(i<0 || i>=m)
            return false;
        if(j<0 || j>=n)
            return false;
        if(visited[i][j])
            return false;
        return true;
    }
}
