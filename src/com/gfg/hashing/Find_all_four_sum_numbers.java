package com.gfg.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Given an array A of size N, find all combination of four elements in the array whose sum is equal to a
 given value K. For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and K = 23, one of the quadruple
  is “3 5 7 8” (3 + 5 + 7 + 8 = 23).

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
Each test case contains two lines. The first line of input contains two integers N and K. Then in the next
line are N space separated values of the array.

Output:
For each test case in a new line print all the quadruples present in the array separated by space which
sums up to value of K. Each quadruple is unique which are separated by a delimeter "$" and are in increasing
order.

Constraints:
1 <= T <= 100
1 <= N <= 100
-1000 <= K <= 1000
-100 <= A[] <= 100

Example:
Input:
2
5 3
0 0 2 1 1
7 23
10 2 3 4 5 7 8

Output:
0 0 1 2 $
2 3 8 10 $2 4 7 10 $3 5 7 8 $
 */
public class Find_all_four_sum_numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n=0,k=0;
        // long x=0,y=0;
        StringTokenizer tk;
        int[] arr;
        while(t-->0)
        {
            tk = new StringTokenizer(br.readLine());
            n=Integer.parseInt(tk.nextToken());
            k=Integer.parseInt(tk.nextToken());
            arr= new int[n];
            tk = new StringTokenizer(br.readLine());
            Map<Integer,Integer> m= new HashMap<Integer,Integer>();
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(tk.nextToken());
                if(!m.containsKey(arr[i]))
                    m.put(arr[i],0);
                m.put(arr[i],m.get(arr[i])+1);
            }
            //Arrays.sort(arr);
            //Map<Integer, Integer> m=new HashMap<Integer, Integer>();
            int size=n*(n-1)/2,x=0;
            int[][] sum=new int[size][3];
            for (int i = 0; i <n-1 ; i++) {
                for (int j = i+1; j <n ; j++){
                    sum[x][0]=arr[i]+arr[j];
                    sum[x][1]=arr[i];
                    sum[x][2]=arr[j];
                    x++;
                }
            }
            sortbyColumn(sum,0);
            ArrayList<Integer> list=new ArrayList<Integer>();
            int l=0,r=size-1;
            LinkedHashSet<ArrayList<Integer>> hs=new LinkedHashSet<ArrayList<Integer>>();
            //boolean flag=true;
            while (l<r){
                if(sum[l][0] +sum[r][0]>k)
                    r--;
                else if(sum[l][0] +sum[r][0]==k){
                    list=new ArrayList<Integer>();
                    list.add(sum[l][1]);
                    list.add(sum[l][2]);
                    list.add(sum[r][1]);
                    list.add(sum[r][2]);
                    list.sort(null);
                       if((sum[l][1]!=sum[r][1] && sum[l][1]!=sum[r][2] &&sum[l][2]!=sum[r][1] &&sum[l][2]!=sum[r][2])|| (sum[l][1]==sum[l][2] && m.get(sum[l][1])>2) ){
                           hs.add(list);
                       }
                    //list.clear();
                    x=r;
                    x--;
                    while(sum[l][0] +sum[x][0]==k){
                        list=new ArrayList<Integer>();
                        list.add(sum[l][1]);
                        list.add(sum[l][2]);
                        list.add(sum[x][1]);
                        list.add(sum[x][2]);
                        list.sort(null);
                        if((sum[l][1]!=sum[x][1] && sum[l][1]!=sum[x][2] &&sum[l][2]!=sum[x][1] &&sum[l][2]!=sum[x][2] )|| (sum[l][1]==sum[l][2] && m.get(sum[l][1])>2)){
                            hs.add(list);
                        }
                        x--;
                    }
                    l++;
                    if(sum[l][0] +sum[r][0]!=k)
                    r--;
                }else
                    l++;

            }
            ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>(hs);
            res.sort( new Comparator<ArrayList<Integer>>() {

            @Override
            // Compare values according to columns
            public int compare(ArrayList<Integer> entry1,
                               ArrayList<Integer> entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1.get(0) > entry2.get(0))
                    return 1;
                else if(entry1.get(0) == entry2.get(0)){
                    if(entry1.get(1) > entry2.get(1))
                        return 1;
                    else if(entry1.get(1) ==entry2.get(1)){
                        if (entry1.get(2) > entry2.get(2))
                            return 1;
                        else if(entry1.get(2) == entry2.get(2)){
                            if (entry1.get(3) > entry2.get(3))
                                    return 1;
                                else
                                    return -1;
                        }else
                            return -1;
                    }else
                        return -1;
                }
                else
                    return -1;
            }
        });
            for (ArrayList<Integer> li:res
                 ) {
                li.forEach(i -> sb.append(i).append(" "));
                sb.append("$");
            }
            //System.out.println(hs.toString());
            if(hs.isEmpty())
                sb.append(-1);
            sb.append("\n");
        }
        System.out.print(sb);
    }
    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }


    /*
    public static void main (String[] args) {
		//code
		Scanner s =new Scanner(System.in);
		int t= s.nextInt();
		while(t-->0){
		    int n =s.nextInt();
		    int k =s.nextInt();
		    Set<String> st =new LinkedHashSet<String>();
		    int arr[]=new int[n];
		    for(int i =0;i<n;i++){
		        arr[i]=s.nextInt();
		    }
		    Arrays.sort(arr);
		    StringBuilder sb=new StringBuilder();
		    for(int i =0;i<n-3;i++){
		        for(int j =i+1;j<n-2;j++){
		            int x=j+1;int y =n-1;
		            while(x<y){
		                int res=arr[i]+arr[j]+arr[x]+arr[y];
		                if(res==k){
		                    String temp=(arr[i]+" "+arr[j]+" "+arr[x]+" "+arr[y]+" "+"$");
		                    st.add(temp);
		                    x++;
		                    y--;
		                }
		               else if(res<k)
		                    x++;
		                else
		                 y--;
		            }
		        }
		    }
		   for(String str:st){
		       sb.append(str);
		   }
		   if(sb.length()>0)
		   System.out.println(sb.toString());
		   else
		   System.out.println(-1);
		}

	}
    */
}
