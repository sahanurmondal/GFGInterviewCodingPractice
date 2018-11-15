package com.gfg.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Count_possible_triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        //int i,j,k;
        long c;
        //long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            tk = new StringTokenizer(br.readLine());
            arr=new int[n];
            for (int x = 0; x <n ; x++) {
                arr[x]= Integer.parseInt(tk.nextToken());
            }
            Arrays.sort(arr);
            //i=0;j=0;k=0;
            c=0;
            for (int i = 0; i < n-2; i++) {
                int k = i+2;
                for (int j = i+1; j < n; j++) {
                    while (k < n && arr[i]+arr[j] > arr[k]) {
                        ++k;
                    }
                    c += (k-j-1);
                }
            }
            //sb.append(binomialCoefficient(n,3)-c).append("\n");
            sb.append(c).append("\n");
        }
        System.out.print(sb);
    }
}
