//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public int max_courses(int n, int total, int cost[]) {
        int dp[][] = new int[n+1][total+1];
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=total; j++) {
                if(cost[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], 1 + dp[i-1][j - cost[i-1] + (int)(cost[i-1]*0.9)]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][total];
    }
}

