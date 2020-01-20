package com.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before
all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers same.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the number of elements in Linked List.
The second line of each test case contains N input,elements in Linked List.

Output:

Print the all even numbers then odd numbers in the modified Linked List.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ size of elements ≤ 1000

Example:

Input
3
7
17 15 8 9 2 4 6
4
1 3 5 7
7
8 12 10 5 4 1 6

Output
8 2 4 6 17 15 9
1 3 5 7
8 12 10 4 6 5 1
 */
public class Segregate_even_and_odd_nodes_in_a_Linked_List {
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
        Node even = null,odd=null,evenstart=null,oddstart=null,temp=head;
        while(temp != null){
            if(temp.data % 2 ==1){
                if(oddstart ==null){
                    oddstart = temp;
                    odd = oddstart;
                }else{
                    odd.next = temp;
                    odd = odd.next;
                    //odd.next=null;
                }
            }else {
                if(evenstart ==null){
                    evenstart = temp;
                    even = evenstart;
                }else{
                    even.next = temp;
                    even = even.next;
                }
            }
            temp = temp.next;
        }
        if(oddstart !=null) {
            odd.next = null;
            if (even !=null)
            even.next = oddstart;

        }
        if(evenstart !=null)
            head = evenstart;
        else
            head = oddstart;
        return head;
    }
}
