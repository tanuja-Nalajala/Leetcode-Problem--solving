class Solution {
    int solve(int[]prices, int ind, int buy, int[][][]dp, int n, int k){
        if(k == 0 || ind == n) return 0;
        int profit = 0;
        if(dp[ind][buy][k] != -1) return dp[ind][buy][k];
        if(buy == 1){
            //transaction 
            profit = Math.max( -prices[ind] + solve(prices, ind + 1, 0, dp, n, k), 0 + solve(prices, ind + 1, 1, dp, n, k) );
        }else{
            profit = Math.max( prices[ind] + solve(prices, ind + 1, 1, dp, n, k-1), 0 + solve(prices, ind + 1, 0, dp, n, k) );

        }
        return dp[ind][buy][k] = profit;

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][]dp = new int[n][2][3];
        for(int i = 0; i < n;  ++i){
            for(int j = 0; j < 2; ++j)
            Arrays.fill(dp[i][j], -1);
        }
        //buy == 1 ==>buying is allowed
        return solve(prices, 0, 1, dp, n, 2);
    }
}