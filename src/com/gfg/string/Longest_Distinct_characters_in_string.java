package com.gfg.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*
Given a string S, find length of the longest substring with all distinct characters.  For example,
for input "abca", the output is 3 as "abc" is the longest substring with all distinct characters.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is String str.

Output:
Print length of smallest substring with maximum number of distinct characters.
Note: The output substring should have all distinct characters.

Constraints:
1 ≤ T ≤ 100
1 ≤ size of str ≤ 10000

Example:
Input:
2
abababcdefababcdab
geeksforgeeks

Output:
6
7
 */
public class Longest_Distinct_characters_in_string {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s;
            while(t-->0)
            {
                ArrayList<Character>    arr=new  ArrayList<Character>();
                HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
                s=br.readLine();
                int max=1;
                arr.add(s.charAt(0));hm.put(s.charAt(0), 0);
                for (int i = 1; i < s.length(); i++) {
                    if (!arr.contains(s.charAt(i))){
                        arr.add(s.charAt(i));
                    hm.put(s.charAt(i), i);
                    }
                    else {

                        if(max<arr.size())
                            max=arr.size();
                        arr.clear();
                        int x=hm.get(s.charAt(i));
                        hm.clear();
                        for (int j = x+1; j <=i ; j++){
                               arr.add(s.charAt(j));
                               hm.put(s.charAt(j), j);
                        }
                    }
                }
                if(max<arr.size())
                    max=arr.size();
                sb.append(max).append("\n");
            }
            System.out.print(sb);
        }
}
