package com.gfg.array;

/*
Given an array of positive integers. Your task is to find the leaders in the array.
Note: An element of array is leader if it is greater than or equal to all the elements to its right
side. Also, the rightmost element is always a leader.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of
T test cases follows.The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print all the leaders.

Constraints:
1 <= T <= 100
1 <= N <= 107
0 <= Ai <= 1018

Example:
Input:
3
6
16 17 4 3 5 2
5
1 2 3 4 0
5
7 4 5 7 3
Output:
17 5 2
4 0
7 7 3

Explanation:
Testcase 3: All elements on the right of 7 (at index 0) are smaller than or equal to 7.
 Also, all the elements of right side of 7 (at index 3) are smaller than 7. And, the last
 element 3 is itself a leader since no elements are on its right.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Leaders_in_an_array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        //int x=0;
       // StringTokenizer tk;
        Stack<Integer> st;
       // int tmp=Integer.MIN_VALUE;
        int[] arr;
       // int y=0;
        int right_i;
        while(t-->0)
        {
            st= new Stack<Integer>();
            n=Integer.parseInt(br.readLine());
            arr = Stream.of(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            //sb.append(arr[n-1]).append(" ");
            st.push(arr[n-1]);
            right_i=n-1;
            for (int i = n-2; i >=0 ; i--) {
                 if(arr[i]>=arr[right_i]){
                     right_i=i;
                     st.push(arr[i]);
                 }
            }
            while (!st.empty())
                sb.append(st.pop()).append(" ");
            /*for (int i = 0; i < n; i++) {

                x= Integer.parseInt(tk.nextToken());
                if(st.empty())
                    st.push(x);
                else{
                    while(!st.empty() && st.peek()<x){
                        st.pop();
                    }
                    st.push(x);
                }
            }
            y=st.size();
            arr=new int[y];
            int j=0;
            while (!st.empty())
                arr[j++]=st.pop();
            for (int i = y-1; i >= 0; i--) {
                sb.append(arr[i]).append(" ");
            }*/

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
