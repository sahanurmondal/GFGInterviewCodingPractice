package com.gfg.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
Given an integer array of size N. For each element in the array, check whether there exist a smaller element
on the next immediate position of the array. If such an element exists, print that element. If there is no
smaller element on the immediate next to the element then print -1.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase
contains 2 lines of input:
The first line contains an integer N, where N is the size of array.
The second line contains N integers(elements of the array) sperated with spaces.

Output:
For each test case, print the next immediate smaller elements for each element in the array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ arr[i] ≤ 1000

Example:
Input
2
5
4 2 1 5 3
6
5 6 2 3 1 7

Output
2 1 -1 3 -1
-1 2 -1 1 -1 -1

Explanation:
Testcase 1: Array elements are 4, 2, 1, 5, 3. Immediate smaller of 2 is immediate smaller of 4, 1 is immediate
smaller of 2, no immediate smaller of 1, 3 is immediate smaller of 5, and no immediate smaller for last element
exists. So ouput is : 2 1 -1 3 -1.
 */
public class Immediate_Smaller_Element {
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
                arr[i]=x;
                /*while (!st.empty() && st.peek() >x){
                    index--;
                    while(arr[index] !=0)
                        index--;
                    st.pop();
                    arr[index] = x;
                }
                st.push(x);*/
            }

            for (int i = 0; i <n-1 ; i++) {
                if(arr[i] > arr[i+1])
                    sb.append(arr[i+1]).append(" ");
                else
                    sb.append(-1).append(" ");
            }
            sb.append(-1).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
