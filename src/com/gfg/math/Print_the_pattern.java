package com.gfg.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Print_the_pattern {

    static void printPat(int n)
    {
        int i=n,j=0;
        StringBuilder sb = new StringBuilder();
        while(i>0){

            for(j=n;j>0;j--){
                sb.append(new String(new char[i]).
                        replace("\0", String.valueOf(j)+" "));
            }
            sb.append("$");
            i--;

        }
        System.out.print(sb);  }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            printPat(Integer.parseInt(br.readLine()));
        }
    }
}
