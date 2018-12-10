package com.gfg.string;
/*
Given strings s1 and s2, you need to find if s2 is a rotated version of the string s1. The strings are lowercase.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. Then T test case
follows. Each testcase contains two lines for s1 and s2.

Output:
For each testcase, in a new line, you need to print 1 if s2 is a rotated version of s1; else print 0.

Constraints:
1 <= T <= 100
1 <= |s1|,|s2| <= 100

Example:
Input:
4
geeksforgeeks
forgeeksgeeks
mightandmagic
andmagicmigth
mushroomkingdom
itsamemario
geekofgeeks
geeksgeekof
Output:
1
0
0
1

Explanation:
Ttestcase 1: s1 is geeksforgeeks, s2 is forgeeksgeeks. Clearly, s2 is a rotated version of s1 as s2 can
be obtained by left-rotating s1 by 5 units.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Check_if_strings_are_rotations_of_each_other_or_not {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  a,b;
            while(t-->0)
            {
                a=br.readLine();
                b=br.readLine();
                if(a.length()==b.length() && (a+a).indexOf(b)!=-1){
                    sb.append("1");
                }
                else{
                    sb.append("0");
                }

                sb.append("\n");
            }
            System.out.print(sb);
        }
}
