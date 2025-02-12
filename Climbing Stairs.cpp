class Solution {
    public:
        int solve(int i, int n, vector<int>&dp){
            if(i < 0)
                return 0;
            if(i == 0) 
                return dp[i] = 1 ;
            if(dp[i] != -1)
                return dp[i];
            return dp[i] =  solve(i-1, n, dp) + solve(i-2, n, dp);
        }
        int climbStairs(int n) {
            vector<int>dp(n+1,-1);
            //return solve(n,n, dp);
            
            // dp[0] = 1;
            // dp[1] = 1;
            // for( int i = 2; i <= n; ++i){
            //     dp[i] = dp[i-1] + dp[i-2];
            // } 
            // return dp[n];
    
            int prev2 = 1;
            int prev1 = 1;
            int prev = 0;
            for(int i = 2; i <= n; ++i){
                prev = prev1 + prev2;
                prev2 = prev1;
                prev1 = prev;
            }
            return prev1;
    
    
        }
    };