package com.gfg.divide_conquer;
/*
Given two binary strings that represent value of two integers, find the product of two strings.
For example, if the first bit string is “1100” and second bit string is “1010”, output should be 120.

Input:
First line consists of T test cases. Only line of every test case consists of 2 binary strings.

Output:
Single line output, print the multiplied value.

Constraints:
1<=T<=100
1<=Length of string<=100

Example:
Input:
2
1100 01
01 01
Output:
12
1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Karatsuba_Algorithm {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s1,s2;
            StringTokenizer tk;
            while(t-->0)
            {
                tk = new StringTokenizer(br.readLine());
                s1=tk.nextToken();
                s2=tk.nextToken();
                sb.append(multiply(s1,s2)).append("\n");
            }
            System.out.print(sb);
        }

    private static int multiply(String num1, String num2) {
        int n1= num1.length();
        int n2= num2.length();
        if( n1> n2)
            num2 = new String(new char[n1 - n2]).replace("\0", "0")+num2;
        else
            num1 = new String(new char[n2 - n1]).replace("\0", "0")+num1;

        if (num1.length()==1 || num2.length()==1 || !num1.contains("1") || !num2.contains("1")) {
            return Integer.parseInt(num1,2) * Integer.parseInt(num2,2) ;
        }

        /* calculates the size of the numbers */
        int m = num1.length();
        int m2 =m/2;

        /* split the digit sequences in the middle */
        String high1 =num1.substring(0,m2) , low1 = num1.substring(m2);
        String high2 =num2.substring(0,m2) , low2 = num2.substring(m2);

        /* 3 calls made to numbers approximately half the size */
        int z0 = multiply(low1, low2);
        int z1 = multiply(sumBinaryString(low1 , high1), sumBinaryString(low2 , high2));
        int z2 = multiply(high1, high2);

        return z2 * (1<<(2*(m-m2))) + (z1 - z2 - z0) *(1<<(m-m2))+ z0;
    }

    public static String sumBinaryString(String b1, String b2) {
        int len1 = b1.length();
        int len2 = b2.length();
        int carry = 0; String res = "";
        int maxLen = Math.max(len1, len2);
        for (int i = 0; i < maxLen; i++) {
            int p = i < len1 ? b1.charAt(len1 - 1 - i) - '0' : 0;
            int q = i < len2 ? b2.charAt(len2 - 1 - i) - '0' : 0;
            int tmp = p + q + carry; carry = tmp / 2;
            res = tmp % 2 + res;
        }
            return (carry == 0) ? res : "1" + res;
    }


}
