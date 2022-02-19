package algos.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class KnapsackTopDown {
    public static void main(String args[]) throws IOException {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //reading total testcases
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());

            int val[] = new int[n];
            int wt[] = new int[n];

            String st[] = read.readLine().trim().split("\\s+");

            //inserting the values
            for (int i = 0; i < n; i++)
                val[i] = Integer.parseInt(st[i]);

            String s[] = read.readLine().trim().split("\\s+");

            //inserting the weigths
            for (int i = 0; i < n; i++)
                wt[i] = Integer.parseInt(s[i]);

            //calling method knapSack() of class Knapsack
            System.out.println(new SolutionTopDown().knapSack(w, wt, val, n));
        }
    }
}

class SolutionTopDown {

    static int arr[][];
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        arr = new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            for(int j = 0;j<W+1;j++){
                if(i==0 || j==0) {
                    arr[i][j] = 0;
                    continue;
                }
                int origIdx=i-1;
                if(wt[origIdx]<=j){
                    arr[i][j]= Math.max((val[origIdx]+arr[i-1][j-wt[origIdx]]),arr[i-1][j]);
                }else{
                    arr[i][j]=arr[i-1][j];
                }
            }
        }
        return arr[n][W];
    }



}
