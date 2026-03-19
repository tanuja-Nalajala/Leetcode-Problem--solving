class Solution {
    public int lastStoneWeightII(int[] stones) {
        //partition array into 2 subsets that sumof sets is minimum

        //s1-ts-s2 : min ==>ts - 2s1 ==> s1 == ts/2
        int n = stones.length;
        int ts = 0;
        for(int i : stones) ts += i;
        int target = ts/2;
        int [][] dp = new int[n+1][target + 1];
        for(int i = 0; i < n; ++i) dp[i][0] = 1;
        if(stones[0] <= target ) dp[0][stones[0]] = 1;

        for(int i = 1; i < n; ++i){
            for(int j = 1; j <= target; ++j){
                int pick = 0, notPick = 0;
                if(j >= stones[i]){
                    pick = dp[i-1][j - stones[i]];
                }
                notPick = dp[i-1][j];
                dp[i][j] = pick == 1 || notPick == 1 ? 1 : 0;
            }
        }
        for(int i = target; i >= 0; --i){
            if(dp[n-1][i] == 1){
                return ts - (2 * i);
            }
        }
        return 0;
    }
}