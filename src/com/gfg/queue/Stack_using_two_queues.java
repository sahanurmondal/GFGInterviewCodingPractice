package com.gfg.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
Implement a Stack using 2 queue q1 and q2 .

Input Format:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
First line of each test case contains an integer Q denoting the number of queries .
A Query Q is of 2 Types
(i) 1 x   (a query of this type means  pushing 'x' into the stack)
(ii) 2     (a query of this type means to pop element from stack and print the poped element)
The second line of each test case contains Q queries seperated by space.

Output Format:
The output for each test case will  be space separated integers having -1 if the stack is empty else the element poped out from the stack .
You are required to complete the two methods push which take one argument an integer 'x' to be pushed into the stack  and pop which returns
a integer poped out from the stack.

Your Task:
Since this is a function problem, you don't need to take inputs. Just complete the provided functions.

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
Testcase1:
1 2    the stack will be {2}
1 3    the stack will be {2 3}
2       poped element will be 3 the stack will be {2}
1 4    the stack will be {2 4}
2       poped element will be 4
 */
public class Stack_using_two_queues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    //Stack_using_two_queues obj = new Stack_using_two_queues();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n=0,x=0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        int[] arr;
        //Stack_using_two_queues ob = new Stack_using_two_queues();
        while(t-->0)
        {
            Stack_using_two_queues ob = new Stack_using_two_queues();
          //  ob.q1.clear(); ob.q2.clear();
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                x = Integer.parseInt(tk.nextToken());
                if(x==1){
                    ob.push(Integer.parseInt(tk.nextToken()));
                }else if(x==2){
                    sb.append(ob.pop()).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private  void push(int i) {
            if(q1.isEmpty()){
                q2.add(i);
            }else
                q1.add(i);
    }

    private  int pop()
    {
        int res=-1;
        if(q1.isEmpty()){
            while(q2.size()>1){
                q1.add(q2.remove());
            }
            if(!q2.isEmpty())
              res = q2.remove();
        }else{
            while(q1.size()>1){
                q2.add(q1.remove());
            }
            if(!q1.isEmpty())
            res = q1.remove();
        }
        return res;
    }
}
