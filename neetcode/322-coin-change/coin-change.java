class Solution {
    int solve(int[] coins,int i, int amount, int[][] dp){
        if(i == 0){
            if(amount % coins[i] == 0) 
                return amount / coins[i];
            else return (int)1e9;
        }

        if(dp[i][amount] != -1) return dp[i][amount];

        int notPick = 0 + solve(coins,i-1, amount, dp);
        int pick = Integer.MAX_VALUE;
        if(coins[i] <= amount) pick = 1+ solve(coins, i, amount-coins[i], dp);
        return dp[i][amount] = Math.min(pick , notPick);
    }
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;

        int [][] dp = new int[n][amount + 1];
        for(int i = 0; i< n; ++i) Arrays.fill(dp[i], -1);

        if(amount == 0 ) return 0;

        for(int i = 0; i< n; ++i){
            dp[i][0] = 0;
        }
        int ans = solve(coins,n-1, amount, dp);
        return (ans != 1e9)? ans : -1;  
        
    }
}