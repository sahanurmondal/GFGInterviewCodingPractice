package com.gfg.array;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        System.out.println(missingNumber(arr,5));
    }

    static int missingNumber(int arr[], int n) {
        int i=0;

        while(i < arr.length){
            int c=arr[i]-1;

            if(arr[i] < arr.length && arr[i] != arr[c]){
                int t = arr[i];
                arr[i] = arr[c];
                arr[c] = t;
            }else{
                i++;
            }
        }
        int missingNo = n;
        for(int j=0; j<n; j++){
            if(j+1 != arr[j]){
                missingNo = j+1;
                break;
            }
        }

        return missingNo;
    }
}
