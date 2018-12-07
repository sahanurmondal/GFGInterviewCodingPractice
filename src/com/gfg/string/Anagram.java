package com.gfg.string;
/*
Given two strings, check whether two given strings are anagram of each other or not. An anagram of a string
is another string that contains same characters, only the order of characters can be different. For example,
“act” and “tac” are anagram of each other.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case consist of
two strings in 'lowercase' only, in a single line.

Output:
Print "YES" without quotes if the two strings are anagram else print "NO".

Constraints:
1 ≤ T ≤ 30
1 ≤ |s| ≤ 1016

Example:
Input:
2
geeksforgeeks forgeeksgeeks
allergy allergic

Output:
YES
NO
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Anagram {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s;
            StringTokenizer tk;
            while(t-->0)
            {
                int[] arr1=new int[256];
                int[] arr2=new int[256];
                tk = new StringTokenizer(br.readLine());
                s=tk.nextToken();
                for (int i = 0; i <s.length() ; i++) {
                    arr1[s.charAt(i)]++;
                }
                s=tk.nextToken();
                for (int i = 0; i <s.length() ; i++) {
                    arr2[s.charAt(i)]++;
                }
                boolean flag= Arrays.equals(arr1,arr2);
                if(flag)
                    sb.append("YES").append("\n");
                else
                    sb.append("NO").append("\n");
            }
            System.out.print(sb);
        }
}
