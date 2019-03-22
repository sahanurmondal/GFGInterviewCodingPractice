package com.gfg.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Design a data-structure SpecialStack (using the STL of stack) that supports all the stack operations
like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum
element from the SpecialStack. Your task is to complete all the functions, using stack data-Structure.

Input Format:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
Each test case contains two lines. The first line of input contains an integer n denoting the number of
integers in a sequence. In the second line are n space separated integers of the stack.

Output Format:
For each testcase, in a new line, print the minimum integer from the stack.

Your Task:
Since this is a function problem, you don't need to take inputs. Just complete the provided functions.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
1
5
18 19 29 15 16
Output:
15
 */
public class Special_Stack {
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
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }

            sb.append("").append("\n");
        }
        System.out.print(sb);
    }

}
