class Solution {
    int solve(int []nums, int ind, int target, int [][] dp){
        if(target == 0) return dp[ind][target] = 1;
        if(ind == 0){
            return nums[ind] == target ? 1 : 0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];

        int notPick = solve(nums, ind - 1, target, dp );
        int pick = 0;
        if(nums[ind] <= target) pick = solve(nums,ind - 1, target - nums[ind], dp );
        return dp[ind][target] = (pick == 1 || notPick == 1) ? 1 : 0;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
       
        for(int i = 0; i < n; ++i) sum += nums[i];
        if(sum % 2 != 0) return false;
        int target = sum/2;
         int [][] dp = new int[n][target + 1];
         for(int i = 0; i < n; ++i) Arrays.fill(dp[i], -1);

        int ans = solve(nums, n-1, target, dp);
        return ans == 1 ? true : false;
    }
}