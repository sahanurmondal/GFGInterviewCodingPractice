package com.gfg.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
Find the first non-repeating element in a given array A of N integers.
Note: Array consists of only positive and negative integers and not zero.

Input:
The first line of input is an integer T, denoting the number of test cases. Each test case has subsequent two
lines of input. First line is an integer N, denoting size of integer array A. Second line consists of N space
separated integers of the array A.

Output:
For each testcase, print the required answer. If no such element exists, then print 0

Constraints:
1 <= T <= 100;
1 <= N <= 10^7;
-10^16 <= Ai <= 10^16
{Ai !=0 }

Example:
Input:
4
5
-1 2 -1 3 2
6
9 4 9 6 7 4
3
1 1 1
2
-3 2
Output:
3
6
0
-3

Explanation:
Testcase1: -1 and 2 are repeating whereas 3 is the only number occuring once. Hence, the output is 3.
Testcase2: There are 3 distinct integers, 9, 4 and 5, but they all are repeating. There is no non-repetitive
element in the array. Hence, the output is 0.
Testcase3: -1 and 3 are non-repeating. -1 occurs before 3 in the array. Hence, the output is -1.
Testcase4: There are two distinct elements occuring only once in the array, with 6 occuring before 7. Hence,
output is 6.
Testcase5: The only non-repeating element is -3. Hence, output is -3.
 */
public class Non_Repeating_Element {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,k=0;
        // long x=0,y=0;
        StringTokenizer tk;
        long[] arr;
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            arr= new long[n];
            Map<Long,Integer> m= new HashMap<Long,Integer>();
            tk = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                arr[i]=Long.parseLong(tk.nextToken());
                if(m.containsKey(arr[i]))
                    m.put(arr[i],m.get(arr[i])+1);
                else
                    m.put(arr[i],1);
            }
            long ans=0l;
            for (int i = 0; i <n ; i++) {
                if(m.get(arr[i])==1){
                    ans=arr[i];
                    break;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
