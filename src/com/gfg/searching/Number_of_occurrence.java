package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a sorted array A of size N and a number X, you need to find the number of occurrences of X in A.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow.
Each testcase contains two lines of input: The first line contains N and X(element whose occurrence needs
to be counted). The second line contains the elements of the array separated by spaces.

Output:
For each testcase, print the count of the occurrences of X in the array, if count is zero then print -1.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 103
1 <= X <= 103

Example:
Input:
2
7 2
1 1 2 2 2 2 3
7 4
1 1 2 2 2 2 3
Output:
4
-1

Explanation:
Testcase 1: 2 occurs 4 times in 1 1 2 2 2 2 3
Testcase 2: 4 is not present in 1 1 2 2 2 2 3
 */
public class Number_of_occurrence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,k;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            tk=new StringTokenizer(br.readLine());
            n=Integer.parseInt(tk.nextToken());
            k=Integer.parseInt(tk.nextToken());
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }

            int l=0,r=n-1;
            int mid=0,c=-1;
            //int ans=-1;
            if(k>=arr[0] && k<=arr[n-1]) {
                while (l <= r) {
                    mid = (l + r) / 2;
                    if (k == arr[mid]) {
                        int i = mid-1, j = mid+1;
                        c=1;
                        while ( i >= 0 && arr[i--] == k)
                            c++;
                        while (j < n && arr[j++] == k)
                            c++;
                        break;
                    } else if (k > arr[mid]) {
                        l = mid + 1;
                    } else
                        r = mid - 1;

                }
            }

            sb.append(c).append("\n");
        }
        System.out.print(sb);
    }
}
