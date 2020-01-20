package com.gfg.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given two arrays A and B. The task is to complete the function max_path_sum that takes 4 argument,
 the first two arguments represent the 2 arrays A[] and B[] and the last two arguments l1, l2 denote
  the size of array A and B respectively. The function returns the sum of the maximum sum path to reach from
   beginning of any array to end of any of the two arrays .

Note: You can switch from one array to another array only at common elements.

Input:
The first line of input contains an integer T denoting the no of test cases . Then T cases follow.
Each test case contains 3 lines. The first line contains two space separated integers l1 and l2 denoting
the length of the two sorted array A and B. In the second line is the space separated values of array A
and in the third line are space separated values of array B.

Output:
For each test case the output is the max sum obtained in such fashion .

Constraints:
1 <= T <= 100
1 <= N, M <= 103
1 <= A[], B[] <= 104

Example:
2
5 4
2 3 7 10 12
1 5 7 8
3 3
1 2 4
1 2 7

Output
35
10

Explanation:
Testcase 1: For first test case the path will be 1+5+7+10+12 = 35.
Testcase 2: For second test case the path will be 1+2 +7=10.
 */
public class Max_sum_path_in_two_arrays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n1=0,n2=0;
        int x=0,y=0;
        StringTokenizer tk,tk1;
        while(t-->0)
        {
            int[] ar1, ar2;
            //n=Long.parseLong(br.readLine());
            tk = new StringTokenizer(br.readLine());
            n1= Integer.parseInt(tk.nextToken());
            n2= Integer.parseInt(tk.nextToken());
            ar1=new int[n1];
            ar2=new int[n2];
            tk = new StringTokenizer(br.readLine());
            tk1 = new StringTokenizer(br.readLine());
            for (int i = 0; i <n1 ; i++) {
                ar1[i]=Integer.parseInt(tk.nextToken());
            }
            for (int i = 0; i <n2 ; i++) {
                ar2[i]=Integer.parseInt(tk1.nextToken());
            }
            sb.append(maxPathSum(ar1,ar2)).append("\n");
        }
        System.out.print(sb);
    }

    static int maxPathSum(int ar1[], int ar2[])
    {
        // initialize indexes for ar1[] and ar2[]
        int i = 0, j = 0;
        int m=ar1.length, n=ar2.length;
        // Initialize result and current sum through ar1[] and ar2[].
        int result = 0, sum1 = 0, sum2 = 0;

        // Below 3 loops are similar to merge in merge sort
        while (i < m && j < n)
        {
            // Add elements of ar1[] to sum1
            if (ar1[i] < ar2[j])
                sum1 += ar1[i++];

                // Add elements of ar2[] to sum2
            else if (ar1[i] > ar2[j])
                sum2 += ar2[j++];

            else // we reached a common point
            {
                // Take the maximum of two sums and add to result
                result += Math.max(sum1, sum2);

                // Update sum1 and sum2 for elements after this
                // intersection point
                sum1 = 0; sum2 = 0;

                // Keep updating result while there are more common
                // elements
                while (i < m && j < n && ar1[i] == ar2[j])
                {
                    result = result + ar1[i++];
                    j++;
                }
            }
        }

        // Add remaining elements of ar1[]
        while (i < m)
            sum1 += ar1[i++];

        // Add remaining elements of ar2[]
        while (j < n)
            sum2 += ar2[j++];

        // Add maximum of two sums of remaining elements
        result += Math.max(sum1, sum2);

        return result;
    }
}
