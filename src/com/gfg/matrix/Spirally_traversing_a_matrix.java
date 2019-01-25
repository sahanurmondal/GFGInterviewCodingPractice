package com.gfg.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a 2D matrix of size M*N. Traverse and print the matrix in spiral form.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. Then T test
 cases follow. Each testcase has 2 lines. First line contains M and N respectively separated by a space.
 Second line contains M*N values separated by spaces.

Output:
Elements when travelled in Spiral form, will be displayed in a single line.

Constraints:
1 <=T<= 100
2 <= M, N <= 10
0 <= Ai <= 100

Example:
Input:
1
4 4
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 */
public class Spirally_traversing_a_matrix {
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
            m=Integer.parseInt(tk.nextToken());
            n=Integer.parseInt(tk.nextToken());
            arr= new int[m][n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++){
                    arr[i][j]=Integer.parseInt(tk.nextToken());
                }

            }
            int ul=0,ur=n-1,dl=0,dr=m-1,k=0;
            n=m*n;
            while(true){
                if(k==n){
                    break;
                }else{
                    for (int i = dl; i <=ur ; i++) {
                        sb.append(arr[ul][i]).append(" ");
                        k++;
                    }
                    ul++;
                    if (k==n)
                        break;
                    for (int i = ul; i <=dr ; i++) {
                        sb.append(arr[i][ur]).append(" ");
                        k++;
                    }
                    ur--;
                    if (k==n)
                        break;
                    for (int i = ur; i >=dl; i--) {
                        sb.append(arr[dr][i]).append(" ");
                        k++;
                    }
                    dr--;
                    if (k==n)
                        break;
                    for (int i = dr; i >=ul ; i--) {
                        sb.append(arr[i][dl]).append(" ");
                        k++;
                    }
                    dl++;
                    if (k==n)
                        break;

                }
            }

            sb.append("").append("\n");
        }
        System.out.print(sb);
    }
}
