class Solution {
    int solve(int [][]matrix, int i, int j, int m, int n, int [][]dp){
       
       if( i < 0 || j < 0 || i >= m || j >= n) return (int)1e9;
       if(i == m - 1 ) return matrix[i][j];

    if(dp[i][j] != -1) return dp[i][j];
       int diagLeft = matrix[i][j] + solve(matrix, i+1, j-1, m, n, dp);
       int down = matrix[i][j] + solve(matrix, i+1, j, m, n, dp);
       int diagRight = matrix[i][j] + solve(matrix, i+1, j+1, m, n, dp);

        return dp[i][j] =  Math.min(diagLeft, Math.min(down, diagRight));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int [][] dp = new int [m][n];
        for(int i = 0; i < m; ++i) Arrays.fill(dp[i], -1);


        // int ans = Integer.MAX_VALUE;
        // for(int col = 0; col < n; ++col){
        //     ans = Math.min(ans, solve(matrix, 0, col, m, n, dp));
        // }

        for(int i = 0; i < n; ++i) dp[0][i] = matrix[0][i];

        int diagLeft = 0, down = 0, diagRight = 0;
        for(int i = 1; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(j > 0) diagLeft = matrix[i][j] + dp[i-1][j-1];
                else diagLeft = (int)1e9;
                down = matrix[i][j] + dp[i-1][j];
                if(i > 0 && j < n - 1) 
                    diagRight = matrix[i][j] + dp[i-1][j+1];
                else diagRight = (int)1e9;
                dp[i][j] = Math.min(diagLeft, Math.min(down, diagRight));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i){
            ans = Math.min(ans, dp[m-1][i]);
        }
        return ans;
    }
}