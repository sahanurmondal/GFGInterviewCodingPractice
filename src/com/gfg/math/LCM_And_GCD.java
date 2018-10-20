package com.gfg.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCM_And_GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int n=0;
        long a=0,b=0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            a= Long.parseLong(tk.nextToken());
            b= Long.parseLong(tk.nextToken());
            sb.append(a*b/GCD(a,b)).append(" "+ GCD(a,b)).append("\n");
        }
        System.out.print(sb);
    }

    static long GCD(long a, long b){
        a = Math.abs(a); b = Math.abs(b);
        return (b==0) ? a : GCD(b, a%b);
    }
}
