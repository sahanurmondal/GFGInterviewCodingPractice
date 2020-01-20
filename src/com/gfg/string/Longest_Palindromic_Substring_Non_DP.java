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
public class Longest_Palindromic_Substring_Non_DP {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int m = Integer.parseInt(br.readLine());
            String  s;
            while(m-->0)
            {
                s=br.readLine();
                String ans="";
                if (s != null && s.length() >=1) {
                    int start = 0, end = 0;
                    for (int i = 0; i < s.length(); i++) {
                        int len1 = expandAroundCenter(s, i, i);
                        int len2 = expandAroundCenter(s, i, i + 1);
                        int len = Math.max(len1, len2);
                        if (len > end - start) {
                            start = i - (len - 1) / 2;
                            end = i + len / 2;
                        }
                    }
                    ans=s.substring(start, end + 1);
                }
                sb.append(ans).append("\n");
            }
            System.out.print(sb);
        }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
