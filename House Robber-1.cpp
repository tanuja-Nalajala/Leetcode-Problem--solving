class Solution {
    public:
        int solve(int i, int prev, int n, vector<int>&nums, vector<int>&dp){
            if(i >= n ) return 0;
    
            if(dp[i] != -1)
                return dp[i];
            int   pick = nums[i] + solve(i+2, i, n, nums, dp);
              int  not_pick = 0 + solve(i+1, prev, n, nums, dp);
                return dp[i] = max(pick, not_pick);
           
    
        }
        int rob(vector<int>& nums) {
            int n = nums.size();
            vector<int>dp(n,-1);
            //return solve( 0, -1, n, nums, dp);
            
            if(n == 1) return nums[0];
            dp[0] = nums[0];
            dp[1] = max(nums[0] , nums[1]);
            for(int i = 2 ; i < n; ++i){
                dp[i] = max(dp[i-2]+nums[i] , 0+dp[i-1]);
            }
            return dp[n-1];
        }
    };