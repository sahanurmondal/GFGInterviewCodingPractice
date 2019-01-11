package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Vaibhav likes to play with numbers and he has n numbers. One day he was placing the numbers on the playing
board just to count that how many numbers he have. He was placing the numbers in increasing order i.e. from
1 to n. But when he was putting the numbers back into his bag, some numbers fell down onto the floor.
He picked up all the numbers but one number, he couldn't find. Now he have to go somewhere
urgently, so he asks you to find the missing number.

Input:
The first of input contains an integer T, then T test cases follow. Each test case contains an
integer n i.e. numbers of integers he placed on the board and the second line of each test case
contains the array a[] which represents the
numbers, he successfully picked up from the floor.


Output:
For each test case in a new line print the missing number.


Constraints:
1<=T<=25
1<=n<=10000
1<=a[i]<=10000


Example:
Input:
2
4
1 4 3
5
2 5 3 1
Output:
2
4


Explanation:
For first test case
Vaibhav placed 4 integers but he picked up only 3 numbers. So missing number will be 2 as it will become 1,2,3,4.

For the second case
Vaibhav placed 5 integers on the board, but picked up only 4 integers, so the missing number will be 4 so that it
 will become 1,2,3,4,5.
 */
public class Missing_number {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            int sum=(n*(n+1))/2;
            for (int i = 0; i <n-1 ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
                sum-=arr[i];
            }

            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
