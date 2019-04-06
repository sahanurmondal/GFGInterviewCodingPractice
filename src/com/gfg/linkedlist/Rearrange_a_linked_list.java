package com.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a singly linked list, rearrange it in a way that all odd position nodes are together and all even positions
node are together,

Input: You have to complete the method which takes one argument: the head of the linked list. You should not read
any input from stdin/console..
Note: There are multiple test cases, for each test case, this method will be called individually.

Output:
Your function should return pointer to head of the modified list.

Constraints:
1 <=T<= 50
1 <=N<= 100
1 <=value<= 1000

Example:
Input:
2
4
1 2 3 4
5
1 2 3 4 5

Output:
1 3 2 4
1 3 5 2 4
 */
public class Rearrange_a_linked_list {
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
                PrintList.print(rearrange(head),sb);
                sb.append("\n");
            }
            System.out.print(sb);
        }

    private static Node rearrange(Node head) {
        Node even,odd,evenstart;
        evenstart=head.next;
        odd=head;
        even=odd.next;
        while(even !=null && even.next != null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenstart;

        return head;
    }
}
