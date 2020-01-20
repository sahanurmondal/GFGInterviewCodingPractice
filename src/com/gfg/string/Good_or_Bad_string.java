package com.gfg.string;
/*
In this problem, a String S is composed of lowercase alphabets and wildcard characters i.e. '?'. Here, '?'
can be replaced by any of the lowercase alphabets. Now you have to classify the given String on the basis of
following rules:

If there are more than 3 consonants together or more than 5 vowels together, the String is considered to be "BAD"
. A String is considered "GOOD" only if it is not “BAD”.

NOTE: String is considered as "BAD" if the above condition is satisfied even once. Else it is "GOOD" and the task
 is to make the string "BAD".

Input:
The first line consists of an integer T i.e number of test cases. T testcases follow. The first and only line of
 each test case consists of a string S.

Output:
For each testcase, in a new line, print "1"  if string is GOOD, else print "0".

Constraints:
1 <= T <= 100
1 <= |S| <= 100

Example:
Input:
2
aeioup??
bcdaeiou??
Output:
1
0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Good_or_Bad_string {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String cons="bcdfghjklmnpqrstvwxyz";
        String vow="aeiou";
        String  s;
        while(t-->0)
        {
            int ans=1;
            int j=0,k=0;
            s=br.readLine();
            int n=s.length();
            for (int i = 0; i < n; i++) {
                if(cons.indexOf(s.charAt(i))>=0 || s.charAt(i)=='?'){
                    if(i!=n-1 && (cons.indexOf(s.charAt(i+1))>=0|| s.charAt(i+1)=='?')) {
                        j++;
                        continue;
                    }
                    if(j>2){
                        ans=0;
                        break;
                    }else
                        j=0;
                }else
                    j=0;

                if(vow.indexOf(s.charAt(i))>=0 || s.charAt(i)=='?'){
                    if(i!=n-1 && (cons.indexOf(s.charAt(i+1))>=0|| s.charAt(i+1)=='?')) {
                        k++;
                        continue;
                    }
                    if(k>4){
                        ans=0;
                        break;
                    }else
                        k=0;
                }else
                    k=0;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
