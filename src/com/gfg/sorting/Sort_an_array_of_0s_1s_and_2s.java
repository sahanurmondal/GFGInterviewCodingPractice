package com.gfg.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.

Input:
The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow.
Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines
contains the elements of the array A separated by spaces.

Output:
For each testcase, print the sorted array.

Constraints:
1 <= T <= 500
1 <= N <= 106
0 <= Ai <= 2

Example:
Input :
2
5
0 2 1 2 0
3
0 1 0

Output:
0 0 1 2 2
0 0 1

Explanation:
Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.
 */
public class Sort_an_array_of_0s_1s_and_2s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
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
            int j=n-1,k=0;
            for (int i = 0; i <n ; i++) {
                x=Integer.parseInt(tk.nextToken());
                if(x==2)
                    arr[j--]=x;
                else if(x==1)
                    k++;
            }
            for (int i = j; i >j-k ; i--) {
                    arr[i] = 1;
                }

            for (int a:arr
                 ) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
           // Arrays.stream(arr).forEach(a->System.out.print(a+" ") );

        }
        System.out.print(sb);

    }
}
