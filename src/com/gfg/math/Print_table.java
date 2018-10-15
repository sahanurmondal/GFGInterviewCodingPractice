package com.gfg.math;

import java.util.Scanner;

public class Print_table {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int temp=1;
            StringBuilder sb = new StringBuilder();
            while(temp<11){
                sb.append(n*temp + " ");
                temp++;
            }
            System.out.println(sb);
            t--;
        }
    }
}
