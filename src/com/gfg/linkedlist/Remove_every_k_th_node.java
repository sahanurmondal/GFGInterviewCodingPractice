package com.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
Given a singly linked list, Your task is to remove every Kth node. The task is to complete a method deleteK that
takes two argument, head of linked list and an integer k.The method returns the head of the new linked list. There
are multiple test cases. For each test case, this method will be called individually.

Input:
The first line of input contains number of test cases T. Then T test cases follow. Every test case contains 3 lines.
First line of every test case contains an integer N denoting the size of the linked list . The second line contains
N space separated values of the linked list. The third line contains an integer K.

Output:
Output for each test case will be space separated values of the nodes of the new transformed linked list .

Constraints:
1<=T<=50
1<=N<=100
1<=element of linked list <=1000
0<=k<=100

Example:

Input:
2
8
1 2 3 4 5 6 7 8
3
4
1 2 3 4
2

Output:
1 2 4 5 7 8
1 3
 */
public class Remove_every_k_th_node {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            int n=0,x=0,k=0;
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
                k = Integer.parseInt(br.readLine());
                PrintList.print(delete(head,k),sb);
                sb.append("\n");
            }
            System.out.print(sb);
        }




    private static Node delete(Node head, int x)
    {
        Node temp = head,prev = head;
        int c=0;
        if(x==1)
            head =  null;
        else if(x >0){
            while(temp != null){
                if((c+1)%x  == 0){
                    prev.next = temp.next;
                }
                c++ ;
                prev =temp;
                temp = temp.next;
            }
        }

        return head;
    }
}
