package com.gfg.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tower_of_Hanoi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        //StringTokenizer tk;
       // int[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            towerOfHanoi(n,1,2,3);
            System.out.print((int)Math.pow(2,n)-1);
        }
        //System.out.print(sb);
    }

    static void towerOfHanoi(int n, int from_rod, int to_rod, int aux_rod)
    {
        if (n == 1)
        {
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }
}
