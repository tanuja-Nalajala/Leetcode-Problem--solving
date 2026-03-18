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
        int [] dp = new int[n+ 3];
            //Arrays.fill(dp, -1);
        // int ans = solve(stoneValue, 0, n, dp);
        // if(ans > 0) 
        //     return "Alice";
        // else if(ans == 0) 
        //     return "Tie";
        // else
        //      return "Bob";

        for(int  ind = n-1; ind >= 0; --ind){
            //if alice picks stone-1 => alice-count - (max_count of bob can make with remaining stones)
              int ans = Integer.MIN_VALUE;
                ans = Math.max(ans, stoneValue[ind] - dp[ind + 1] );
            //if alice picks 2stones => alice-count - (max_count bob can make with remaining stones)
            if(ind + 1 < n) 
                ans = Math.max( ans, (stoneValue[ind] + stoneValue[ind + 1]) - dp[ind + 2] );
            if(ind + 2 < n) 
                ans  = Math.max(ans, (stoneValue[ind] + stoneValue[ind + 1] + stoneValue[ind + 2]) - dp[ind + 3] );

            dp[ind] = ans;
        }
        if(dp[0] > 0) 
            return "Alice";
        else if(dp[0] == 0) 
            return "Tie";
        else
             return "Bob";
    }
}