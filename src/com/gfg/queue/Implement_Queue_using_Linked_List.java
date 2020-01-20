package com.gfg.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Implement a Queue using Linked List.

Input Format:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
First line of each test case contains an integer Q denoting the number of queries .
A Query Q is of 2 Types
(i) 1 x   (a query of this type means  pushing 'x' into the queue)
(ii) 2     (a query of this type means to pop element from queue and print the poped element)
The second line of each test case contains Q queries seperated by space.

Output Format:
The output for each test case will  be space separated integers having -1 if the queue is empty else the element poped out from the queue .
You are required to complete the two methods push which take one argument an integer 'x' to be pushed into the quee  and pop which returns
a integer poped out from othe queue.

Your Task:
Since this is a function problem, you don't need to take inputs. Just complete the provided functions.

Constraints:
1 <= T <= 100
1 <= Q <= 100
1 <= x <= 100

Example:
Input:
1
5
1 2 1 3 2 1 4 2
Output:
2 3

Explanation:
Testcase1:
1 2    the quee will be {2}
1 3    the queue will be {2 3}
2       poped element will be 2 the queue will be {3}
1 4    the queue will be {3 4}
2       poped element will be 3


Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only.
As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and
not to write the full code.
 */
class  Node{
    int data;
    Node next;
}
public class Implement_Queue_using_Linked_List {
    Node front;
    Node rear;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n=0, x=0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        Implement_Queue_using_Linked_List ob = new Implement_Queue_using_Linked_List();
        //int[] arr;
        while(t-->0)
        {
            n = Integer.parseInt(br.readLine());
            //arr = new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                x = Integer.parseInt(tk.nextToken());
                if(x==1){
                    push(Integer.parseInt(tk.nextToken()),ob);
                }else if(x==2){
                    sb.append(pop(ob)).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int pop(Implement_Queue_using_Linked_List ob) {
        int res =-1;
        if(ob.front != null) {
            res = ob.front.data;
            Node temp = ob.front.next;
            ob.front = null;
            ob.front = temp;
        }
        return res;
    }

    private static void push(int data,Implement_Queue_using_Linked_List ob){
        Node temp = new Node();
    temp.data = data;
    temp.next= null;
        if(ob.front == null) {
        ob.front = temp;
        ob.rear  = temp;
    }else{
        ob.rear.next = temp;
        ob.rear = temp;
    }

}
}
