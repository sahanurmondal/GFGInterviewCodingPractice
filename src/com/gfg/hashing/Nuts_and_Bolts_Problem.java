package com.gfg.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
Given a set of N nuts of different sizes and N bolts of different sizes. There is a one-one mapping between
nuts and bolts. Match nuts and bolts efficiently.

Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared
with bolt and bolt can only be compared with nut to see which one is bigger/smaller.

Input:

The first line contains 'T' denoting the number of testcases. Then follows description of T testcases:
Each case begins with a single positive integer N denoting the number of nuts/bolts.

Then follows the array of nuts, each element separated by a space.

And finally the bolts array, again, each element is separated by a space here.

Array of Nuts/Bolts can only consist of the following elements:

{'@', '#', '$', '%', '^', '&', '~', '*', '!'}

And no element can be repeated.


Output:

For each test case, output the matched array of nuts and bolts in separate lines, where each element in the
array is separated by a space. Print the elements in the following order ! # $ % & * @ ^ ~


Constraints:

1<= T <= 70
1<= N <= 9


Example:

Input:

2
5
@ % $ # ^
% @ # $ ^
9
^ & % @ # * $ ~ !
~ # @ % & * $ ^ !

Output:

# $ % @ ^
# $ % @ ^
! # $ % & * @ ^ ~
â€‹! # $ % & * @ ^ ~
 */
public class Nuts_and_Bolts_Problem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        char x;
        // long x=0,y=0;
        StringTokenizer tk,tk1;
       // char[] arr;
        char a[]={'!','#','$','%','&','*','@','^','~'};
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            Map<Character,Integer> m= new HashMap<Character,Integer>();
            tk = new StringTokenizer(br.readLine());
            tk1 = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                x=tk.nextToken().charAt(0);
                if(!m.containsKey(x)){
                    m.put(x,1);
                }else
                    m.put(x,m.get(x)+1);
                x=tk1.nextToken().charAt(0);
                if(!m.containsKey(x)){
                    m.put(x,1);
                }else
                    m.put(x,m.get(x)+1);
            }
            for (int i = 0; i <9 ; i++) {
                if (m.containsKey(a[i]) && m.get(a[i])>1)
                    sb.append(a[i]).append(" ");
            }
            sb.append("\n");
            for (int i = 0; i <9 ; i++) {
                if (m.containsKey(a[i]) && m.get(a[i])>1)
                    sb.append(a[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
