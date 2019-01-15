package com.gfg.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
The task is to complete bubble function which is used to implement Bubble Sort !

Input:
First line of the input denotes the number of test cases 'T'. First line of the test case is the size of
array and second line consists of array elements.


Output:
Sorted array in increasing order is displayed to the user.


Constraints:
1 <=T<= 100
1 <=N<= 1000
1 <=arr[i]<= 1000


Example:

Input:
2
5
4 1 3 9 7
10
10 9 8 7 6 5 4 3 2 1

Output:
1 3 4 7 9
1 2 3 4 5 6 7 8 9 10
 */
public class Bubble_Sort {
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
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }
            int tmp=0;
            boolean flag=true;
            for (int i = 0; i <n-1 ; i++) {
                  for (int j = 0; j <n-i-1 ; j++){
                              if(arr[j]>arr[j+1]){
                                  tmp=arr[j];
                                  arr[j]=arr[j+1];
                                  arr[j+1]=tmp;
                                  flag=false;
                              }
                  }
                  if(flag)
                      break;
            }
            for (int a:arr
            ) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
