package com.gfg.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/*
Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]”
are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

Input:
The first line of input contains an integer T denoting the number of test cases.  Each test case consists of
a string of expression, in a separate line.

Output:
Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ |s| ≤ 105

Example:
Input:
3
{([])}
()
([]

Output:
balanced
balanced
not balanced
 */
public class Parenthesis_Checker {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            HashMap<Character,Character> hm = new HashMap<>();
            hm.put(')','(');
            hm.put('}','{');
            hm.put(']','[');
            String  s;
            while(t-->0)
            {
                Stack<Character> stack = new Stack<>();
                s=br.readLine();
                boolean flag = true;
                for (int i = 0; i < s.length() ; i++) {
                    if(s.charAt(i)=='[' || s.charAt(i)=='{' ||s.charAt(i)=='(' )
                        stack.push(s.charAt(i));
                    else {
                      //  Character ch = stack.pop();
                        if(stack.empty() || !stack.pop().equals(hm.get(s.charAt(i)))){
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag && stack.empty())
                    sb.append("balanced").append("\n");
                else
                    sb.append("not balanced").append("\n");
            }
            System.out.print(sb);
        }
}
