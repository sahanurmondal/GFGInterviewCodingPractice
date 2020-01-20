package com.gfg.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a N x N binary matrix A where each row and column of the matrix is sorted in ascending order ,
Your task is to complete the function  countZero which returns the count of  number of 0s present in it.

Note : Elements in matrix can be either 1 or 0

Input:
The first line of input will be the no of test cases then T test cases will follow . The second line of
each test case contains two space separated integers M,N denoting the size of the 2 d matrix . Then in the
next lines are the space separated values of the matrix A[ ] [ ] .

Output:
The output will be the number of zeroes present in the square matrix.

Constraints:
1<=T<=50
1<=M,N<=50
0<=A[][]<=1
Example:
Input
1
3
0 0 0 0 0 1 0 1 1
Output
6
 */
public class Count_zeros_in_a_sorted_matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[][] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            arr= new int[n][n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <n ; j++){
                    arr[i][j]=Integer.parseInt(tk.nextToken());
                }

            }
            int c=0,k=n-1,i=0;
            while (i <n ) {
                        if(arr[i][k]==1) {
                            k--;
                        }else {
                            c+=k+1;
                            i++;
                        }
            }

            sb.append(c).append("\n");
        }
        System.out.print(sb);
    }
}
