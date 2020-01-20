package com.gfg.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Implement a Stack using Linked List .

Input Format:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
First line of each test case contains an integer Q denoting the number of queries .
A Query Q is of 2 Types
(i) 1 x   (a query of this type means  pushing 'x' into the stack)
(ii) 2     (a query of this type means to pop element from stack and print the poped element)
The second line of each test case contains Q queries seperated by space.

Output Format:
The output for each test case will  be space separated integers having -1 if the stack is empty else the
element poped out from the stack .
You are required to complete the two methods push which take one argument an integer 'x' to be pushed into
the stack  and pop which returns a integer poped out from the stack.

Your Task:
Since this is a function problem, you don't need to take any input. Just complete the provided function.

Constraints:
1 <= T <= 100
1 <= Q <= 100
1 <= x <= 100

Example:
Input
1
5
1 2 1 3 2 1 4 2
Output
3 4

Explanation:
In the first test case for query
1 2    the stack will be {2}
1 3    the stack will be {2 3}
2       poped element will be 3 the stack will be {2}
1 4    the stack will be {2 4}
2       poped element will be 4
 */
class  Node{
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
public class Implement_Stack_using_Linked_List {
    Node top=null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,command=0, x=0;
        // long x=0,y=0;
        StringTokenizer tk;
        while(t-->0)
        {
            Implement_Stack_using_Linked_List ob = new Implement_Stack_using_Linked_List();
            n=Integer.parseInt(br.readLine());
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                command = Integer.parseInt(tk.nextToken());
                if(command == 1) {
                    x = Integer.parseInt(tk.nextToken());
                    push(x,ob);

                }
                else if( command == 2) {
                        sb.append(pop(ob)).append(" ");
                }
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int pop(Implement_Stack_using_Linked_List ob) {
        int x = -1;
        if(ob.top !=null){
            x = ob.top.data;
            Node temp =ob.top.next;
            ob.top = null;
            ob.top = temp;

        }
        return x;
    }

    private static void push(int x, Implement_Stack_using_Linked_List ob) {
        if(ob.top == null){
            ob.top = new Node(x,null);
        }else{
            ob.top = new Node(x,ob.top);
        }
    }
}
