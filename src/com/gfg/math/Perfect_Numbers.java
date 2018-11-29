package com.gfg.math;

/*
Given a number N, check if a number is perfect or not. A number is said to be perfect if sum of all its
 factors excluding the number itself is equal to the number.

Input:
First line consists of T test cases. Then T test cases follow .Each test case consists of a number N.

Output:
For each testcase, in a new line, output in a single line 1 if a number is a perfect number else print 0.

Constraints:
1 <= T <= 300
1 <= N <= 104

Example:
Input:
2
6
21
Output:
1
0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Perfect_Numbers {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            long n=0;
            //long x=0,y=0;
           // StringTokenizer tk;
            boolean flag=true;
            long temp=0,sum=1;
            while(t-->0)
            {
                n=Long.parseLong(br.readLine());
                temp=n;

                while (n % 2 == 0) {
                    if(flag)
                    sum+=2;

                    // equivalent to n /= 2
                    n >>= 1;
                    flag=false;
                }
                flag=true;
                for (long i = 3; i <= Math.sqrt(n); i += 2) {
                    while (n % i == 0) {
                        if(flag)
                            sum+=i;
                        n = n / i;
                        flag=false;
                    }
                    flag=true;
                }

                if (n > 2 && n!=temp)
                    sum+=n;


                if(sum==temp)
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            System.out.print(sb);
        }
}
