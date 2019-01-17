package com.gfg.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given an array of integers, sort the array according to frequency of elements. For example, if the input
array is {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}, then modify the array to {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}.

If frequencies of two elements are same, print them in increasing order.



Input:

The first line of input contains an integer T denoting the number of test cases. The description of T test
cases follows. The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.


Output:

Print each sorted array in a seperate line. For each array its numbers should be seperated by space.


Constraints:

1 ≤ T ≤ 70
30 ≤ N ≤ 130
1 ≤ A [ i ] ≤ 60


Example:

Input:

1
5
5 5 4 6 4

Output:

4 4 5 5 6
 */
public class Sorting_Elements_of_an_Array_by_Frequency {
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
            arr= new int[62];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                x=Integer.parseInt(tk.nextToken());
                arr[x]++;
            }
            int j=0,max=0,c=0;
            while (c<n) {
                j=0;max=0;
                for (int i = 1; i < 62; i++) {
                    if (arr[i]>max){
                        max=arr[i];
                        j=i;
                    }
                }
                c+=max;
                arr[j]=0;
                for (int i = 0; i <max ; i++) {
                    sb.append(j).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
