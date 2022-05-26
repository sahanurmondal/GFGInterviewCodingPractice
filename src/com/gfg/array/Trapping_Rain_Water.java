package com.gfg.array;
/*
Given an array A of N non-negative integers representing height of blocks at index i as Ai where the width
 of each block is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
|  |
|_|
We can trap 2 units of water in the middle gap.
Input:
The first line of input contains an integer T denoting the number of test cases. The description of
T test cases follows. Each test case contains an integer N followed by N numbers to be stored in array.

Output:
Output the total unit of water trapped in between the blocks.

Constraints:
1 <= T <= 100
3 <= N <= 107
0 <= Ai <= 107

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
0

Explanation:
Testcase 1: Water trapped by block of height 4 is 3 units, block of height 0 is 7 units. So,
total unit of water trapped is 10 units.


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Trapping_Rain_Water {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n = 0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tk.nextToken());
            }
            sb.append(trappedWaterTwoPointer(arr, n)).append("\n");
            //sb.append(trappedWater(arr, n)).append("\n");
        }
        System.out.print(sb);
    }

    private static int trappedWater(int[] arr, int n) {
        int lmax = 0, rmax = 0, ans = 0, l = 0, r = n - 1;
        while (l <= r) {
            if (arr[l] < arr[r]) {
                if (arr[l] > lmax) lmax = arr[l];
                else ans += lmax - arr[l];
                l++;
            } else {
                if (arr[r] > rmax) rmax = arr[r];
                else ans += rmax - arr[r];
                r--;
            }
        }
        return ans;
    }

    private static int trappedWaterTwoPointer(int[] arr, int n) {
        int lmax = 0, rmax = 0, ans = 0, l = 0, r = n - 1;
        while (l <= r) {
            if (rmax <= lmax) {
                ans += Math.max(0, rmax - arr[r]);
                rmax = Math.max(rmax, arr[r]);
                r--;
            } else {
                ans += Math.max(0, lmax - arr[l]);
                lmax = Math.max(lmax, arr[l]);
                l++;
            }
        }
        return ans;
    }

    private static int maxWater(int[] height, int n) {
        // Stores the indices of the bars
        Stack<Integer> stack = new Stack<>();

        // Stores the final result
        int ans = 0;

        // Loop through the each bar
        for (int i = 0; i < n; i++) {

            // Remove bars from the stack
            // until the condition holds
            while ((!stack.isEmpty())
                    && (height[stack.peek()] < height[i])) {

                // store the height of the top
                // and pop it.
                int pop_height = height[stack.peek()];
                stack.pop();

                // If the stack does not have any
                // bars or the popped bar
                // has no left boundary
                if (stack.isEmpty())
                    break;

                // Get the distance between the
                // left and right boundary of
                // popped bar
                int distance = i - stack.peek() - 1;

                // Calculate the min. height
                int min_height
                        = Math.min(height[stack.peek()],
                        height[i])
                        - pop_height;

                ans += distance * min_height;
            }

            // If the stack is either empty or
            // height of the current bar is less than
            // or equal to the top bar of stack
            stack.push(i);
        }

        return ans;
    }
}
