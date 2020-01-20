package com.gfg.string;
/*
Given a string S. The task is to find the first repeated character in it. We need to find the character
 that occurs more than once and whose index of first occurrence is smallest. S contains only lowercase letters.
Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each
 test case contains a string S.

Output:
For each test case in a new line print the first repeating character in the string. If no such character exist
print -1.

Constraints:
1 <= T <= 100
1 <= |S| <=104

Example:
Input:
2
geeksforgeeks
hellogeeks

Output:
e
l
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Find_first_repeated_character {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s;
            while(t-->0)
            {

                s=br.readLine();
                int[] arr=new int[26];
                char ch='-';
                for(int i=0;i<s.length();i++){
                    arr[s.charAt(i)-'a']++;
                    if(arr[s.charAt(i)-'a']>1){
                        ch=s.charAt(i);
                        break;
                    }
                }

                if (ch=='-')
                    sb.append(-1).append("\n");
                else
                    sb.append(ch).append("\n");
            }
            System.out.print(sb);
        }
}
