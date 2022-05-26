package com.gfg.company;
/*

In:
00	01	02	03
10	11	12	13
20	21	22	23
30	31	32	33

11--12
12--22
21--11
22-21

arr[i][j] = arr[j][n-i-1]

Out:
30	20	10	00
31	21	11	01
32	22	12	02
33	23	13	03

*/
public class Test {
    public static void main(String[] args) {
      int[][] arr = {{00, 01,02,03},{10,11,12,13},{20,21,22,23},{30,31,32,33}};
      rotateMatrix(arr);
      int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateMatrix(int[][] arr){
        int n = arr.length;
        int t = 0,t1=0;

        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-i-1; j++) {
                t = arr[j][n-i-1];
                arr[j][n-i-1] = arr[i][j] ;
                t1 = arr[n-i-1][n-j-1];
                arr[n-i-1][n-j-1] = t;
                t= arr[n-j-1][i];
                arr[n-j-1][i] =t1;
                arr[i][j] =t ;
            }
        }


    }
}
