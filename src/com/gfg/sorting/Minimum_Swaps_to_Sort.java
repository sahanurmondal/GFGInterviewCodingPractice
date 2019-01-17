package com.gfg.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given an array of N distinct elementsA[ ], find the minimum number of swaps required to sort the array.Your
are required to complete the function which returns an integer denoting the minimum number of swaps, required
 to sort the array.

Examples:

Input : {4, 3, 2, 1}
Output : 2
Explanation : Swap index 0 with 3 and 1 with 2 to
              form the sorted array {1, 2, 3, 4}.

Input : {1, 5, 4, 3, 2}
Output : 2

Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow .
 Each test case contains an integer N denoting the no of element of the array A[ ]. In the next line are N
 space separated values of the array A[ ] .

Output:
For each test case in a new line output will be an integer denoting  minimum umber of swaps that are  required
to sort the array.

Constraints:
1<=T<=100
1<=N<=100
1<=A[] <=1000

Example(To be used only for expected output):
Input:
2
4
4 3 2 1
5
1 5 4 3 2
Output:
2
2

 */
public class Minimum_Swaps_to_Sort {
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
            int swap=0,min=9999,min_index=0;
            for (int i = 0; i <n ; i++) {
                min=9999;
                for (int j = i; j < n; j++){
                         if(arr[j]<min) {
                             min=arr[j];
                             min_index=j;
                         }
                }
                if (min_index!=i){
                    swap++;
                    swapArr(arr,i,min_index);
                }
            }

            sb.append(swap).append("\n");
        }
        System.out.print(sb);
    }
    static void swapArr(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
