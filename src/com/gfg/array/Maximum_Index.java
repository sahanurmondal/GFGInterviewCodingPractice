package com.gfg.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

Example :

A : [3 5 4 2]

Output : 2
for the pair (3, 4)



Input:

The first line contains an integer T, depicting total number of test cases.
Then following T lines contains an integer N depicting the size of array and next line followed by
the value of array.


Output:

Print the maximum difference of the indexes i and j in a separtate line.


Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 1000
0 ≤ A[i] ≤ 100


Example:

Input
1
2
1 10
Output
1
 */
public class Maximum_Index {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        int i=0,j=0;
        int[] arr;
        StringTokenizer tk;
        while(t-->0)
        {
            int c=0;
            n=Integer.parseInt(br.readLine());
            arr=new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                arr[k]=Integer.parseInt(tk.nextToken());;
            }
            if(n!=1){
                i=0;
                j=n-1;
                while (i<n-1){
                    if (arr[i]<=arr[j]){
                        if(j-i >c)
                            c=j-i;
                        i++;
                        j=n-1;
                    }else
                        j--;
                }
            }
            sb.append(c).append("\n");
        }
        System.out.print(sb);
    }
}
