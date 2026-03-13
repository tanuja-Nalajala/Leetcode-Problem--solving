class Solution {
    int solve(int []nums, int curr, int prev, int[][]dp, int n){

        //base case : curr > n -1
        if(curr > n-1) return 0;
        if(dp[curr][prev + 1] != -1) 
            return dp[curr][prev + 1];
        int notPick = 0 + solve(nums, curr+1, prev, dp, n);
        int pick = 0;
        if(prev == -1 || nums[curr] > nums[prev])
            pick = 1 + solve(nums, curr + 1, curr, dp, n);
        return dp[curr][prev + 1] = Math.max(notPick, pick);
    }
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int [][]dp = new int [n][n+1];
        //prev goes from -1 to n-1
        for(int i = 0; i < n; ++i) Arrays.fill(dp[i], -1);

        return solve(nums,0, -1,dp, n);
    }
}