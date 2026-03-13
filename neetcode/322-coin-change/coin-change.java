class Solution {
    int solve(int[]coins, int ind, int amount, int[][]dp){
        if(ind == 0){
            if(amount % coins[0] == 0){
                return amount / coins[0];
            }else{
                return (int)1e9;
            }
        }

        if(dp[ind][amount] != -1) return dp[ind][amount];
        //can chose to pick ith coin / or not
        int notPick = 0 + solve(coins, ind - 1, amount, dp);
        int pick = Integer.MAX_VALUE;
        //can pick a coin only if it is less than amount
        if(coins[ind] <= amount) pick = 1 + solve(coins, ind, amount - coins[ind],dp);
        return dp[ind][amount] = Math.min(pick, notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;
        int[][] dp = new int[n][amount + 1];
        for(int i = 0; i < n; ++i) Arrays.fill(dp[i], -1);
        int ans = solve(coins, n-1,amount,dp);
        return ans == 1e9 ? -1 : ans;
    }
}