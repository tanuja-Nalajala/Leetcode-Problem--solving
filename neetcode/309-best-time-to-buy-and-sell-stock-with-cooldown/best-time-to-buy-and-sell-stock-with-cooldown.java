class Solution {
    int solve(int [] prices, int ind, int buy, int n, int[][]dp){
        //base case
        if(ind >= n) {
            //return the rofit 
            return 0;
        }
        //chose to buy
        if(dp[ind][buy] != -1 ) return dp[ind][buy];
        int profitBuy = 0,profitSell = 0;
        if(buy == 1){
            profitBuy = Math.max(-prices[ind] + solve(prices, ind+1, 0, n, dp), 0 + solve(prices, ind+1, 1, n, dp) );
        }
        else{
            profitSell = Math.max(+prices[ind] + solve(prices, ind + 2, 1, n, dp), 0 + solve(prices, ind+1, 0, n, dp)); 
        }
        return dp[ind][buy] = Math.max(profitBuy, profitSell);

    }
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int [][] dp = new int [n+2][2];
        for(int i = 0; i < n; ++i) Arrays.fill(dp[i], -1);

        return solve(prices, 0,1, n, dp);
    }
}