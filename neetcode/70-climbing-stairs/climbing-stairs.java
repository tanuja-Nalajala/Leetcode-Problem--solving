class Solution {
    int solve(int steps, int []dp){
        // if(steps == 0 ) return 1;
        // if(steps == 1) return 1;
        // return solve(steps - 1) + solve(steps - 2);
        if(steps == 0 || steps == 1) dp[steps] = 1;
        if(dp[steps] != -1) return dp[steps];
        return dp[steps] = solve(steps - 1,dp) + solve(steps - 2, dp);    
    }
    public int climbStairs(int n) {
    //recursion
            int []dp = new int [n + 1];
            Arrays.fill(dp,-1);
            //return solve(n, dp);
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= n; ++i ){
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
    }
}