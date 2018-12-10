package com.gfg.string;
/*
You have been given an alphanumeric string S, extract maximum numeric value from that string. Alphabets will
only be in lower case.

Input:
The first line contains a single integer T i.e. the number of test cases. T testcases follow.
The first and only line consists of a String S.

Output:
For each testcase, in a new line, print the Maximum number extracted from the string S.

Constraints:
1 <= T <= 100
2 <= |S| <= 200

Example:
Input:
3
100klh564abc365bg
abvhd9sdnkjdfs
abchsd0sdhs
Output:
564
9
0

Explanation:
Test Case 1: The maximum number found in the string is "564".
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Extract_Maximum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String  s;
        String num="0123456789";
        while(t-->0)
        {
            long max=0,temp=0;
            s=br.readLine();
            int k=0;
            while (k<s.length()-1){
                if(num.indexOf(s.charAt(k))>=0){
                    if(num.indexOf(s.charAt(k+1))>=0){
                        temp+=s.charAt(k)-48;
                        temp*=10;
                    }else{
                        temp+=s.charAt(k)-48;
                        if(max<temp)
                            max=temp;
                        temp=0;
                    }
                }
                k++;
            }
            if(num.indexOf(s.charAt(k))>=0){
                temp+=s.charAt(k)-48;
                if(max<temp)
                    max=temp;
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}
