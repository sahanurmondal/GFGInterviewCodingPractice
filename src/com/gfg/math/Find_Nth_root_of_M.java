package com.gfg.math;

/*
You are given 2 numbers (N , M); the task is to find N√M (Nth root of M).

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
 Each test case contains two space separated integers N and M.

Output:
For each test case, in a new line, print an integer denoting Nth root of M if the root is an integer else
print -1.

Constraints:
1 <= T <= 200
2 <= N <= 20
1 <= M <= 109+5

Example:
Input:
2
2 9
3 9
Output:
3
-1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Find_Nth_root_of_M {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long ans=0;
        long x=0,y=0;
        StringTokenizer tk;

        while(t-->0)
        {
            ans=-1;
            tk = new StringTokenizer(br.readLine());
            x= Long.parseLong(tk.nextToken());
            y= Long.parseLong(tk.nextToken());

            for (int i = 0; i <=Math.sqrt(x) ; i++) {
                if ((long)Math.pow(i,y)==x){
                    ans=i;
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
