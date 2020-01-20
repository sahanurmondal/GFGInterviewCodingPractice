package com.gfg.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
Your task is to implement  2 stacks in one array efficiently .

Input Format:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
First line of each test case contains an integer Q denoting the number of queries .
A Query Q is of 4 Types
(i)    1 1 x    (a query of this type means  pushing 'x' into the stack 1)
(ii)   1 2      (a query of this type means to pop element from stack1  and print the poped element)
(iii)  2 1 x  (a query of this type means pushing 'x' into the stack 2)
(iv)  2 2     (a query of this type means to pop element from stack2 and print the poped element)
The second line of each test case contains Q queries seperated by space.

Output Format:
The output for each test case will be space separated integers having -1 if the stack is empty else the element
poped out from the stack.
You are required to complete the 4  methods push1, push2 which takes one argument an integer 'x' to be pushed
into the stack one and two  and pop1, pop2 which returns a integer poped out from stack one and two .

Your Task:
Since this is a function problem, you don't need to take any input. Just complete the provided functions.

Constraints:
1 <= T <= 100
1 <= Q <= 100
1 <= x <= 100

Example:
Input
1
6
1 1 2 1 1 3 2 1 4 1 2 2 2 2 2
Output
3 4 -1

Explanation:
Testcase1:
1 1 2    the stack1 will be {2}
1 1 3    the stack1 will be {2,3}
2 1 4   the stack2 will be {4}
1 2      the poped element will be 3 from stack1 and stack1 will be {2}
2 2      the poped element will be 4 from stack2 and now stack2 is empty
2 2      the stack2 is now empty hence -1 .
 */
public class Implement_two_stacks_in_an_array {
    int size;
    int top1,top2;
    int[] arr;
    Implement_two_stacks_in_an_array(int size){
        this.size = size;
        this.top1 = -1;
        this.top2 = size;
        this.arr = new int[size];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0, stack_no=0,command=0, x=0;
        // long x=0,y=0;
        StringTokenizer tk;
        while(t-->0)
        {

            n=Integer.parseInt(br.readLine());
            Implement_two_stacks_in_an_array sq = new Implement_two_stacks_in_an_array(n);
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                stack_no = Integer.parseInt(tk.nextToken());
                command  = Integer.parseInt(tk.nextToken());
                if(command == 1){
                    x = Integer.parseInt(tk.nextToken());
                    if(stack_no ==1 )
                        push1(x,sq);
                    else
                        push2(x,sq);
                }else if( command == 2){
                    if(stack_no ==1 )
                        sb.append(pop1(sq)).append(" ");
                    else
                        sb.append(pop2(sq)).append(" ");
                }
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int pop2(Implement_two_stacks_in_an_array sq) {
        int x= -1;
        if(sq.top2 < sq.size ){
            x = sq.arr[sq.top2];
            sq.top2++;
        }
        return x;
    }
    private static int pop1(Implement_two_stacks_in_an_array sq) {
        int x= -1;
        if(sq.top1 >=0 ){
            x = sq.arr[sq.top1];
            sq.top1--;
        }
        return x;
    }

    private static void push2(int x, Implement_two_stacks_in_an_array sq) {
        if (sq.top2 -sq.top1 >1){
            sq.top2--;
            sq.arr[sq.top2] = x;
        }
    }

    private static void push1(int x, Implement_two_stacks_in_an_array sq) {
        if(sq.top2 -sq.top1 >1){
            sq.top1++;
            sq.arr[sq.top1] = x;
        }
    }
}
