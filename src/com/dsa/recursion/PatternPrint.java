package com.dsa.recursion;



public class PatternPrint {
    public static void main(String[] args) {
        printPattern(4,0);
    }

    private static void printPattern(int r, int c) {
        if( r== 0)
            return;
        if(c < r){
            System.out.print("*");
            printPattern(r,c+1);
        }else{
            System.out.println();
            printPattern(r-1,0);
        }
    }
}
