package com.gfg.math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse_digits {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            int n=0,r=0,rev=0,base=10;
            while(t-->0)
            {
                rev=0;
                n=Integer.parseInt(br.readLine());
                while(n>0){
                    r=n%10;
                    n/=10;
                    rev=rev*base+r;
                }
                sb.append(rev).append("\n");
            }
            System.out.print(sb);
        }
}
