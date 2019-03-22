package com.gfg.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
Given an array A of size N having distinct elements, the task is to find the next greater element for
each element of the array in order of their appearance in the array. If no such element exists, output -1

Input:
The first line of input contains a single integer T denoting the number of test cases.Then T test cases follow.
Each test case consists of two lines. The first line contains an integer N denoting the size of the array.
The Second line of each test case contains N space separated positive integers denoting the values/elements
in the array A.

Output:
For each test case, print in a new line, the next greater element for each array element separated by space in order.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1018
Example:
Input
1
4
1 3 2 4
Output
3 4 4 -1

Explanation:
Testcase1: In the array, the next larger element to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ?
 */
public class Next_larger_element {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0, x=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            Stack<Integer> st = new Stack<>();
            n=Integer.parseInt(br.readLine());
            arr= new int[n];
            int index = 0;
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                index = i;
                x =Integer.parseInt(tk.nextToken());
                while (!st.empty() && st.peek() <x){
                    index--;
                    while(arr[index] !=0)
                        index--;
                    st.pop();
                    arr[index] = x;
                }
                st.push(x);
            }

            for (int i = 0; i <n ; i++) {
                if(arr[i] == 0)
                    sb.append(-1).append(" ");
                else
                    sb.append(arr[i]).append(" ");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
