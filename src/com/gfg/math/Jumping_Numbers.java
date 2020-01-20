package com.gfg.math;
/*
Given a positive number X. Find all Jumping Numbers smaller than or equal to X.
Jumping Number: A number is called Jumping Number if all adjacent digits in it differ by only 1.
 All single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456
 are Jumping numbers but 796 and 89098 are not.

Input:
The first line of the input contains T denoting the number of testcases. Each testcase contain
a positive number X.

Output:
Output all the jumping numbers less than X in sorted order. Jump to example for better understanding.

Constraints:
1 <= T <= 100
1 <= N <= 109

Example:
Input:
2
10
50
Output:
0 1 2 3 4 5 6 7 8 9 10
0 1 2 3 4 5 6 7 8 9 10 12 21 23 32 34 43 45

Explanation:
Testcase 2: Here, the most significant digits of each jumping number is following increasing order, i.e.,
jumping numbers starting from 0, followed by 1, then 2 and so on, themselves being in increasing order 2, 21, 23.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Jumping_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());
        int i=0,a=0,k=11;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            a= Integer.parseInt(tk.nextToken());
           /* if(a>10) {
                sb.append("0 1 2 3 4 5 6 7 8 9 ");
                if(a>=k){
                   while(k<= a){
                           sb.append(k-1).append(" ");
                       if(k+1 <= a)
                           sb.append(k+1).append(" ");
                       k+=11;
                   }
                }
            }else{
                for (int j = 0; j <=a; j++) {
                    sb.append(j).append(" ");
                }
            }
            sb.append("\n");*/

            solve(a);
        }
       // System.out.print(sb);
    }

    private static void solve(int n) {
        LinkedList<Long> queue = new LinkedList<>();
        ArrayList<Long> list=new ArrayList<Long>();
        list.add(0l);
        //System.out.print("0 ");
        for (long i = 1; i <= 9; i++) {
            queue.add(i);
            while (!queue.isEmpty()) {
                long temp = queue.remove();
                if (temp > n) continue;
                //System.out.print(temp + " ");
                list.add(temp);
                long leftMost = temp % 10;
                if (leftMost > 0) queue.add(temp * 10 + (leftMost - 1));
                if (leftMost < 9) queue.add(temp * 10 + (leftMost + 1));
            }
        }
        //Collections.sort(list);
        list.sort(null);
        System.out.println(list.stream().map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}
