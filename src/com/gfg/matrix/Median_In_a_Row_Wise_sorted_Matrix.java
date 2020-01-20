package com.gfg.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
We are given a row wise sorted matrix of size r*c, we need to find the median of the matrix given.
It is assumed that r*c is always odd.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains
two integers r and c, where r is the number of rows and c is the number of columns in the array a[]. Next
r line contains space separated c elements each in the array a[].â€‹

Output:
Print an integer which is the median of the matrix.

Constraints:
1<= T <=100
1<= r,c <=150
1<= a[i][j] <=1000

Example:
Input:
1
3 3
1 3 5
2 6 9
3 6 9

Output:
5
 */
public class Median_In_a_Row_Wise_sorted_Matrix {
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

            for (int i = 0; i <m ; i++) {
                tk = new StringTokenizer(br.readLine());
                for (int j = 0; j <n ; j++){
                    if(tk.hasMoreTokens())
                    arr[i][j]=Integer.parseInt(tk.nextToken());
                }

            }
            sb.append(binaryMedian(arr,m,n)).append("\n");
        }
        System.out.print(sb);
    }
    // function to find median in the matrix
    static int binaryMedian(int m[][],int r, int c)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<r ; i++)
        {

            // Finding the minimum element
            if(m[i][0] < min)
                min = m[i][0];

            // Finding the maximum element
            if(m[i][c-1] > max)
                max = m[i][c-1];
        }

        int desired = (r * c + 1) / 2;
        while(min < max)
        {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;

            // Find count of elements smaller than mid
            for(int i = 0; i < r; ++i)
            {

                get = Arrays.binarySearch(m[i],mid);

                // If element is not found in the array the
                // binarySearch() method returns
                // (-(insertion_point) - 1). So once we know
                // the insertion point we can find elements
                // Smaller than the searched element by the
                // following calculation
                if(get < 0)
                    get = Math.abs(get) - 1;

                    // If element is found in the array it returns
                    // the index(any index in case of duplicate). So we go to last
                    // index of element which will give  the number of
                    // elements smaller than the number including
                    // the searched element.
                else
                {
                    while(get < m[i].length && m[i][get] == mid)
                        get += 1;
                }

                place = place + get;
            }

            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }
}
