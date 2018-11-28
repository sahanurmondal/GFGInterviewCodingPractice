package com.gfg.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Leaders_in_an_array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        //int x=0;
       // StringTokenizer tk;
        Stack<Integer> st;
       // int tmp=Integer.MIN_VALUE;
        int[] arr;
       // int y=0;
        int right_i;
        while(t-->0)
        {
            st= new Stack<Integer>();
            n=Integer.parseInt(br.readLine());
            arr = Stream.of(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            //sb.append(arr[n-1]).append(" ");
            st.push(arr[n-1]);
            right_i=n-1;
            for (int i = n-2; i >=0 ; i--) {
                 if(arr[i]>=arr[right_i]){
                     right_i=i;
                     st.push(arr[i]);
                 }
            }
            while (!st.empty())
                sb.append(st.pop()).append(" ");
            /*for (int i = 0; i < n; i++) {

                x= Integer.parseInt(tk.nextToken());
                if(st.empty())
                    st.push(x);
                else{
                    while(!st.empty() && st.peek()<x){
                        st.pop();
                    }
                    st.push(x);
                }
            }
            y=st.size();
            arr=new int[y];
            int j=0;
            while (!st.empty())
                arr[j++]=st.pop();
            for (int i = y-1; i >= 0; i--) {
                sb.append(arr[i]).append(" ");
            }*/

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
