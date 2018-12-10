package com.gfg.string;
/*
Given a string S consisting of lowercase Latin Letters. Find the first non repeating character in S.

Input:
The first line contains T denoting the number of testcases. Then follows description of testcases.
Each case begins with a single integer N denoting the length of string. The next line contains the string S.

Output:
For each testcase, print the first non repeating character present in string. Print -1 if there is no non
repeating character.

Constraints:
1 <= T <= 900
1 <= N <= 104

Example:
Input :
3
5
hello
12
zxvczbtxyzvy
6
xxyyzz

Output :
h
c
-1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Non_Repeating_Character {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s;
            String alpha="abcdefghijklmnopqrstuvwxyz";
            String n;
            while(t-->0)
            {
                n=br.readLine();
                s=br.readLine();
                int[] arr=new int[26];
                char ch='-';
                int min=Integer.MAX_VALUE;
                for(int i=0;i<s.length();i++){
                    arr[s.charAt(i)-'a']++;

                }
                for (int i = 0; i <26 ; i++) {
                    if (arr[i]==1){
                        ch=alpha.charAt(i);
                        if(s.indexOf(ch)<min)
                            min=s.indexOf(ch);

                    }
                }
                if (ch=='-')
                    sb.append(-1).append("\n");
                else
                    sb.append(s.charAt(min)).append("\n");
            }
            System.out.print(sb);
        }
}
