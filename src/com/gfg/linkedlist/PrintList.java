package com.gfg.linkedlist;

public class PrintList {
    public static void print(Node head, StringBuilder sb) {
        Node temp = head;
        while (temp != null){
            sb.append(temp.data).append(" ");
            temp = temp.next;
        }
    }
}
