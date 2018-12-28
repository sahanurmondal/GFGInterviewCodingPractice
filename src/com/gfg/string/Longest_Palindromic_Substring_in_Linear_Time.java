package com.gfg.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given a string, find the longest substring which is palindrome in Linear time O(N).

Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow.
The only line of each test case contains a string.

Output:
For each test case print the Longest Palindromic Substring.

Constraints:
1 <= T <= 100
1 <= N <= 50

Example:
Input:
2
babcbabcbaccba
forgeeksskeegfor

Output:
abcbabcba
geeksskeeg
 */
public class Longest_Palindromic_Substring_in_Linear_Time {


    public  static void Manacher_LPS(String s,int[] p,char[] t) {
        int center = 0, right = 0;
        for (int i = 0; i < t.length; i++) {
            int mirror = 2 * center - i;
            // case 1: if selected index i less then right boundary
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // attempt to expand palindrome centered at i
            // also check the boundary conditions first
            while (i + p[i] < t.length && i - p[i] >= 0
                    && t[i + p[i]] == t[i - p[i]]) {
                p[i]++;
            }

            // case 3: if palindrome centered at i expands past right,
            // adjust center and right boundary based on new expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
    }

    // Transform s into t.
    // For example, if s = "abba", then t = "#a#b#b#a#"
    // the # are interleaved to avoid even/odd-length palindromes uniformly
    private static void preprocess(String s,char[] t) {
        t[0] = '#';
        for (int i = 0; i < s.length(); i++) {
            t[2 * i + 1] = s.charAt(i);
            t[2 * i + 2] = '#';
        }
    }

    // longest palindromic substring
    public static String longestPalindromicSubstring(int[] p,String s) {
        int length = 0;   // length of longest palindromic substring
        int center = 0;   // center of longest palindromic substring
        for (int i = 0; i < p.length; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2 + 1, (center - 1 + length) / 2);
       /* if(s.length()==1 || s==null)
            return "";
        else if(length<=2 )                                       //for geeksforgeeks logic
            return ""+s.charAt(1);
        else
            return s.substring((center - 1 - length) / 2 + 1, (center - 1 + length) / 2);*/
    }

    public String longestPalindromicSubstring(int i,int[] p,String s) {
        int length = p[i];
        int center = i;
        return s.substring((center - 1 - length) / 2 + 1, (center - 1 + length) / 2);
    }
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            String  s;
            while(n-->0)
            {
                s=br.readLine();

                char[] t= new char[s.length() * 2 + 1];;
                int[] p= new int[t.length];
                preprocess(s,t);
                Manacher_LPS(s,p,t);
                sb.append(longestPalindromicSubstring(p,s)).append("\n");
            }
            System.out.print(sb);
        }
}
