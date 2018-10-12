package com.gfg.math;

import java.util.Scanner;

public class Pairs_of_prime_number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Instant s=Instant.now();
        int t = sc.nextInt();
        StringBuilder sb = null;
        while(t>0)
        {
            sb = new StringBuilder();
            int n = sc.nextInt();
            int arr[]=new int[100];
            int k=0;
            for(int i=2;i<=n/2;i++)
                if(prime(i))
                    arr[k++]=i;
            for(int i=0;i<k;i++)
            {
                for(int j=0;j<k;j++)
                {
                    if(arr[i]*arr[j]>n)
                        break;
                    sb.append(arr[i]+" ").append(arr[j]+" ");

                }
            }
            System.out.println(sb);
            t--;
        }
        //Instant e=Instant.now();
        // System.out.println(Duration.between(s,e).toSeconds());
    }

    static boolean prime(int m)
    {
        if(m<2)
            return false;
        for(int i=2;i<=Math.sqrt(m);i++)
            if(m%i==0)
                return false;
        return true;
    }
}
