package com.gfg.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a keypad as shown in diagram, and an N digit number. List all words which are possible by pressing these
numbers.


Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow.
Each testcase contains two lines of input. The first line of each test case is N, N is the number of digits.
The second line of each test case contains D[i], N number of digits.

Output:
Print all possible words from phone digits with single space.

Constraints:
1 <= T <= 10
1 <= N <= 10
2 <=  D[i] <= 9

Example:
Input:
1
3
2 3 4

Output:
adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi
 */
public class Possible_words_from_Phone_digits {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // taking input of number of testcase
            int t = Integer.parseInt(br.readLine());
            int n=0;
            //StringBuilder sb = new StringBuilder();
            StringTokenizer tk;
           // String s;
            String[] digitStrings = {"", "", "abc", "def", "ghi", "jkl",
                    "mno", "pqrs", "tuv", "wxyz"};
            String[] numStr,output;
            while(t-->0)
            {
                n  = Integer.parseInt(br.readLine());
                numStr = new String[n];
                output = new String[n];
                tk = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    numStr[i] = digitStrings[Integer.parseInt(tk.nextToken())];
                }
                recursivePrint(numStr,output,0,n);
                System.out.println();
            }

        }


    private static void recursivePrint(String[] numStr,String[] output,int i,int n){
        if(i==n-1 ){
            for (int k = 0; k < numStr[i].length() ; k++) {
                output[i] = String.valueOf(numStr[i].charAt(k));
                System.out.print(String.join("", output)+" ");
            }
                 return;
        }
        int j = 0;
        while(i< n-1 && j < numStr[i].length()){
                    output[i] = String.valueOf(numStr[i].charAt(j));
                    recursivePrint(numStr, output, i+1, n);
            j++;
       }

    }
}
