package com.gfg.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Add_two_fractions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int n=0;
        int a=0,b=0,c=0,d=0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            a= Integer.parseInt(tk.nextToken());
            b= Integer.parseInt(tk.nextToken());
            c= Integer.parseInt(tk.nextToken());
            d= Integer.parseInt(tk.nextToken());
            addFraction(a,b,c,d);

            //sb.append("$").append("\n");
        }
        //System.out.print(sb);
    }

    static void addFraction(int num1, int den1, int num2, int den2)
    {
        int num3=(den1==den2? (num1+num2):((num1*den2)+(num2*den1)));
        int den3=(den1==den2? den1:(den1*den2));
        int gcd=GCD(num3,den3);
        if (gcd!=1) {
            den3 /= gcd;
            num3 /= gcd;
        }
        System.out.println(num3+"/"+den3);
    }
    static int GCD(int a, int b){
        a = Math.abs(a); b = Math.abs(b);
        return (b==0) ? a : GCD(b, a%b);
    }
}
