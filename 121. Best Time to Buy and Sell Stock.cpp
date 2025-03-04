class Solution {
    public:
        int maxProfit(vector<int>& prices) {
            int profit = 0;
            int max_profit = 0;
            int min_price = prices[0]; 
            for( int  i = 1; i < prices.size(); ++i){
                profit = prices[i] - min_price;
                max_profit = max(max_profit, profit);
                min_price = min(prices[i], min_price);
            }
            return max_profit;
        }
    };