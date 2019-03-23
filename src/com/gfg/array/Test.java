package com.gfg.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String S = br.readLine();
            int Q = Integer.parseInt(br.readLine().trim());
            String[] arr_x = br.readLine().split(" ");
            int[] x = new int[Q];
            for(int i_x=0; i_x<arr_x.length; i_x++)
            {
                x[i_x] = Integer.parseInt(arr_x[i_x]);
            }
            String[] arr_y = br.readLine().split(" ");
            int[] y = new int[Q];
            for(int i_y=0; i_y<arr_y.length; i_y++)
            {
                y[i_y] = Integer.parseInt(arr_y[i_y]);
            }

            int out_ = solve(y, x,Q, S);
            System.out.println(out_);
            System.out.println("");
        }

        wr.close();
        br.close();
    }


    static int solve(int[] y, int[] x,int Q, String S){
        int a=0,b=0;
        int sum=0;
        // Write your code here
        for (int i = 0; i <Q ; i++) {
            a=x[i];
            b=y[i];
            String xpoint="";
            String ypoint="";
            if(a>0)
                xpoint = IntStream.range(0, a).mapToObj(j -> "R").collect(Collectors.joining(""));
            else
                xpoint = IntStream.range(0, Math.abs(a)).mapToObj(j -> "L").collect(Collectors.joining(""));

            if(b>0)
                ypoint = IntStream.range(0, b).mapToObj(j -> "U").collect(Collectors.joining(""));
            else
                ypoint = IntStream.range(0, Math.abs(b)).mapToObj(j -> "D").collect(Collectors.joining(""));

            String subStr= xpoint + ypoint;
            //String str2= ypoint + xpoint;
            if(subStr.isEmpty())
                sum+=1;
            else
                sum += search(subStr,S);
        }
        return  sum;
    }

    static int search(String subStr, String S) {
        int MAX = 26;
        int M = subStr.length();
        int N = S.length();
        if(M>N)
            return 0;
        int[] countSub = new int[MAX];
        int[] countS = new int[MAX];
        for (int i = 0; i < M; i++) {
            (countSub[subStr.charAt(i)-'A'])++;
            (countS[S.charAt(i)-'A'])++;
        }

        for (int i = M; i < N; i++) {

            if (Arrays.equals(countSub, countS))
                return 1;
            (countS[S.charAt(i)-'A'])++;

            countS[S.charAt(i - M) -'A']--;
        }
        if (Arrays.equals(countSub, countS))
            return 1;
        else return 0;
    /*    if(countS['D'-'A']>=countSub['D'-'A'] &&
                countS['L'-'A']>=countSub['L'-'A'] &&
                countS['R'-'A']>=countSub['R'-'A'] &&
                countS['U'-'A']>=countSub['U'-'A'] )
            return 1;
        else
            return 0;*/
    }
}
