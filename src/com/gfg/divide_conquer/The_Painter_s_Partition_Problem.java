package com.gfg.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Dilpreet wants to paint his dog- Buzo's home that has n boards with different lengths[A1, A2,..., An]. He hired
k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.The problem is to find
the minimum time to get this job done under the constraints that any painter will only paint continuous sections
of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.

Input:
The first line consists of a single integer T, the number of test cases. For each test case, the first
line contains an integer k denoting the number of painters and integer n denoting the number of boards.
Next line contains n- space separated integers denoting the size of boards.

Output:
For each test case, the output is an integer displaying the minimum time for painting that house.

Constraints:
1<=T<=100
1<=k<=30
1<=n<=50
1<=A[i]<=500

Example:
Input:
2
2 4
10 10 10 10
2 4
10 20 30 40
Output:
20
60

Explanation:
1. Here we can divide the boards into 2 equal sized partitions, so each painter gets 20 units of the board
and the total time taken is 20.
2. Here we can divide first 3 boards for one painter and the last board for the second painter.
 */
public class The_Painter_s_Partition_Problem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0 , k=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            k=Integer.parseInt(tk.nextToken());
            n=Integer.parseInt(tk.nextToken());
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }


            sb.append(timeTakenToPaint(arr,k)).append("\n");
        }
        System.out.print(sb);
    }

    private static int timeTakenToPaint(int[] arr, int k) {
        int n = arr.length;
        int lo = Arrays.stream(arr).max().orElse(0);
        int hi = Arrays.stream(arr).sum();
       // int count =0;
     //   System.out.println("Expected Complexity " +String.valueOf((int)Math.ceil(Math.log(hi-lo)/Math.log(2))*n));
        while ( lo < hi ) {
          //  count++;
            int x = lo + (hi-lo)/2;

            int required = 1, current_load = 0;
            for ( int i=0; i < n; ++i ) {
                if ( current_load + arr[i] <= x ) {
                    current_load += arr[i];
                }else {
                    ++required;
                    current_load = arr[i];
                }
            }

            if ( required <= k )
                hi = x;
            else
                lo = x+1;
        }
       // System.out.println("Actual Complexity " +count*n);
        return lo;
    }

}
