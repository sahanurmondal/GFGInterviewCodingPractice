package com.gfg.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
An string of words is given, the task is to reverse the string using stack.

Input Format:
The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow.
Each test case contains a string s of words without spaces.

Output Format:
For each test case ,print the reverse of the string in new line.

Your Task:
Since this is a function problem, you don't need to take any input. Just complete the provided function.

Constraints:
1 <= T <= 100
1 <= length of the string <= 100

Example:
Input:
2
GeeksQuiz
GeeksforGeeks
Output:
ziuQskeeG
skeeGrofskeeG
 */
public class Reverse_a_string_using_Stack {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s;
            while(t-->0)
            {
                s=br.readLine();
                Stack<Character> st = new Stack<>();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    st.push(s.charAt(i));
                }
                while (!st.empty()){
                    temp.append(st.pop());
                }
                sb.append(temp.toString()).append("\n");
            }
            System.out.print(sb);
        }
}
