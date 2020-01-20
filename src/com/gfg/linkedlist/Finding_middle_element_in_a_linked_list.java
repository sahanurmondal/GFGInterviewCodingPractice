package com.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a singly linked list of N nodes. The task is to find middle of the linked list. For example, if given linked
list is 1->2->3->4->5 then output should be 3.

If there are even nodes, then there would be two middle nodes, we need to print second middle element. For example,
if given linked list is 1->2->3->4->5->6 then output should be 4.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains length of linked
list and next line contains data of nodes of linked list.

Output:
For each testcase, there will be a single line of output containing data of middle element of linked list.

User Task:
The task is to complete the function getMiddle() which takes head reference as the only argument and should return
the data at the middle node of linked list.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
5
1 2 3 4 5
6
2 4 6 7 5 1

Output:
3
7

Explanation:
Testcase 1: Since, there are 5 elements, therefore 3 is the middle element at index 2 (0-based indexing)
 */
public class Finding_middle_element_in_a_linked_list {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n=0,x=0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        while(t-->0)
        {
            Node head = null,last = null;
            n = Integer.parseInt(br.readLine());
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                x = Integer.parseInt(tk.nextToken());
                if(head ==null){
                   head = new Node(x);
                   last = head;
                }else{
                    last.next = new Node(x);
                    last = last.next;
                }
            }
            sb.append("$").append("\n");
        }
        System.out.print(sb);
    }

    static private int getMiddle(Node head)
    {
        Node slow = head, fast = head;
        int res = 0;
        if(slow != null) {
            while (slow.next !=null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
                    if (fast.next != null) {
                        fast = fast.next;
                    }
            }
            res = slow.data;
        }
        return res;
    }
}
