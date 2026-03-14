class Solution {
    int dfs(int [][] matrix, int i, int j, int[][]dp, int [][]dir, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int length = 1;
        for(int [] d : dir){
            int nr = i + d[0];
            int nc = j + d[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] > matrix[i][j]){
                length = Math.max(length, 1 + dfs(matrix, nr, nc, dp, dir, m, n));
            }
        }
        return dp[i][j] = length;
        

    }
    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        
        //at each i,j will construct a dfs and use memoization
        int [][] dp = new int [m][n];
        for(int i = 0; i < m; ++i) Arrays.fill(dp[i], -1);
        int [][] dir = {
            {0,1}, {1,0}, {-1,0},{0,-1}
        };
        int ans = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                ans = Math.max(ans, dfs(matrix, i, j,dp, dir, m, n));
            }
        }
         return ans;
    }
}