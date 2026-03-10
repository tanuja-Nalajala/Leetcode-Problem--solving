class Solution {
    int solve(int i, int j, int m, int n, int [][]dp){
        if(i == 0 && j == 0 ) return dp [i][j] = 1;
        
        if(i < 0 || j < 0 || i >= m || j >= n ) return 0;
        //top = i -1,j ; //left : i,j-1
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = solve(i-1, j, m, n, dp) + solve(i , j-1, m, n, dp);
        
    }
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m][n];
        for(int i = 0; i < m; ++i) Arrays.fill(dp[i], -1);
        return solve(m-1, n-1, m, n, dp);
    }
}