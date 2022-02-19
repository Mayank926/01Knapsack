package algos.dp;

import java.util.*;
import java.io.*;
import java.lang.*;



public class Knapsack01Rec
{

    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //reading total testcases
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());

            int val[] = new int[n];
            int wt[] = new int[n];

            String st[] = read.readLine().trim().split("\\s+");

            //inserting the values
            for(int i = 0; i < n; i++)
                val[i] = Integer.parseInt(st[i]);

            String s[] = read.readLine().trim().split("\\s+");

            //inserting the weigths
            for(int i = 0; i < n; i++)
                wt[i] = Integer.parseInt(s[i]);

            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends



class Solution
{
    static Map<Entry,Integer> map;
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        map= new HashMap<>();
        return knapSack01(W,wt,val,n);
    }

    static int knapSack01(int W, int wt[], int val[], int n){
        Entry entry = new Entry(W,n);
        if(map.containsKey(entry))
            return map.get(entry);
        if(n==0 || W==0)
            return 0;
        else if(wt[n-1]<=W) {
            int finalValue =Math.max(val[n-1] + knapSack01(W - wt[n-1], wt, val, n - 1),knapSack01(W, wt, val, n - 1) );
            map.put(entry,finalValue);
            return finalValue;
        }
        else {
            int value = knapSack01(W, wt, val, n - 1);
            map.put(entry,value);
            return value;
        }
    }

}

class Entry{
    int W;
    int n;

    public Entry(int w, int n) {
        W = w;
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return W == entry.W &&
                n == entry.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(W, n);
    }
}


