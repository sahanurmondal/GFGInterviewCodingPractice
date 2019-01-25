package com.gfg.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
Given an array of positive integers which can contain integers from 1 to N where elements can be repeated or
can be absent from the array. Your task is to count frequency of all elements from 1 to N.

Note: Expected time complexity is O(n) with O(1) extra space.

Input:
First line of input contains an integer T denoting the number of test cases. For each test case, first line
contains an integer N denoting the size of array. The second line contains N space-separated integers
A1, A2, ..., AN denoting the elements of the array.

Output:
For each test case, output N space-separated integers denoting the frequency of each element from 1 to N.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 10^6
1 <= A[i] <= 10^6

Example:
Input:
2
5
2 3 2 3 5
4
3 3 3 3

Output:
0 2 2 0 1
0 0 4 0
 */
public class Frequency_of_Array_Elements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,x=0;
        // long x=0,y=0;
        StringTokenizer tk;
        //int[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            Map<Integer,Integer> m= new HashMap<Integer,Integer>();
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                x=Integer.parseInt(tk.nextToken());
                if(!m.containsKey(x)){
                    m.put(x,1);
                }else
                    m.put(x,m.get(x)+1);

            }
            for (int i = 1; i <=n ; i++) {
                if (m.containsKey(i) )
                    sb.append(m.get(i)).append(" ");
                else
                    sb.append(0).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
