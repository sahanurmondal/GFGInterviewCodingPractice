package com.gfg.array;

/*

You are given an array A, of N elements. You need to find minimum distance between given two integers x and y.

Input Format:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. The first line of each test case contains an integer N denoting size array. Then in the next line are N space separated values of the array A. The last line of each test case contains two integers  x and y.

Output Format:
For each test case, print the required answer .

Your Task:
Your task is to complete the function minDist which returns  an integer denoting the minimum
distance between two integers x and y in the array. If no such distance is possible then return -1.

Constraints:
1 <= T <= 100
1 <= N <= 100
1 <= A, x, y <= 100

Example:
Input:
2
2
1 2
1 2
7
86 39 90 67 84 66 62
42 12

Output:
1
-1

Explanation:
Testcase1: x=1 and y=2. minDistance between x and y is 1.
Testcase2: x=42 and y=12. We return -1 as the x and y don't exist in the array.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Minimum_distance_between_two_numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        int x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            tk = new StringTokenizer(br.readLine());
            arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
            }

            tk = new StringTokenizer(br.readLine());
            x=Integer.parseInt(tk.nextToken());
            y=Integer.parseInt(tk.nextToken());
            int min=n;
            for (int i = 0; i < n; i++) {
                if(arr[i]==x){
                  int c=0;
                  for (int j = i; j <n ; j++){
                         if (arr[j]==y) {
                             if(min>c)  min=c;
                             break;
                         }
                         c++;
                  }

                }
            }
            for (int i = 0; i < n; i++) {
                if(arr[i]==y){
                    int c=0;
                    for (int j = i; j <n ; j++){
                        if (arr[j]==x) {
                            if(min>c)  min=c;
                            break;
                        }
                        c++;
                    }

                }
            }

            sb.append( min==n? -1:n).append("\n");
        }
        System.out.print(sb);
    }
}
