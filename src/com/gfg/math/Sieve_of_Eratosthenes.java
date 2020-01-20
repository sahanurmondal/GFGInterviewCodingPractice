package com.gfg.math;

/*
Given a number N, calculate the prime numbers upto N using Sieve of Eratosthenes.

Input:
The first line of the input contains T denoting the number of testcases. T testcases follow.
Each testcase contains one line of input containing N.

Output:
For all testcases, in a new line, print all the prime numbers upto or equal to N.

Constraints:
1 <= T<= 100
1 <= N <= 104

Example:
Input:
2
10
35
Output:
2 3 5 7
2 3 5 7 11 13 17 19 23 29 31
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Sieve_of_Eratosthenes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long n=0;
       // long x=0,y=0;
       // StringTokenizer tk;
        boolean sieve[] = new boolean[1000001];
        sieve[0] = sieve[1] = false;
        for(int i = 2; i <= 1000000; i++){
            sieve[i] = true;
        }
        for(int i = 2; i <= 1000; i++){
            if(sieve[i]){
                for(int j = i*i; j <= 1000000; j += i){
                    sieve[j] = false;
                }
            }
        }
        while(t-->0)
        {
            n=Long.parseLong(br.readLine());
            if (n==2)
                sb.append(2).append("\n");
            else if(n>2){
                sb.append(2).append(" ");
                for (int i = 3; i <= n; i += 2) {
                    if(sieve[i])
                        sb.append(i).append(" ");
                }


            }
            sb.append("").append("\n");
        }
        System.out.print(sb);
    }
}
