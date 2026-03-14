class Solution {
    int solve(int []coins, int amount, int ind, int[][]dp){
        if(ind == 0){
            if( amount % coins[0] == 0) return 1;
            else return 0; 
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];

        int notPick = solve(coins, amount, ind-1, dp);
        int pick = 0;
        if(coins[ind] <= amount) pick = solve(coins, amount - coins[ind], ind, dp);
        return dp[ind][amount] = pick + notPick;
    }
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int[][] dp = new int [n][amount+ 1];
        for(int i  = 0; i < n; ++i)
            Arrays.fill(dp[i], -1);
        return solve(coins, amount, n-1, dp);
    }
}