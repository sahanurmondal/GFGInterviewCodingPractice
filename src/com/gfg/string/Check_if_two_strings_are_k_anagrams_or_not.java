package com.gfg.string;
/*
Given two strings of lowercase alphabets and a value K, your task is to complete the given function which
tells if  two strings are K-anagrams of each other or not.
Two strings are called K-anagrams if both of the below conditions are true.
1. Both have same number of characters.
2. Two strings can become anagram by changing at most K characters in a string.

Input Format:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
The first line of input contains two Strings Str1 and Str2. And next line contains an integer K, which
denotes number of characters can be replaced.

Output Format:
For each testcase, in a new line, print the respective output.

Your Task:
Since this is a function problem, you don't need to take any input. Just complete the given function
areKAnagrams that returns true if the strings can be turned into K-anagrams, else return false.

Constraints:
1 <= T <= 100
1 <= K <= |length of String|

Example:
Input:
1
fodr gork
2
Output:
1

Explanation:
Testcase1: change fd to gk
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Check_if_two_strings_are_k_anagrams_or_not {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s1,s2;
            StringTokenizer tk;
            int k=0;
            while(t-->0)
            {
                tk = new StringTokenizer(br.readLine());
                k=Integer.parseInt(br.readLine());
                s1=tk.nextToken();
                s2=tk.nextToken();
                int c=0;
                boolean flag= true;
                if(s1.length()!=s2.length())
                    flag=false;
                else {
                    int[] arr1 = new int[256];
                    int[] arr2 = new int[256];

                    for (int i = 0; i < s1.length(); i++) {
                        arr1[s1.charAt(i)]++;
                    }
                    for (int i = 0; i < s2.length(); i++) {
                        arr2[s2.charAt(i)]++;
                    }
                    for (int i = 0; i < 256; i++) {
                        if(arr1[i]>arr2[i]){
                            c+=arr1[i]-arr2[i];
                        }
                        if (c>k){
                            flag=false;
                            break;
                        }
                    }
                }

                if(flag)
                    sb.append("YES").append("\n");
                else
                    sb.append("NO").append("\n");

                sb.append("\n");
            }
            System.out.print(sb);
        }
}
