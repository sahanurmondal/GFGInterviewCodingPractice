package com.gfg.math;

/*
Given a positive integer N, calculate the sum of all prime numbers between 1 and N(inclusive).

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow.
Each testcase contains one line of input containing N.

Output:
For each testcase, in a new line, print the sum of all prime numbers between 1 and N.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106

Example:
Input:
2
5
10
Output:
10
17
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sum_of_all_prime_numbers_between_1_and_N {
    public static void main(String[] args) throws IOException {
        // Using BufferedReader class to take input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long sum=0;
        int n=0,k=1;
        int prev=0;
        long[] arr=new long[1000000];
        arr[0]=1;
        // final int x;
        while(t>0)
        {
            n = Integer.parseInt(br.readLine());
            sum=0;
            final int x=n;
            if(n>prev) {
                for (long i = arr[k-1]+1; i <= n; i++)
                    if (prime(i))
                        arr[k++]= i;
                // System.out.println(sum);

                prev=n;
            }

            //sb.append(Arrays.stream(arr).filter(i-> i<=x).sum()-1 + "\n");
            sb.append(Arrays.stream(arr).filter(i-> i<=x).reduce(0L, Long::sum)-1 + "\n");
            t--;
        }
        System.out.println(sb);
    }


    static boolean prime(long m)
    {
        if(m<2)
            return false;
        for(long i=2;i<=Math.sqrt(m);i++)
            if(m%i==0)
                return false;
        return true;
    }
}
