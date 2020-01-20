package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Find the missing element from  an ordered array A[ ], consisting of N elements representing an Arithmetic
Progression (AP) .


Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
The first line of each test case contains an integer N, where N is the size of the array A[ ].
The second line of each test case contains N space separated integers of an Arithmetic Progression denoting
elements of the array A[ ].


Note: The series should have a missing element in between a perfect A.P. with no missing element will not be
considered.


Output:
Print out the missing element.


Constraints:
1 <= T <= 100
2 <= N <= 10
-50 <= A[i] <=50


Examples :

Input:
3
3
2 10 14
4
-28 -21 -7 0
5
9 12 15 21 24

Output :
6
-14
18

 */
public class Missing_element_of_AP {
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
            int temp=0;
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
                temp+=arr[i];
            }
            int sum=((n+1)*(arr[0]+arr[n-1]))/2;
            sb.append(sum-temp).append("\n");
        }
        System.out.print(sb);
    }
}
