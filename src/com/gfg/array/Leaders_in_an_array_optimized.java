package com.gfg.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Leaders_in_an_array_optimized {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        int[] arr;
        int right_i;
        StringTokenizer tk;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            tk = new StringTokenizer(br.readLine());
            arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }
           // arr = Stream.of(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            right_i=n-1;
            for (int i = n-2; i >=0 ; i--) {
                if(arr[i]>=arr[right_i]){
                    right_i=i;
                }else
                    arr[i]=0;
            }
            for (int i =0; i <n ; i++)
                if (arr[i]!=0)
                sb.append(arr[i]).append(" ");

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
