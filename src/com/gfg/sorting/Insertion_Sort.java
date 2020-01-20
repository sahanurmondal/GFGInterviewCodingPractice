package com.gfg.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
The task is to complete insert() function which is used to implement Insertion Sort.

Input:
First line of the input denotes number of test cases 'T'. First line of the test case is the size of array
and second line consists of array elements.


Output:
Sorted array in increasing order is displayed to the user.


Constraints:
1 <=T<= 50
1 <=N<= 1000
1 <=arr[i]<= 1000


Example:

Input:
2
5
4 1 3 9 7
10
10 9 8 7 6 5 4 3 2 1

Output:
1 3 4 7 9
1 2 3 4 5 6 7 8 9 10
 */
public class Insertion_Sort {
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
            for (int i = 1; i <n ; i++) {
                int j=i;
                int x=arr[i];
                while (j>0 && x<arr[j-1]) {
                    arr[j]=arr[j-1];
                    j--;
                }
                if(j<i){
                    arr[j]=x;
                }
            }
            for (int a:arr
            ) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
