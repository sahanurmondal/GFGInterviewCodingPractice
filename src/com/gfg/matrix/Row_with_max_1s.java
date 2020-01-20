package com.gfg.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a boolean 2D array where each row is sorted. Find the row with the maximum number of 1s.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case contains n and m, where n is the number of rows and m is the number of
columns. The second line of each test case contains the array elements.

Output:
Print the row with the maximum number of 1s.

Constraints:
1 ≤ T ≤ 50
1 ≤ n,m ≤ 103

Example:
Input:
1
4 4
0 1 1 1 0 0 1 1 1 1 1 1 0 0 0 0

Output:
2

Explanation :
Testcase 1 : Row 2 is having maximum number of 1s (0-based indexing).
 */
public class Row_with_max_1s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,m=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[][] arr;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            n=Integer.parseInt(tk.nextToken());
            m=Integer.parseInt(tk.nextToken());
            arr= new int[n][m];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <m ; j++){
                    arr[i][j]=Integer.parseInt(tk.nextToken());
                }

            }
            int ans=0,k=n-1,i=0;
            while (i <n ) {
                if(k==0 && arr[i][k]==1){
                    ans=i;
                    break;
                }
                else if(arr[i][k]==1) {
                    k--;

                }else {
                    i++;
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
