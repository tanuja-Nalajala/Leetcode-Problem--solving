class Solution {
    int solve(String s, String t, int i, int j, int m, int n, int[][]dp){
        //base case:
        if(j == n) return 1;
        if(i == m) return 0;

        if(dp[i][j] != -1) return dp[i][j];

            int pick = 0, notPick = 0;
            if(i < m && s.charAt(i) == t.charAt(j)){
                pick =  solve(s, t, i  + 1, j + 1, m , n, dp);
            }
                notPick =  solve(s,t, i + 1, j, m, n, dp);
            return dp[i][j] = pick + notPick;
    }
    public int numDistinct(String s, String t) {
        
        int m = s.length();
        int n = t.length();

        int [][] dp = new int [m+1][n+1];
        for(int i = 0; i < m; ++i) Arrays.fill(dp[i], -1);
        return solve(s,t,0, 0, m, n, dp);
        // for(int i = 0 ; i < m; ++i){
        //     dp[i]
        // }
        // for(int i = m-1; i >= 0; ++i){
        //     for(int j = n-1; j >= 0; ++j){
        //         if(s[i] == t[j]){
        //             //chose s[i] to be part of t or not 
        //             pick = dp[i-1][j-1];  
        //         }
        //         notPick = dp[i-1][j]

        //     }
        // }
    }
}