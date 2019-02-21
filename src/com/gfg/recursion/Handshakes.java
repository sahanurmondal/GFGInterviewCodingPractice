package com.gfg.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
We have N persons sitting on a round table. Any person can do a handshake with any other person.

    1
2        3
    4
Handshake with 2-3 and 1-4 will cause cross.

In how many ways these N people can make handshakes so that no two handshakes crosses each other. N would be even.

For example, in above diagram, there are two non-crossing ways to handshake {{1, 2}, {3, 4}} and {{1, 3}, {2, 4}}.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N.

Output:

Print number of ways.

Constraints:

1 ≤ T ≤ 20
2 ≤ N ≤ 30

Example:

Input:
2
2
8

Output:
1
14
 */
public class Handshakes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        //int[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());

            //printPattern(n);
            System.out.println(shakeHands(n/2));
        }
        //  System.out.print(sb);
    }
    private static int shakeHands(int n){
        int sum=0;
        if(n==0)
            return 1;
        else {
            //int k=n;
            for (int i = 1; i <=n ; i++) {
                sum += shakeHands(n-i)*shakeHands(i-1);
            }

        }
        return sum;
    }
}
