package com.gfg.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Series_AP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int x=0,y=0,n=0;
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            x= Integer.parseInt(tk.nextToken());
            y= Integer.parseInt(tk.nextToken());
            n=Integer.parseInt(br.readLine());

            sb.append(x+(y-x)*(n-1)).append("\n");

        }
        System.out.println(sb);
    }
}
