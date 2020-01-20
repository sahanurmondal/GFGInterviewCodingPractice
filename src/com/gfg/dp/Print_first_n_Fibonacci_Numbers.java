package com.gfg.dp;
/*
Given a number n print the first n fibonacci numbers.

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
The first line of each test case contains the integer N.

Output:

Print the first n fibonacci numbers with a space between each number. Print the answer for each test case in a
new line.


Constraints:

1<= T <=100

1<= N <=100


Example:

Input:

1

7

Output:

1 1 2 3 5 8 13
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Print_first_n_Fibonacci_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        long[] arr=new long[100];
        arr[0]=arr[1]=1;
        int i=2;
        while(i<100){
            arr[i]=arr[i-1]+arr[i-2];
            i++;
        }
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            for (int j = 0; j <n ; j++) {
                sb.append(arr[j]).append(" ");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
