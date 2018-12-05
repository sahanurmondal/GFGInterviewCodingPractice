package com.gfg.array;
/*
The cost of stock on each day is given in an array A. Find all the days on which you buy and
sell the stock so that in between those days you shouldn't have any loss.

Input:
First line contains number of test cases T. Each test case contains the integer value N denoting days
followed by an array of stock prices of N days.

Output:
For each testcase, output all the days with profit in a single line. And if there is no profit then print
"No Profit".

Constraints:
1 <= T <= 100
2 <= N <= 103
1 <= Ai <= 104

Example
Input:
2
7
100 180 260 310 40 535 695
10
23 13 25 29 33 19 34 45 65 67

Output:
(0 3) (4 6)
(1 4) (5 9)

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stock_buy_and_sell {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }
            int min=arr[0],max=arr[0],i=0,j=0,k=1;
            boolean flag=true;
            while (k<n){
                if(min>arr[k]){
                    min=arr[k];
                    max=min;
                    i=k;
                }else if(max<arr[k]){
                    max=arr[k];
                    j=k;
                }

                if(k<n-1 && max>arr[k+1] && j>i){
                    sb.append("(" +i+" "+j+")").append(" ");
                    max=arr[k];
                    min=arr[k];
                    i=j=k;
                    flag=false;

                }
                k++;
            }
            if(j>i)
                sb.append("(" +i+" "+j+")").append(" ");
            else{
                if(flag)
                    sb.append("No Profit");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
