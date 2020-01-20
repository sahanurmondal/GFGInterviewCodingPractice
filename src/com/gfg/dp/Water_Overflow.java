package com.gfg.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
There is a stack of water glasses in a form of pascal triangle and a person wants to pour the water at the topmost
glass, but the capacity of each glass is 1 unit . Overflow takes place in such a way that after 1 unit, 1/2 of
remaining unit gets into bottom left glass and other half in bottom right glass.

Now the pours K units of water in the topmost glass and wants to know how much water is there in the jth glass
of the ith row.

Assume that there are enough glasses in the triangle till no glass overflows.

Input:   First line of the input contains an integer T denoting the number of test cases and each test case
consists of three lines. First line contain an integer K, second line contains an integer i and third line
contains an integer j.


Output: Corresponding to each test case output the remaining amount of water in jth cup of the ith row correct
to 6 decimal places.


Constraints:

T<=20
K<=1000
i <= K
j<= K

Example:
Input:

1
3
2
1

Output:
1
 */
public class Water_Overflow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        double k=0;
        int i=0,j=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            k=Double.parseDouble(br.readLine());
            i=Integer.parseInt(br.readLine());
            j=Integer.parseInt(br.readLine());
            double[][] dp=new double[i+1][i+1];
            double temp=0;
            dp[0][0] = k;
            for (int l = 0; l <i ; l++) {
                for (int m = 0; m <=l ; m++) {
                    if(dp[l][m]>1) {
                        temp=dp[l][m];
                        dp[l][m] = 1;
                        temp=(temp-1);
                            dp[l + 1][m] += temp / 2;
                            dp[l + 1][m+1] += temp / 2;
                    }
                }
            }


            sb.append(dp[i-1][j-1]).append("\n");
        }
        System.out.print(sb);
    }
}
