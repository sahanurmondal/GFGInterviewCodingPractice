package com.gfg.recursion;

/*
Given a string s, recursively remove adjacent duplicate characters from the string s. The output
string should not have any adjacent duplicates.


Input:
The first line of input contains an integer T, denoting the no of test cases. Then T test cases follow.
 Each test case contains a string str.

Output:
For each test case, print a new line containing the resulting string.

Constraints:
1<=T<=100
1<=Length of string<=50

Example:
Input:
2
geeksforgeek
acaaabbbacdddd

Output:
gksforgk
acac
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursively_remove_all_adjacent_duplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
       // int n=0;
        StringBuilder sb = new StringBuilder();
        //StringTokenizer tk;
        String s;
        while(t-->0)
        {
            s = br.readLine();

            sb.append(removeDuplicate(s)).append("\n");
        }
        System.out.print(sb);
    }

    private static String removeDuplicate(String input){
        String res="";
        if(input == null || input.length()<=1)
            return input;
        else{
            int i = 0;
            boolean flag = false;
            while (input.charAt(i) == input.charAt(i+1)) {
                flag = true;
                i++;
            }
            if(!flag) {
                res += input.charAt(0);
                res += removeDuplicate(input.substring(i + 1));
            }
            else
                res +=  removeDuplicate(input.substring(i+1));
            flag = true;
            for (int j = 0; j <res.length()-1 ; j++) {
                if(res.charAt(j) == res.charAt(j+1)){
                    flag = false;
                    break;
                }
            }
            if (flag)
                return res;
            else
                return removeDuplicate(res);
        }
    }
    /*private static String removeDuplicateUtil(char ch,String input){

        if(ch == '\0'){

        }
    }*/

}
