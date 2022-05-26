package com.gfg.company;

public class GFG {
    static int minPlatform(int arrival[],
                           int departure[],
                           int n)
    {

        // As time range from 0 to 2359 in
        // 24 hour clock, we declare an array
        // for values from 0 to 2360
        int[] platform = new int[2361];
        int requiredPlatform = 1;

        for(int i = 0; i < n; i++)
        {

            // Increment the platforms for arrival
            ++platform[arrival[i]];

            // Once train departs we decrease
            // the platform count
            --platform[departure[i] + 1];
        }

        // We are running loop till 2361 because
        // maximum time value in a day can be 23:60
        for(int i = 1; i < 2361; i++)
        {

            // Taking cumulative sum of platform
            // give us required number of
            // platform fro every minute
            platform[i] = platform[i] +
                    platform[i - 1];
            requiredPlatform = Math.max(requiredPlatform,
                    platform[i]);
        }
        return requiredPlatform;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = arr.length;

        System.out.println("Minimum Number of " +
                "Platforms Required = " +
                minPlatform(arr, dep, n));
    }
}
