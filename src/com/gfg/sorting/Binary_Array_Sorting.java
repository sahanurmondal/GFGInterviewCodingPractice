package com.gfg.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Given a binary array, sort it in non-decreasing order

Input: First line contains an integer denoting the test cases 'T'.  Every test case contains two lines,
first line is size and second line is space separated elements of array

Output:  Space separated elements of sorted arrays.  There should be a new line between output of
every test case.


Constraints:
1 <= Size of Array <= 1000
10 <= Number of test cases <= 100

Example:

Input:
2
5
1 0 1 1 0
10
1 0 1 1 1 1 1 0 0 0

Output:
0 0 1 1 1
0 0 0 0 1 1 1 1 1 1
 */
public class Binary_Array_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,x=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            int j=n-1;
            for (int i = 0; i <n ; i++) {
                x=Integer.parseInt(tk.nextToken());
                if(x==1)
                    arr[j--]=x;
            }
            Arrays.stream(arr).forEach(k->System.out.print(k+" ") );
           // System.out.println();
        }

    }
}
