package com.gfg.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
Given an array of words, print the count of all anagrams together in sorted order (increasing order of counts).
For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, then grouped anagrams are “(dog, god)
(cat, tac, act)”. So the output will be 2 3.

Input:
First line consists of T test case. First line of every test case consists of N, denoting the number of words
in array. Second line of every test case consists of words of array.

Output:
Single line output, print the counts of anagrams in increasing order.

Constraints:
1<=T<=100
1<=N<=50

Example:
Input:
2
5
act cat tac god dog
3
act cat tac
Output:
2 3
3
 */
public class Group_Anagrams_Together {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        char[] arr;
        String s;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            Map<String,Integer> m= new HashMap<String,Integer>();
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr=tk.nextToken().toCharArray();
                Arrays.sort(arr);
                s=Arrays.toString(arr);
                if(m.containsKey(s))
                    m.put(s,m.get(s)+1);
                else
                    m.put(s,1);

            }
            int[] a=new int[m.size()];
            int k=0;
            for (String s1:m.keySet()){
                a[k++]=m.get(s1);
            }
            Arrays.sort(a);
            for (int i = 0; i <m.size() ; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
