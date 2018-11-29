package com.gfg.math;

/*
Print the table of a given number N upto 10.

Input:
First line contains an integer, the number of test cases 'T'. T testcases follow. Each testcase cotains one line of input denoting N.

Output:
For each testcase, print the table of N upto 10.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
1
9

Output:
9 18 27 36 45 54 63 72 81 90
 */
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
