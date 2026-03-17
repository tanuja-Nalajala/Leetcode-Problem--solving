class Solution {
    int solve(int [] prices, int ind, int buy, int[][]dp, int n){
        if(ind == n) return 0;
        int profit = 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        if(buy == 1){
            profit  = Math.max(-prices[ind] + solve(prices, ind + 1, 0, dp, n), 0 + solve(prices, ind + 1, 1, dp, n));
        }else{
            profit = Math.max( prices[ind] + solve(prices, ind + 1, 1, dp, n), 0 + solve(prices, ind + 1, 0, dp, n));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        //at each index -> i can chose to buy(if my buy ois allowed)
        //or i can chose to sell (if buy is already done)
        int [][] dp = new int[n][2];
        for(int i = 0; i < n; ++i)
            Arrays.fill(dp[i], -1);

        //buy = 1 ==> buy is allowed
        return solve(prices, 0, 1, dp, n);
    }
}