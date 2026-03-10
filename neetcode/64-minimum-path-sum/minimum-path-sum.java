class Solution {
    int solve(int[][] grid, int i, int j, int[][]dp){
        if(i == 0 && j == 0) return dp[i][j] = grid[i][j];

        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        //up => i-1, j  ; left => i, j-1

        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = grid[i][j] + Math.min(solve(grid, i-1, j, dp), solve(grid, i, j-1, dp)); 

    }
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int [][] dp = new int [rows][cols];
        for(int i = 0; i < rows; ++i) Arrays.fill(dp[i], -1);

        return solve(grid, rows-1, cols-1, dp);
    }
}