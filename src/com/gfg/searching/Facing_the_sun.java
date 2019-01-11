package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Monu lives in a society which is having high rise buildings. This is the time of sunrise and monu wants see the
buildings receiving the sunlight. Help him in counting the number of buildings recieving the sunlight.
Given an array H representing heights of buildings. You have to count the buildings which will see the sunrise
(Assume : Sun rise on the side of array starting point).

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test
case is N, N is the number of buildings. The second line of each test case contains N input H[i], height of
ith building.

Output:
Print the total number of buildings which will see the sunset.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 ≤ Hi ≤ 108

Example:
Input:
2
5
7 4 8 2 9
4
2 3 4 5

Output:
3
4
 */
public class Facing_the_sun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        int c=0;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }
            c=1;
            int max=arr[0];
            if(n>1){
                for (int i = 1; i <n ; i++) {
                    if(max<arr[i]){
                        max=arr[i];
                        c++;
                    }
                }
            }
            sb.append(c).append("\n");
        }
        System.out.print(sb);
    }
}
