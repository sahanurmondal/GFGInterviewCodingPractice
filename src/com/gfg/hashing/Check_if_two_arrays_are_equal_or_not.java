package com.gfg.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not. Two arrays are
said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be
different though.
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.  Each test
case contains 3 lines of input. The first line contains an integer N denoting the size of the array. The second
line contains element of array A[]. The third line contains elements of the array B[].

Output:
For each test case, print 1 if the arrays are equal else print 0.

Constraints:
1<=T<=100
1<=N<=10^7
1<=A[],B[]<=10^18

Example:
Input:
2
5
1 2 5 4 0
2 4 5 0 1
3
1 2 5
2 4 15
Output:
1
0

Explanation:
Testcase1:
Input : A[] = {1, 2, 5, 4, 0}; B[] = {2, 4, 5, 0, 1};
Output : 1
Testcase2:
Input : A[] = {1, 2, 5}; B[] = {2, 4, 15};
Output : 0
 */
public class Check_if_two_arrays_are_equal_or_not {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;long x=0;
        // long x=0,y=0;
        StringTokenizer tk,tk1;
        // int[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            Map<Long,Integer> m= new HashMap<Long,Integer>();
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                x = Long.parseLong(tk.nextToken());
                if (!m.containsKey(x)) {
                    m.put(x, 1);
                } else
                    m.put(x, m.get(x) + 1);
            }
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                x=Long.parseLong(tk.nextToken());
                if(!m.containsKey(x)){
                    m.put(x,1);
                }else
                    m.put(x,m.get(x)-1);
            }
            int ans=1;
            for (long i :m.keySet()) {
                if(m.get(i)!=0){
                    ans=0;
                    break;
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
