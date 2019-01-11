package com.gfg.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given a string S consisting only '0's and '1's,  print the last index of the '1' present in it. Input stream
may either be sorted in decreasing order or increasing order.

Input:
First line of the input contains the number of test cases T, T lines follow each containing a stream of
characters.

Output:
Corresponding to every test case, output the last index of 1. If 1 is not present, print "-1" (without quotes).

Constraints:
1 <= T <= 110
1 <= S <= 1018

Example:
Input:
2
00001
0
Output:
4
-1

Explanation:
Testcase 1: Last index of  1 in given string is 4.
Testcase 2: Since, 1 is not present, so output is -1.
 */
public class Last_index_of_One {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int t = Integer.parseInt(br.readLine());
            String  s;
            while(t-->0)
            {
                s=br.readLine();
                int ans=-1,n=s.length();
                if(n==1 && s.charAt(0)=='1')
                    ans=0;
                else if (n==1 && s.charAt(0)=='0')
                    ans=-1;
                else if(s.charAt(0)=='1' && s.charAt(n-1)=='1')
                    ans=n-1;
                else if(s.charAt(0)=='1' || s.charAt(n-1)=='1'){
                    int l=0,r=n-1,mid=0;
                    if(s.charAt(n-1)=='1'){
                        ans=n-1;
                    }else {
                        while(l<=r){
                            mid=(l+r)/2;
                            if (s.charAt(mid)=='1'){
                                if(mid+1<=r && s.charAt(mid+1)=='0') {
                                    ans=mid;
                                    break;
                                }else {
                                    if (mid + 1 <= r)
                                        l = mid + 1;
                                    else
                                        break;
                                }
                            }else{
                                if(mid-1>=l && s.charAt(mid-1)=='1') {
                                    ans=mid-1;
                                    break;
                                }else {
                                    if(mid-1>=l)
                                        r = mid - 1;
                                    else
                                        break;
                                }
                            }
                        }
                    }
                }

                sb.append(ans).append("\n");
            }
            System.out.print(sb);
        }
}
