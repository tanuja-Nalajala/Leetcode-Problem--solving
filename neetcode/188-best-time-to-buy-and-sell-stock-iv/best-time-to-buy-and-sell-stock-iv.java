class Solution {
    int solve(int[]prices, int ind, int buy, int[][][][]dp, int n, int availBuy, int availSell){
        if(availBuy == 0 && availSell == 0 ) return 0;
        if(ind == n) return 0;
        int profit = 0;
        if(dp[ind][buy][availBuy][availSell] != -1) return dp[ind][buy][availBuy][availSell];
        if(buy == 1){
            profit = Math.max( - prices[ind]+ solve(prices, ind + 1, 0, dp, n, availBuy-1, availSell), 0 + solve(prices, ind + 1, 1, dp, n, availBuy, availSell) );
        }else{
            profit = Math.max( prices[ind]+ solve(prices, ind + 1, 1, dp, n, availBuy, availSell - 1), 0 + solve(prices, ind + 1, 0, dp, n, availBuy, availSell) );

        }
        return dp[ind][buy][availBuy][availSell] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][][] dp = new int[n][2][k+1][k+1];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < 2; ++j)
                for(int p = 0; p <= k; ++p)
                    Arrays.fill(dp[i][j][p], -1);
        }
        return solve(prices, 0, 1, dp, n, k, k);
    }
}