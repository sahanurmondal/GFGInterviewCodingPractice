package com.gfg.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Jarvis is weak in computing palindromes for Alphanumeric characters.
While Ironman is busy fighting Thanos,he needs to activate sonic punch but Jarvis is stuck in computing palindromes
You are given a string S containing alphanumeric characters. Find out whether the string is a palindrome or not.
If you are unable to solve it then it may result in the death of Iron Man.

Input:
The first line of the input contains T, the number of test cases. T testcases follow.  Each line of the test case
contains string 'S'.

Output:
Each new line of the output contains "YES" if the string is palindrome and "NO" if the string is not a palindrome.

Constraints:
1<=T<=100
1<=|S|<=100000
Note: Consider alphabets and numbers only for palindrome check. Ignore symbols and whitespaces.

Example:
Input:
2
I am :IronnorI Ma, i
Ab?/Ba

Output:
YES
YES
 */
public class Save_Ironman {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String  s;
        String ans="Yes";
        int n=0;
        while(t-->0)
        {

            s=br.readLine();
            s=s.replaceAll("[^a-zA-Z0-9]", "");
            n=s.length();
            ans="Yes";
            int l=0,r=n-1;
            while(l<=r){
                // Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))
                if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                    ans="No";
                    break;
                }
                l++;r--;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

}
