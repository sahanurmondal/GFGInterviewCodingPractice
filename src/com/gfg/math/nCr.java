package com.gfg.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nCr {

    static int MOD=1000000000+7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int a=0,b=0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            a= Integer.parseInt(tk.nextToken());
            b= Integer.parseInt(tk.nextToken());
            sb.append(binomialCoefficient(a,b)).append("\n");
        }
        System.out.print(sb);
    }
    public static int binomialCoefficient(int n,int k){
        int[][] nCk=new int[n+1][k+1];
        for(int N=0;N<=n;++N)
            for(int K=0;K<=min(N,k);++K)
                nCk[N][K]=(K==0||N==K)?1:(nCk[N-1][K]%MOD+nCk[N-1][K-1]%MOD)%MOD;

        return nCk[n][k];
    }
    public static int min(int a,int b){
        return Math.min(a,b);
    }

}
