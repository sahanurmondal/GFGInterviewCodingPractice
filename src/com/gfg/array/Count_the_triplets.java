package com.gfg.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5
 */
public class Count_the_triplets {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            int n=0;
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
              sb.append(countWays(arr,n)).append("\n");
            }
            System.out.print(sb);
        }

    static int countWays(int[] arr, int n)
    {
        // compute the max value in the array
        // and create frequency array of size
        // max_val + 1.
        // We can also use HashMap to store
        // frequencies. We have used an array
        // to keep remaining code simple.
        int max_val = 0;
        for (int i = 0; i < n; i++)
            max_val = Math.max(max_val, arr[i]);
        int[] freq = new int[max_val + 1];
        for (int i = 0; i < n; i++)
            freq[arr[i]]++;

        int ans = 0; // stores the number of ways

        // Case 1: 0, 0, 0
        ans += freq[0] * (freq[0] - 1) * (freq[0] - 2) / 6;

        // Case 2: 0, x, x
        for (int i = 1; i <= max_val; i++)
            ans += freq[0] * freq[i] * (freq[i] - 1) / 2;

        // Case 3: x, x, 2*x
        for (int i = 1; 2 * i <= max_val; i++)
            ans += freq[i] * (freq[i] - 1) / 2 * freq[2 * i];

        // Case 4: x, y, x + y
        // iterate through all pairs (x, y)
        for (int i = 1; i <= max_val; i++) {
            for (int j = i + 1; i + j <= max_val; j++)
                ans += freq[i] * freq[j] * freq[i + j];
        }

        if(ans != 0)
            return ans;
        else
            return -1;
    }

}
