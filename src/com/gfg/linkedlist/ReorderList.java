package com.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReorderList {
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
            PrintList.print(reorderList(head),sb);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static Node reorderList(Node head) {
        if(head.next == null) return head;

        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node node1 = head;
        Node node2 = slow.next;
        slow.next = null;

        // 3) Reverse the second half, i.e., 5 -> 4
        node2 = reverse(node2);
        // System.out.println(node2.toString());
        // 4) Merge alternate nodes
        head = new Node(0); // Assign dummy Node

        // curr is the pointer to this dummy Node, which
        // will be used to form the new list
        Node curr = head;
        while (node1 != null || node2 != null) {

            // First add the element from first list
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }

            // Then add the element from second list
            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }

        // Assign the head of the new list to head pointer
        head = head.next;

        return head;
    }

    Node reorderListWithoutDummyNode(Node head) {
        if(head.next == null) return head;

        Node slow = head, fast = head, half;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node node2 = slow.next;
        slow.next = null;

        // 3) Reverse the second half, i.e., 5 -> 4
        node2 = reverse(node2);
        Node cur = head, next;

        while(cur != null && node2 != null){
            next = cur.next;
            cur.next = node2;
            cur = next;
            next = node2.next;
            if(cur != null)
                node2.next = cur;
            node2 = next;
        }

        return head;
    }

    private static Node reverse(Node h){
        if(h == null) return h;

        Node p=null , c=h, n=null;

        while(c != null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        h=p;

        return h;
    }
}
