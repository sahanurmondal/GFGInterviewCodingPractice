package com.gfg.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given two sorted arrays A and B of size M and N respectively and an element k. The task is to find the
element that would be at the k’th position of the final sorted array.

Input:
First line consists of test cases T. First line of every test case consists of 3 integers N, M and K,
denoting M number of elements in A, N number of elements in B and kth position element. Second and Third
line of every test case consists of elements of A and B respectively.

Output:
Print the element at the Kth position.

Constraints:
1 <= T <= 200
1 <= N, M <= 106
1 <= Ai, Bi <= 106
1 <= K <= N+M

Example:
Input:
1
5 4 5
2 3 6 7 9
1 4 8 10

Output:
6

Explanation:
Testcase 1: Element at 5th position after merging both arrays will be 6.
 */
public class K_th_element_of_two_sorted_Arrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,m=0,k=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr1,arr2;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            m=Integer.parseInt(tk.nextToken());
            n=Integer.parseInt(tk.nextToken());
            k=Integer.parseInt(tk.nextToken());
            arr1= new int[m];
            arr2= new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <m ; i++) {
                arr1[i]=Integer.parseInt(tk.nextToken());
            }
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr2[i]=Integer.parseInt(tk.nextToken());
            }

            sb.append(kth(arr1,m,arr2,n,k,0,0)).append("\n");
        }
        System.out.print(sb);
    }
    static int kth(int arr1[], int m, int arr2[], int n, int k,int startIndex1,int startIndex2)
    {

        if (k > (m+n) || k < 1) return -1;

        // let m <= n
        if (m > n) return kth(arr2, n, arr1, m, k,startIndex2,startIndex1);

        // if arr1 is empty returning k-th element of arr2
        if (m == 0) return arr2[startIndex2+k - 1];
        //if (n == 0) return arr1[k - 1];
        // if k = 1 return minimum of first two elements of both arrays
        if (k == 1) return Math.min(arr1[startIndex1], arr2[startIndex2]);

        // now the divide and conquer part
        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);

        if (arr1[i - 1+startIndex1] > arr2[j - 1+startIndex2] ) {
            // Now we need to find only k-j th element since we have found out the lowest j
            startIndex2 += j;
            return kth(arr1, m, arr2, n - j, k - j,startIndex1,startIndex2);
        }
        else {
            // Now we need to find only k-i th element since we have found out the lowest i
            startIndex1 += i;
            return kth(arr1, m - i, arr2, n, k - i,startIndex1,startIndex2);
        }
    }
}

