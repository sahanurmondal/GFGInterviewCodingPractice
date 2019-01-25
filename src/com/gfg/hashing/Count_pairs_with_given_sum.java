package com.gfg.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
Given an array of integers, and an integer  ‘K’ , find the count of pairs of elements in the array whose
sum is equal to 'K'.

Input:
First line of the input contains an integer T, denoting the number of test cases. Then T test cases follow.
Each test case consists of two lines. First line of each test case contains 2 space separated integers N and
K denoting the size of array and the sum respectively. Second line of each test case contains N space separated
integers denoting the elements of the array.

Output:
Print the count of pairs of elements in the array whose sum is equal to the K.

Constraints:
1<=T<=50
1<=N<=50
1<=K<=50
1<=A[i]<=100

Example:
Input
2
4 6
1  5  7 1
4 2
1 1 1 1
Output
2
6
 */
public class Count_pairs_with_given_sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,k=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            n=Integer.parseInt(tk.nextToken());
            k=Integer.parseInt(tk.nextToken());
            Map<Integer,Integer> m= new HashMap<Integer,Integer>();
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
                if(!m.containsKey(arr[i]))
                    m.put(arr[i],0);
                m.put(arr[i],m.get(arr[i])+1);
            }
            int twice_count = 0;

            // iterate through each element and increment the
            // count (Notice that every pair is counted twice)
            for (int i=0; i<n; i++)
            {
                if(m.get(k-arr[i]) != null)
                    twice_count += m.get(k-arr[i]);

                // if (arr[i], arr[i]) pair satisfies the condition,
                // then we need to ensure that the count is
                // decreased by one such that the (arr[i], arr[i])
                // pair is not considered
                if (k-arr[i] == arr[i])
                    twice_count--;
            }
            sb.append(twice_count/2).append("\n");
        }
        System.out.print(sb);
    }
}
