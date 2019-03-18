package com.gfg.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given a number N, let the reverse of the number be R. The task is to print the output of the Expression pow(N,R),
where pow function represents N raised to power R.
Note: As answers can be very large, print the result modulo 1000000007.

Input:
The first line of the input consists of an integer T denoting the number of test cases. Then T test cases follow.
Each test case consists of a single line containing an integer N.

Output:
Corresponding to each test case, print in a new line, the output of the expression pow as described above.

Constraints:
1 <= T <= 103
1 <= N <= 105

Example:
Input:
2
2
12

Output:
4
864354781

Explanation:
Testcase 1: The reverse of 2 is 2 and after raising power of 2 by 2 we get 4 which gives remainder as 4 by
 dividing 1000000007.
 */
public class Power_of_Numbers {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            int  n = 0;
            while(t-->0)
            {
                n=Integer.parseInt(br.readLine());
                sb.append(power(n,Integer.parseInt(new StringBuilder(String.valueOf(n))
                        .reverse().toString()))).append("\n");
            }
            System.out.print(sb);
        }
    static long power(int x, int y)
    {
        if (y == 0)
            return 1;
        long temp = power(x, y / 2);
        if (y%2 == 0)
            return (temp*temp)%1000000007;
        else
        {
                return (x*((temp*temp)%1000000007))%1000000007;
        }
    }
}
