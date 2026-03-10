class Solution {
    int solve(int [][]grid, int i, int j, int [][]dp ){
        if(i == 0 && j == 0 && grid[i][j] == 0 ) return dp[i][j] = 1;

        if(i < 0 || j < 0) return 0;
        if(grid[i][j] == 1) return dp[i][j] = 0;

        if(dp[i][j] != -1) return dp[i][j];
        //top = i-1, j; left: i, j-1
        return dp[i][j] = solve(grid, i-1, j, dp) + solve(grid, i, j-1, dp); 
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int [m][n];
        for(int i = 0; i < m; ++i) Arrays.fill(dp[i], -1);
        return solve(obstacleGrid, m-1, n-1, dp);
    }
}