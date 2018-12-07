package com.gfg.string;
/*
Given a string S, check if it is palindrome or not.

Input:
The first line contains 'T' denoting the number of test cases. T testcases follow. Each testcase
contains two lines of input. The first line contains the length of the string and the second line
contains the string S.

Output:
For each testcase, in a new line, print "Yes" if it is a palindrome else "No". (Without the double quotes)

Constraints:
1 <= T <= 30
1 <= N <= 100

Example:
Input:
1
4
abba
Output:
Yes
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Palindrome_String {
  public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringBuilder sb = new StringBuilder();
          int t = Integer.parseInt(br.readLine());
          String  s;
          String ans="Yes";
          int n=0;
          while(t-->0)
          {
              n=Integer.parseInt(br.readLine());
              s=br.readLine();
              ans="Yes";
              int l=0,r=n-1;
              while(l<=r){
                  if(s.charAt(l)!=s.charAt(r)){
                      ans="No";
                      break;
                  }
                  l++;r--;
              }
              sb.append(ans).append("\n");
          }
          System.out.print(sb);
      }
}
