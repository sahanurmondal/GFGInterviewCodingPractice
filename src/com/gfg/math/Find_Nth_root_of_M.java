package com.gfg.math;

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
