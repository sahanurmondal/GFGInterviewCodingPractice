package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Given a text 'str' and a wildcard pattern 'pattern',your task is to complete the function wildcard that
returns '1' if the  wildcard pattern is matched with text else returns '0'.The function takes two strings
as arguments 'str' and 'pattern'.

The wildcard pattern can include the characters ‘?’ and ‘*’
‘?’ – matches any single character
‘*’ – Matches any sequence of characters (including the empty sequence)

For example,

Text = "baaabab",
Pattern = “*****ba*****ab", output : true
Pattern = "baaa?ab", output : true
Pattern = "ba*a?", output : true
Pattern = "a*ab", output : false

Note: The matching should cover the entire text (not partial text).

Input
The first line of input will contain no of test cases T . Then T test cases follow . Each test case contains
2 lines. The first line of each test case represent a string pat denoting the pattern and the next line contains
string str .

Output
Output will be 1 if the string follows the pattern else it will be 0.

Constraints:
1<=T<=50
1<=length of(str,pat) <=50

Example
Input
2
a*a
aa
a?a
aa

Output
1
0
 */
public class Wildcard_Pattern_Matching {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s,s1;
            while(t-->0)
            {
                s=br.readLine();
                s1=br.readLine();

                sb.append(wildCard(s,s1)).append("\n");
            }
            System.out.print(sb);
        }

    static int wildCard(String pattern, String str)
    {
        // empty pattern can only match with
        // empty string
        int n=str.length();
        int m=pattern.length();
        if (m == 0)
            return (n == 0)?1:0;

        // lookup table for storing results of
        // subproblems
        boolean[][] lookup = new boolean[n + 1][m + 1];

        // initailze lookup table to false
        /*for(int i = 0; i < n + 1; i++)
            Arrays.fill(lookup[i], false);*/


        // empty pattern can match with empty string
        lookup[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1] ||
                            lookup[i - 1][j];

                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?' ||
                        str.charAt(i - 1) == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                    // If characters don't match
                else lookup[i][j] = false;
            }
        }

        return lookup[n][m]?1:0;
    }
}
