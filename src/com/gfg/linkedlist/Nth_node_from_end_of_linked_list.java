package com.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a linked list of length L. The task is to find the Nth node from the end of the linked list.  It is needed to
complete a method that takes two argument, head of linked list and an integer N. There are multiple test cases. For
each test case, this method will be called individually.

Input:
First line of input contains number of testcase T. For each testcase, first line of input contains number of nodes in
the linked list and N. Next line contains nodes of linked list.

Output:
For each testcase, output the data of node which is at Nth distance from end.

User Task:
The task is to complete the function getNthFromLast() which two arguments reference to head and N for which Nth from
end is to be returned.

Constraints:
1 <= T <= 200
1 <= L <= 103
1 <= N <= 103

Example:
Input:
2
9 2
1 2 3 4 5 6 7 8 9
4 5
10 5 100 5 1

Output:
8
-1

Explanation:
Testcase 1: In the first example, there are 9 nodes in linked list and we need to find 2nd node from end.  2nd node
from end os 8.
Testcase 2: In the second example, there are 4 nodes in linked list and we need to find 5th from end.  Since 'n' is
more than number of nodes in linked list, output is -1
 */
public class Nth_node_from_end_of_linked_list {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = 0, x = 0, k = 0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        while (t-- > 0) {
            Node head = null, last = null;
            tk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(tk.nextToken());
            k = Integer.parseInt(tk.nextToken());
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                x = Integer.parseInt(tk.nextToken());
                if (head == null) {
                    head = new Node(x);
                    last = head;
                } else {
                    last.next = new Node(x);
                    last = last.next;
                }
            }
            sb.append(getNthNode(head, k)).append("\n");
        }
        System.out.print(sb);
    }

    private static int getNthNode(Node head, int n) {
        int res = -1;
        Node Fast = head, Slow = head;
        while (Fast != null && n-- > 0)
            Fast = Fast.next;
        if (n <= 0) {
            while (Fast != null) {
                Fast = Fast.next;
                Slow = Slow.next;
            }
            if (Slow != null)
                res = Slow.data;
        }

        return res;
    }
}
