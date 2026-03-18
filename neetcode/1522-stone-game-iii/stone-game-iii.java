class Solution {
    int solve(int[] stoneValue, int ind, int n, int[]dp){
        if(ind >= n) return 0;
        int ans = Integer.MIN_VALUE;
        if(dp[ind] != -1) return dp[ind];
        int secondChoice = 0, thirdChoice = 0;
            ans = Math.max(ans, stoneValue[ind] - solve(stoneValue, ind + 1, n, dp));
            if(ind + 1 < n) 
                ans = Math.max( ans, (stoneValue[ind] + stoneValue[ind + 1]) - solve(stoneValue, ind + 2, n, dp) );
            if(ind + 2 < n) 
                ans  = Math.max(ans, (stoneValue[ind] + stoneValue[ind + 1] + stoneValue[ind + 2]) - solve(stoneValue, ind + 3, n, dp) );

            return dp[ind] = ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        //dp[i] => represents max_possible difference b/w Alice and bob, if alice pick (1 to 3) stones in ith turn
        int [] dp = new int[n+ 1];
            Arrays.fill(dp, -1);
        int ans = solve(stoneValue, 0, n, dp);
        if(ans > 0) 
            return "Alice";
        else if(ans == 0) 
            return "Tie";
        else
             return "Bob";
    }
}