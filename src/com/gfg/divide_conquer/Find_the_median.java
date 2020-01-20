package com.gfg.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Given the marks of all students, calculate the median.

Input:
The first line of input takes the number of test cases, T. For each test case there will be two lines.
The first line contains an integer N denoting the number of students, and second line contains N space
seperated integers which denotes the marks of N students.

Output:
Print the floor value of the median for each test case on a new line.

Constraints:
1 <= T <= 100
1 <= N <= 100
1 <= Marks <= 100

Example:
Input:
3
4
56 67 30 79
4
78 89 67 76
5
90 100 78 89 67

Output:
61
77
89
 */
public class Find_the_median {
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
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }
            Arrays.sort(arr);
            if(n%2 == 1)
                sb.append(arr[n/2]).append("\n");
            else
                sb.append((int)((arr[n/2 -1]+arr[n/2])/2)).append("\n");
        }
        System.out.print(sb);
    }
}
