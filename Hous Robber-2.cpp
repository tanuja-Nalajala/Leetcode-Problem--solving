class Solution {
    public:
        int solve(int i,  int n, vector<int>&nums, vector<int>&dp){
            // if( i >= n) {
            //     return 0;
            // }
            // if(dp[i] != -1)
            //     return dp[i];
    
            // int pick = nums[i] + solve(i+2, n, nums, dp);
            // int not_pick = 0 + solve(i+1, n, nums, dp);
    
            // return dp[i] = max(pick, not_pick);
    
            int prev2 = 0;
            int prev1 = nums[0];
    
            for(int i = 1; i < n; ++i){
                int prev = max(prev2 + nums[i], prev1);
                prev2 = prev1;
                prev1 = prev;
            }
            return prev1;
        }
        int rob(vector<int>& nums) {
            int n = nums.size();
            vector<int>temp1, temp2;
            vector<int>dp1(n-1,-1);
            vector<int>dp2(n-1, -1);
            if(n == 1 ) return nums[0];
    
            for(int i = 0; i < n; ++i ){
                if(i != 0 )
                    temp1.push_back(nums[i]);
                if(i != n-1) temp2.push_back( nums[i] );
            }
            return max(solve(0, n-1, temp1, dp1), solve(0, n-1, temp2, dp2) );
        }
    };