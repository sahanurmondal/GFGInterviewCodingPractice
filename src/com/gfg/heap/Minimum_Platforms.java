package com.gfg.heap;
/*
Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of
 platforms required for the railway station so that no train waits.

Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times
will not be same for a train, but we can have arrival time of one train equal to departure of the other. In such cases,
we need different platforms, i.e at any given instance of time, same platform can not be used for both departure of a
train and arrival of another.

Input:
The first line of input contains T, the number of test cases. For each test case, first line will contain an integer N,
the number of trains. Next two lines will consist of N space separated time intervals denoting arrival and departure
times respectively.
Note: Time intervals are in the 24-hour format(hhmm),  of the for HHMM , where the first two charcters represent hour
(between 00 to 23 ) and last two characters represent minutes (between 00 to 59).

Output:
For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= A[i] < D[i] <= 2359

Example:
Input:
2
6
0900  0940 0950  1100 1500 1800
0910 1200 1120 1130 1900 2000
3
0900 1100 1235
1000 1200 1240

Output:
3
1

Explanation:
Testcase 1: Minimum 3 platforms are required to safely arrive and depart all trains.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Minimum_Platforms {
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0;
        StringTokenizer tk,tk1;
        Node[] arr;
        int x=0;
        while(t-->0)
        {
            PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
            n=Integer.parseInt(br.readLine().trim());
            arr= new Node[n];
            tk = new StringTokenizer(br.readLine());
            tk1 = new StringTokenizer(br.readLine());
            String arv,dep;
            for (int i = 0; i < n; i++) {
                arv = tk.nextToken();
                dep = tk1.nextToken();
                Node node = new Node();
                node.arrival = Integer.parseInt(arv.substring(0,2))*60 + Integer.parseInt(arv.substring(2));
                node.departure = Integer.parseInt(dep.substring(0,2))*60 + Integer.parseInt(dep.substring(2));
                arr[i] = node;
            }
            Arrays.sort(arr, Comparator.comparingInt((Node n2) -> n2.arrival));
            int p = 0;
            p++;
            pQueue.add(arr[0].departure);
            for (int i = 1; i <n ; i++) {
               if(arr[i].arrival > pQueue.peek()){
                    pQueue.poll();
                    p--;
                }
                p++;
                pQueue.add(arr[i].departure);
            }
            sb.append(p).append("\n");
        }
        System.out.print(sb);
    }

    static class Node{
        int arrival;
        int departure;
    }
}

