package com.dsa.recursion;

import java.util.ArrayList;

public class StringPermutationInPlace {
    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println(permutation(str).toString());
    }
    static ArrayList<String> permutation(String S){
        ArrayList<String> arr = new ArrayList<>();
        String str="";
        helper(0,arr,S,str);
        return arr;
    }

    public static void helper(int val, ArrayList<String> arr, String S, String str){
        if(val==S.length()){
            arr.add(str);
            return;
        }
        if(val != 0) helper(val+1,arr,S,str+" "+S.charAt(val));
        helper(val+1,arr,S,str+S.charAt(val));
    }

}
