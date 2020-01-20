package com.gfg.dp;
/*
Rahul and Ankit are the only two waiters in Royal Restaurant. Today, the restaurant received N orders. The amount
of tips may differ when handled by different waiters, if Rahul takes the ith order, he would be tipped Ai rupees and
if Ankit takes this order, the tip would be Bi rupees.
In order to maximize the total tip value they decided to distribute the order among themselves. One order will be
handled by one person only. Also, due to time constraints Rahul cannot take more than X orders and Ankit cannot
take more than Y orders. It is guaranteed that X + Y is greater than or equal to N, which means that all the orders
can be handled by either Rahul or Ankit. Find out the maximum possible amount of total tip money after processing
all the orders.


Input:

•    The first line contains one integer, number of test cases.
•    The second line contains three integers N, X, Y.
•    The third line contains N integers. The ith integer represents Ai.
•    The fourth line contains N integers. The ith integer represents Bi.



Output:
Print a single integer representing the maximum tip money they would receive.


Constraints:
1 ≤ N ≤ 105
1 ≤ X, Y ≤ N; X + Y ≥ N
1 ≤ Ai, Bi ≤ 104



Example:

Input:

2
5 3 3
1 2 3 4 5
5 4 3 2 1
8 4 4
1 4 3 2 7 5 9 6
1 2 3 6 5 4 9 8



Output:

21
43
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;


class Arr
{
    int a,b,c;

    Arr(int a,int b)
    {
        this.a=a;
        this.b=b;
        this.c=Math.abs(a-b);
    }
}

public class Maximum_Tip_Calculator
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();

            int a[]=new int[n];
            int b[]=new int[n];


            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                b[i]=sc.nextInt();
            }

            Arr arr[] = new Arr[n];

            for(int i=0;i<n;i++)
            {
                arr[i]=new Arr(a[i],b[i]);
            }

            Arrays.sort(arr,new Comparator<Arr>()
            {
                public int compare(Arr a ,Arr b)
                {
                    return (b.c-a.c);
                }
            });

            int i=0;
            long sum=0;

            while(x>0 && y>0 && i<n)
            {
                if(arr[i].a>=arr[i].b)
                {
                    sum+=arr[i].a;
                    x--;
                }
                else
                {
                    sum+=arr[i].b;
                    y--;
                }

                i++;
            }

            while(x>0 && i<n)
            {
                sum+=arr[i++].a;
                x--;
            }

            while(y>0 && i<n)
            {
                sum+=arr[i++].b;
                y--;
            }

            System.out.println(sum);
        }

    }
}
