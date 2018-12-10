package com.gfg.string;
/*
Given two strings S1 and S2 in lowercase, the task is to make them anagram. The only allowed operation is to remove a character from any string. Find minimum number of characters to be deleted to make both the strings anagram. If two strings contains same data set in any order then strings are called Anagrams.

Input Format:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
Each test case consists of 2 strings to make the anagrams.

Output Format:
For each testcase, in a new line, output the minimum number of characters to be deleted to make both the
strings anagram.

Your Task:
Since this is a function problem, you don't need to take any input. Just complete the provided function.

Constraints:
1 <= T <= 100
1 <= |S1|, |S2| <= 105

Example:
Input:
2
bcadeh
hea
cddgk
gcd
Output:
3
2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Anagram_of_String {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s1,s2;
            while(t-->0)
            {
                s1=br.readLine();
                s2=br.readLine();
                int c=0;
                int[] arr1 = new int[256];
                int[] arr2 = new int[256];

                for (int i = 0; i < s1.length(); i++) {
                    arr1[s1.charAt(i)]++;
                }
                for (int i = 0; i < s2.length(); i++) {
                    arr2[s2.charAt(i)]++;
                }
                for (int i = 0; i < 256; i++) {
                    c+=Math.abs(arr1[i]-arr2[i]);
                }
                sb.append(c).append("\n");
            }
            System.out.print(sb);
        }
}
