package com.gfg.recursion;
/*
Given a string S. The task is to print all permutations of a given string.

Input:
The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.

Output:
For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.

Constraints:
1 ≤ T ≤ 10
1 ≤ size of string ≤ 5

Example:
Input:
2
ABC
ABSG

Output:
ABC ACB BAC BCA CAB CBA
ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Permutations_of_a_given_string {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // taking input of number of testcase
            int t = Integer.parseInt(br.readLine());
           // int n=0;
            StringBuilder sb = new StringBuilder();
            //StringTokenizer tk;
            String s;
            while(t-->0)
            {
                s = br.readLine();
                Set<String> uniqueStrings = new HashSet<>();
                permutation(s,uniqueStrings);
                //permute(s.toCharArray(), 0, s.length()-1);
            }
            System.out.println();
        }

    public static void permutation(String str,Set<String> uniqueStrings) {
        permutation("", str,uniqueStrings);
    }

    private static void permutation(String prefix, String str,Set<String> set) {
        int n = str.length();
        if (n == 0) {
            if(!set.contains(prefix))
            {
                System.out.print(prefix +" ");
                set.add(prefix);
            }
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1),set);
        }
    }

    public static void permute(char[] ary, int startIndex, int endIndex) {
        if(startIndex == endIndex){
            System.out.print(String.valueOf(ary)+" ");
        }else{
            for(int i=startIndex;i<=endIndex;i++) {
                swap(ary, startIndex, i );
                permute(ary, startIndex+1, endIndex);
                swap(ary, startIndex, i );
            }
        }
    }

    public static void swap(char[] ary, int x, int y) {
        char temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }
}
