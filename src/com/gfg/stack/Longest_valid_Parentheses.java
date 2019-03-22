package com.gfg.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/*
Given a string S consisting of opening and closing parenthesis '(' and ')'. Find length of the longest
valid parenthesis substring.

Input:
First line contains number of test cases T.  Each test case have one line string S of character '(' and ')' of
length  N.

Constraints:
1 <= T <= 500
1 <= N <= 105

Example:
Input:
2
((()
)()())

Output:
2
4

Explanation:
Testcase 1: Longest valid balanced parantheses is () and its length is 2.
 */
public class Longest_valid_Parentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        HashMap<Character,Character> hm = new HashMap<>();
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');
        String  s;
        int value=0, max=-1;
        while(t-->0)
        {
            Stack<Character> stack = new Stack<>();
            s=br.readLine();
            //boolean flag = true;
            for (int i = 0; i < s.length() ; i++) {
                if(s.charAt(i)=='[' || s.charAt(i)=='{' ||s.charAt(i)=='(' )
                    stack.push(s.charAt(i));
                else {
                    //  Character ch = stack.pop();
                    if(stack.empty() || !stack.pop().equals(hm.get(s.charAt(i)))){
                        if(max < value)
                            max = value;
                        stack.clear();
                        value =0;
                       // flag = false;
                    }else{
                        value += 2;
                        if(max < value)
                            max = value;
                    }
                }
            }
            sb.append(max).append(" ");
        }
        System.out.print(sb);
    }
}
