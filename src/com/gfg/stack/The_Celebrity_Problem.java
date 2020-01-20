package com.gfg.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
You are in a party of N people, where only one person is known to everyone. Such a person may be present
in the party, if yes, (s)he doesn’t know anyone in the party. Your task is to find the stranger (celebrity)
in party.
You will be given a square matrix M[][] where if an element of row i and column j  is set to 1 it means ith
 person knows jth person. You need to complete the function getId() which finds the id of the celebrity if
  present else return -1. The function getId() takes two arguments, the square matrix M and its size N.

Note: Expected time complexity is O(N) with constant extra space.

Input:
The first line of input contains an element T denoting the number of test cases. Then T test cases follow.
Each test case consist of 2 lines. The first line of each test case contains a number denoting the size of
the matrix M. Then in the next line are space separated values of the matrix M.

Output:
For each test case output will be the id of the celebrity if present (0 based index). Else -1 will be printed.

User Task:
The task is to complete the function getId() which returns the Id of celebrity if present, else -1.

Constraints:
1 <= T <= 50
2 <= N <= 501
0 <= M[][] <= 1

Example:
Input (To be used only for expected output) :
1
3
0 1 0 0 0 0 0 1 0

Output :
1

Explanation :
For the above test case the matrix will look like
0 1 0
0 0 0
0 1 0
Here,  the celebrity is the person with index 1 ie id 1
 */
public class The_Celebrity_Problem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[][] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            arr= new int[n][n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j]=Integer.parseInt(tk.nextToken());
                }
            }

            sb.append(findCelebrity(arr,n)).append("\n");
        }
        System.out.print(sb);
    }
    private static boolean knows(int[][] arr,int a, int b)
    {
        return  (arr[a][b] == 1) ;
    }

    private static int findCelebrity(int[][] arr, int n)
    {
        Stack<Integer> st = new Stack<>();
        int c;

        // Step 1 :Push everybody
        // onto stack
        for (int i = 0; i < n; i++)
        {
            st.push(i);
        }

        while (st.size() > 1)
        {
            // Step 2 :Pop off top
            // two persons from the
            // stack, discard one
            // person based on return
            // status of knows(A, B).
            int a = st.pop();
            int b = st.pop();

            // Step 3 : Push the
            // remained person onto stack.
            if (knows(arr,a, b))
            {
                st.push(b);
            }

            else
                st.push(a);
        }

        c = st.pop();

        // Step 5 : Check if the last
        // person is celebrity or not
        for (int i = 0; i < n; i++)
        {
            // If any person doesn't
            //  know 'c' or 'a' doesn't
            // know any person, return -1
            if (i != c && (knows(arr,c, i) ||
                    !knows(arr,i, c)))
                return -1;
        }
        return c;
    }
}
