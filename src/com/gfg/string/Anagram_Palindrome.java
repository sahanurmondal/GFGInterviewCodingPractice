package com.gfg.string;
/*
Given a string S, Check if characters of the given string can be rearranged to form a palindrome.
For example characters of “geeksogeeks” can be rearranged to form a palindrome “geeksoskeeg”,
but characters of “geeksforgeeks” cannot be rearranged to form a palindrome.

Input:
First line consists of integer T  denoting the number of test cases. T testcases follow. For each testcase
there are one line of input containing string S.

Output:
For each testcase, in a new line, print "Yes" if is possible to make it a palindrome, else "No".

Constraints:
1 <= T <= 100
1 <= |S| <= 1000

Example:
Input:
2
geeksogeeks
geeksforgeeks
Output:
Yes
No
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram_Palindrome {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s;
            while(t-->0)
            {
                s=br.readLine();
                int[] arr1=new int[256];
                for (int i = 0; i <s.length() ; i++) {
                    arr1[s.charAt(i)]++;
                }
                int c=0;
                for (int i = 0; i <arr1.length ; i++) {
                   if(arr1[i]%2==1)
                       c++;
                }
                if ((s.length()%2==0 && c==0) ||(s.length()%2==1 && c==1))
                    sb.append("Yes").append("\n");
                else
                    sb.append("No").append("\n");
            }
            System.out.print(sb);
        }
}
