class Solution {
    int solve(String word1, String word2, int i, int j, int[][]dp){
    
        //converting empty string to w2 
        if(i < 0) return j + 1; //insertions

        //converting w1 to empty string : i+1 deleltions
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];
        //match
        int match = 0, insert = 0, replace = 0, delete  = 0, notMatch = 0;
        if(word1.charAt(i) == word2.charAt(j))
            return dp[i][j] = solve(word1, word2, i-1, j-1, dp);
        else{
            //3 options
            insert = 1 + solve(word1, word2, i, j-1, dp);
            replace = 1 + solve(word1, word2, i-1, j-1, dp);
            delete = 1 + solve(word1, word2, i-1, j, dp);
            return dp[i][j] = Math.min(insert, Math.min(replace, delete));
        }
        

        
    }
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];
        // for(int i = 0; i <=m; ++i) Arrays.fill(dp[i], -1);
        // return solve(word1, word2, m-1, n-1, dp);   

        for(int j = 0; j <= n; ++j)  
            dp[0][j] = j ;
        
        for(int i = 0; i <= m; ++i){
            dp[i][0] = i ;
        }
        int match = 0, insert = 0, replace = 0, delete  = 0, notMatch = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; ++j){
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1];
                else{
            //3 options
                        insert = 1 + dp[i][j-1];
                        replace = 1 + dp[i-1][j-1];;
                        delete = 1 + dp[i-1][j];;
                    dp[i][j] = Math.min(insert, Math.min(replace, delete));
                }
            }
        }
        return dp[m][n];

    }
}