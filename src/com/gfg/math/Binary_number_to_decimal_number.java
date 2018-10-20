package com.gfg.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Binary_number_to_decimal_number {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int i=0,sum=0;
        long a=0,base=1;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        while(t-->0)
        {
            sum=0;
            base=1;
            tk = new StringTokenizer(br.readLine());
            a= Long.parseLong(tk.nextToken());

            while(a>0) {
                sum += (a % 10)*base;
                a /= 10;
                base*=2;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
