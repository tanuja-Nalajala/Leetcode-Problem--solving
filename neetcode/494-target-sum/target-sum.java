class Solution {
    int solve(int []nums, int ind, int target, int[][]dp){
        //to find subset whose sum is target

        //base case : ind = 0;
        if(ind == 0){
            if(target == 0 && nums[0] == target) return 2;
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];
        int notPick = solve(nums, ind-1, target, dp);
        int pick = 0;
        if(nums[ind] <= target) pick = solve(nums, ind-1, target - nums[ind], dp);

        return  dp[ind][target] = pick + notPick;    
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;


        //needs to divide into 2 ubsets such their difference is equal to target
        // this is possible only when : sum1 - sum2 = target
        //total_sum - sum2 - sum2 = target
        //total_sum - target / 2 = sum2
        //needs to find a subset with sum = (total_sum - target / 2) 

        //costrains : total_sum >= target & total_sum - target must be even
        int totalSum = 0;
        for(int i = 0; i < n; ++i) totalSum += nums[i]; 

        if(totalSum < target || (totalSum - target) % 2 != 0) return 0;

        int subsetSum = (totalSum - target) / 2;
        int[][] dp = new int[n][subsetSum + 1];
        for(int i = 0; i < n; ++i) Arrays.fill(dp[i], -1);
        return solve(nums, n-1, subsetSum, dp);

    }

}