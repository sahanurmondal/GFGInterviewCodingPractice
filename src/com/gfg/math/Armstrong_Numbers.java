package com.gfg.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Armstrong_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int n=0,r=0,armStrong=0,temp=0;
        StringBuilder sb = new StringBuilder();
        while(t-->0)
        {
            armStrong=0;
            n=Integer.parseInt(br.readLine());
            temp=n;
            while(n>0){
              r=n%10;
              n/=10;
              armStrong+=r*r*r;
          }
          if(armStrong==temp)
              sb.append("YES").append("\n");
          else
              sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}
