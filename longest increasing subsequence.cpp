class Solution {
    public:
        int solve(int ind, int prev, vector<int>&nums, vector<vector<int>>&dp, int n){
            if(ind >= n)
                return 0;
            if(dp[ind][prev+1] != -1){
                return dp[ind][prev+1];
            }
            int pick=0, not_pick = 0;
            if(prev ==-1 || nums[ind] > nums[prev])
                pick = 1+ solve(ind+1, ind, nums, dp, n );
            not_pick = 0 + solve(ind+1, prev, nums, dp, n);
        
            return dp[ind][prev+1] = max(pick, not_pick);
        }
        int lengthOfLIS(vector<int>& nums) {
            int n = nums.size();
            vector<vector<int>>dp(n, vector<int>(n+1, -1));
            return solve(0, -1, nums, dp, n);
        }
    };