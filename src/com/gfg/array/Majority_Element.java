package com.gfg.array;

/*
Given an array A of N elements. Find the majority element in the array. A majority element in an
array A of size N is an element that appears more than N/2 times.

Input:
The first line of the input contains T denoting the number of testcases. The first line of the test case
will be the size of array and second line will be the elements of the array.

Output: For each test case the output will be the majority element of the array.

Constraints:
1 <= T<= 100
1 <= N <= 103
0 <= Ai <= 103

Example:
Input:
2
5
3 1 3 3 2
3
1 2 3

Output:
3
-1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Majority_Element {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        //long x=0,y=0;

        //int max=1,ans=-1,k=0;
        StringTokenizer tk;
        while(t-->0)
        {
            int[] arr=new int[1000];
            int max=1,ans=-1,k=0;
            n=Integer.parseInt(br.readLine());
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                k=Integer.parseInt(tk.nextToken());
                arr[k]++;
                if (arr[k]>n/2){
                    ans=k;
                    break;
                }/*else if(arr[k]>max){
                    max =arr[k];
                    ans=k;
                }*/
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
