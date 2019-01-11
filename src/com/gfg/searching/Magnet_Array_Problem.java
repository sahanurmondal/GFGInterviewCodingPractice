package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.StringTokenizer;

/*
Given n Magnets which are placed linearly, with each magnet to be considered as of point object. Each magnet
suffers force from its left sided magnets such that they repel it to the right and vice versa. All forces are
repulsive. The force being equal to the distance (1/d , d being the distance). Now given the positions of the
magnets, the task to find all the points along the linear line where net force is ZERO.

Note: Distance have to be calculated with precision of 0.0000000000001.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
The second line of each test case contains an integer N. Then in the next line are N space separated values
of the array M[], denoting the positions of the magnet.

Output:
For each test case in a new line print the space separated points having net force zero till precised two
decimal places.

Constraints:
1<=T<=100
1<=N<=100
1<=M[]<=1000

Example:
Input:
2
2
1 2
4
0 10 20 30
Output:
1.50
3.82 15.00 26.18
 */
public class Magnet_Array_Problem {
   // private static Formatter fmt = new Formatter();
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

            for (int i = 1; i < n; i++) {
                double l=0,r=0,mid=0;
                l = arr[i-1];
                r =arr[i];
                boolean flag=true;
                while (flag) {
                     double ans=0;
                     mid=(l+r)/2;
                    for (int j = 0; j < n; j++) {
                        ans+=1/(mid -arr[j]);
                    }
                    if(Math.abs(ans)<0.0000000000001)
                        flag=false;
                    else if(ans>0)
                        l=mid;
                    else
                        r=mid;
                }
                //fmt.format("%.2f",mid);
                sb.append(String.format("%.2f",mid)).append(" ");
            }
            sb.append("").append("\n");
        }
        System.out.print(sb);
    }
}
