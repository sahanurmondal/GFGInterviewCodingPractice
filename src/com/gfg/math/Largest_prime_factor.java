package com.gfg.math;

/*
Given a number N, the task is to find the largest prime factor of that number.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow.
Each test case contains an integer N.

Output:
For each test case, in a new line, print the largest prime factor of N.

Constraints:
1 <= T <= 100
2 <= N <= 1010

Example:
Input:
2
6
15
Output:
3
5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Largest_prime_factor {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            long maxPrime = -1;
            long n=0;
            while(t-->0)
            {
                n=Long.parseLong(br.readLine());
                maxPrime = -1;

                // Print the number of 2s
                // that divide n
                while (n % 2 == 0) {
                    maxPrime = 2;

                    // equivalent to n /= 2
                    n >>= 1;
                }

                // n must be odd at this point,
                // thus skip the even numbers
                // and iterate only for odd
                // integers
                for (int i = 3; i <= Math.sqrt(n); i += 2) {
                    while (n % i == 0) {
                        maxPrime = i;
                        n = n / i;
                    }
                }

                // This condition is to handle
                // the case when n is a prime
                // number greater than 2
                if (n > 2)
                    maxPrime = n;

                sb.append(maxPrime).append("\n");
            }
            System.out.print(sb);
        }
}
