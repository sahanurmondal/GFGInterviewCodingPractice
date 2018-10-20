package com.gfg.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Print_the_Kth_Digit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int i=0,a=0,b=0,n=0;
        String s;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            a= Integer.parseInt(tk.nextToken());
            b= Integer.parseInt(tk.nextToken());
            n = Integer.parseInt(tk.nextToken());
            s=Long.toString((long) Math.pow(a,b));
             if(n<= s.length()){
                 sb.append(s.charAt(s.length()-n)).append("\n");
             }else
                 sb.append(0).append("\n");


        }
        System.out.print(sb);
    }

}
