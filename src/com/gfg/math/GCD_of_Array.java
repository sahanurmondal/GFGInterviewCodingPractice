package com.gfg.math;

/*
Given an array of N positive integers. Your task is to find the GCD of all numbers of the array.

Input:
First line of input contains number of test cases T. First line of test case contains a positive integer N,
size of the array. Next line contains the array elements.

Output:
For each testcase, print the GCD of array elements.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= Arr[i] <= 106

Example:
Input:
1
2
5 10

Output:
5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD_of_Array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int n=0;
        long result=0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        String str="";
        while(t-->0)
        {
            str=br.readLine();
            if(str.contains(" ")){
                tk = new StringTokenizer(str);
                n=tk.countTokens();
            }else{
                n= Integer.parseInt(str);
                tk = new StringTokenizer(br.readLine());
            }


            // int[] arr=new int[n];
            result=Long.parseLong(tk.nextToken());
            n--;
            while (n-- > 0) {
                // arr[i++]=Integer.parseInt(tk.nextToken());
                result=GCD(result,Long.parseLong(tk.nextToken()));
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
    static long GCD(long a, long b){
        a = Math.abs(a); b = Math.abs(b);
        return (b==0) ? a : GCD(b, a%b);
    }
}
