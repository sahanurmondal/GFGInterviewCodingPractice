package com.gfg.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
The task is to complete partition() function which is used to implement Quick Sort.

Input:
First line of the input denotes number of test cases 'T'. First line of the test case is the size of array
and second line consists of array elements.


Output:
Sorted array in increasing order is displayed to the user.


Constraints:
1 <=T<= 50
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
public class Quick_Sort {
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
            quickSort(arr,0,n-1);
            for (int a:arr
            ) {
                System.out.print(a+" ");;
            }
            System.out.println();
        }
        //System.out.print(sb);
    }
    static void quickSort(int[] arr,int l,int r){

        if (l<r) {
            int p=rand_partition(arr,l,r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }
    static int rand_partition ( int arr[ ] , int start , int end ) {
        //chooses position of pivot randomly by using rand() function .
        int random = start + (int) (Math.random() * (end - start + 1));

        swapArr(arr, random, start);        //swap pivot with 1st element.
        return partition(arr, start, end);       //call the above partition function
    }

        static int partition(int[] arr,int l,int r){
        int i = l + 1;
        int piv = arr[l] ;            //make the first element as pivot element.
        for(int j =l + 1; j <= r ; j++ )  {
    /*rearrange the array by putting elements which are less than pivot
       on one side and which are greater that on other. */

            if ( arr[ j ] < piv) {
                swapArr (arr, i , j );
                i += 1;
            }
        }
        swapArr ( arr,l ,i-1  ) ;  //put the pivot element in its proper place.
        return i-1;
    }
    static void swapArr(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
