package com.gfg.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Perfect_Numbers {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            long n=0;
            //long x=0,y=0;
           // StringTokenizer tk;
            boolean flag=true;
            long temp=0,sum=1;
            while(t-->0)
            {
                n=Long.parseLong(br.readLine());
                temp=n;

                while (n % 2 == 0) {
                    if(flag)
                    sum+=2;

                    // equivalent to n /= 2
                    n >>= 1;
                    flag=false;
                }
                flag=true;
                for (long i = 3; i <= Math.sqrt(n); i += 2) {
                    while (n % i == 0) {
                        if(flag)
                            sum+=i;
                        n = n / i;
                        flag=false;
                    }
                    flag=true;
                }

                if (n > 2 && n!=temp)
                    sum+=n;


                if(sum==temp)
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            System.out.print(sb);
        }
}
