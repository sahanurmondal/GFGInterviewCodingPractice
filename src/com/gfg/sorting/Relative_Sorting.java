package com.gfg.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Given two array A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same
as those  in A2. For the elements not present in A2. Append them at last in sorted order. It is also given
that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all
distinct elements.

Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
       A2[] = {2, 1, 8, 3}
Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
Since 2 is present first in A2[], all occurrences of 2s should appear first in A[], then all occurrences 1s
 as 1 comes after 2 in A[]. Next all occurrences of 8 and then all occurrences of 3.  Finally we print all
 those elements of A1[] that are not present in A2[]


Input:

The first line of input contains an integer T denoting the number of test cases. The first line of each test
case is M and N.  M is the number of elements in A1 and N is the number of elements in A2.
The second line of each test case contains M elements. The third line of each test case contains N elements.

Output:

Print the sorted array according order defined by another array.

Constraints:

1 ≤ T ≤ 50
1 ≤ M ≤ 50
1 ≤ N ≤ 10 & N ≤ M
1 ≤ A1[i], A2[i] ≤ 1000

Example:

Input:
1
11 4
2 1 2 5 7 1 9 3 6 8 8
2 1 8 3

Output:
2 2 1 1 8 8 3 5 6 7 9
 */
public class Relative_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,m;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr,arr1;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            n=Integer.parseInt(tk.nextToken());
            m=Integer.parseInt(tk.nextToken());
            arr= new int[n];
            arr1= new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <m ; i++) {
                arr1[i]=Integer.parseInt(tk.nextToken());
            }
            int k=0;
            for (int i = 0; i <m ; i++) {
                  for (int j = k; j <n ; j++){
                            if(arr[j]==arr1[i]){
                                swapArr(arr,k,j);
                                k++;
                            }
                  }
            }
            //mergeSort(arr,k,n-1);
            Arrays.sort(arr, k, n);
            for (int a:arr
            ) {
                System.out.print(a+" ");;
            }
            System.out.println();

            sb.append("").append("\n");
        }
        System.out.print(sb);
    }
    static void swapArr(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void mergeSort(int[] arr,int l,int r){
        if(l<r) {
            int m = (l+r)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr,int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        int k=l;
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
        int i=0,j=0;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        while (i<n1)
            arr[k++]=L[i++];
        while (j<n2)
            arr[k++]=R[j++];

    }
}
