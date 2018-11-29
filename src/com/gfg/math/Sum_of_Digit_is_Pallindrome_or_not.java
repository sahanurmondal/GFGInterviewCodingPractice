package com.gfg.math;
/*
Write a program to check if the sum of digits of a given number N is a palindrome number or not.

Input:
The first line of the input contains T denoting the number of testcases. T testcases follow.
Then each of the T lines contains single positive integer N denoting the value of number.

Output:
For each testcase, in a new line, output "YES" if pallindrome else "NO". (without the quotes)

Constraints:
1 <= T <= 200
1 <= N <= 1000

Example:
Input:
2
56
98
Output:
YES
NO
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum_of_Digit_is_Pallindrome_or_not {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,sum=0;
        while(t-->0)
        {
            sum=0;
            n=Integer.parseInt(br.readLine());
            while(n>0) {
                sum += n % 10;
                n /= 10;
            }
            sb.append(checkPalindrom(Integer.toString(sum))).append("\n");
        }
        System.out.print(sb);
    }

    static String checkPalindrom(String s){
        String res="YES";
        if(s.length()!=1){
            int i=0, j=s.length() -1;
            while (i++<=j--){
                if(s.charAt(i)!=s.charAt(j)){
                    res="NO";
                    break;
                }
            }
        }
        return res;
    }



}
