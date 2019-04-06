package com.gfg.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
Given an input stream of N characters consisting only of lower case alphabets. The task is to find the first non
repeating character, each time a character is inserted to the stream. If no non repeating element is found print -1.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case
contains an integer N denoting the size of the stream. Then in the next line are x characters which are inserted to the
stream.

Output:
For each test case in a new line print the first non repeating elements separated by spaces present in the stream at
every instinct when a character is added to the stream, if no such element is present print -1.

Constraints:
1 <= T <= 200
1 <= N <= 500

Example:
Input:
2
4
a a b c
3
a a c

Output:
a -1 b b
a -1 c
 */
public class First_non_repeating_character_in_a_stream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = 0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        int[] freq;
        char ch;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            freq = new int[26];
            Queue<Character> q = new LinkedList<>();
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                ch = tk.nextToken().charAt(0);
                // Increase frequency of current element
                freq[ch - 'a']++;

                // Push it into the queue
                q.add(ch);

                while (!q.isEmpty()) {

                    // Try element in front of the queue

                    // If it's frequency>1 it can't be non repeating pop it out and try next one
                    if (freq[((LinkedList<Character>) q).peekFirst() - 'a'] > 1) {
                        q.poll();
                    }
                    // Freq=1 so print and break
                    else {
                        sb.append(((LinkedList<Character>) q).peekFirst()).append(" ");
                        break;
                    }

                }
                if (q.isEmpty())
                    sb.append("-1").append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
