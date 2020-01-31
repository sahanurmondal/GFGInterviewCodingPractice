package com.gfg.array;

/*
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010

Example:
Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
Output:
2 4
1 5

Explanation :
Testcase1: sum of elements from 2nd position to 4th position is 12
Testcase2: sum of elements from 1st position to 5th position is 15
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sub_array_with_given_sum_unsorted {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n = 0, s = 0;
        StringTokenizer tk;
        int[] arr;
        while (t-- > 0) {
            tk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(tk.nextToken());
            s = Integer.parseInt(tk.nextToken());
            arr = new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tk.nextToken());
            }

            int l = 0, r = 1, sum = arr[l];
            boolean flag = s == sum;
            while (!flag && r < n) {
                sum += arr[r];
                while (sum > s) {
                    sum -= arr[l];
                    l++;
                }

                if (s == sum) {
                    flag = true;
                    break;
                }
                r++;
            }
            if (flag)
                sb.append(l + 1).append(" ").append(r + 1).append("\n");
            else
                sb.append(-1).append("\n");
        }
        System.out.print(sb);
    }
}
