package com.gfg.array;
/*
Given an unsorted array of size n. Array elements are in range from 1 to n. One number 'A' from
set {1, 2, …n} is missing and one number 'B' occurs twice in array. Find these two numbers.
Note: If you find multiple answers then print the Smallest number found.

Input:

The first line of input contains an integer T denoting the number of test cases. The description of T test
cases follows.
The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.


Output:

Print B, the repeating number followed by A which is missing in a single line.


Constraints:

1 ≤ T ≤ 40
1 ≤ N ≤ 100
1 ≤ A[i] ≤ N


Example:

Input
2
2
2 2
3
1 3 3
Output
2 1
3 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Find_Missing_And_Repeating {
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
            int[] count=new int[n+1];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
                count[arr[i]]++;
            }
            int m=0;
            boolean flag=true,flag2=true;
            for (int i = 1; i <= n; i++) {
                if(flag){
                    if (count[i]==0) {
                        m = i;
                        flag=false;
                    }
                }
                if(flag2) {
                    if (count[i] >= 2) {
                        sb.append(i).append(" ");
                        flag2=false;
                    }
                }
            }

            sb.append(m).append("\n");
        }
        System.out.print(sb);
    }
}
