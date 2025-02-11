class Solution {
    public:
        int solve(int i, int j, int m, int n, string text1, string text2, vector<vector<int>>&dp){
            
            for( int i = 1; i <= m; ++i){
                for(int j = 1; j <= n; ++j){
                    if(text1[i-1] == text2[j-1]){
                        dp[i][j] = 1+ dp[i-1][j-1]; 
                    }
                    else 
                        dp[i][j] = max(dp[i-1][j], dp[i][j-1] );
                }
            }
            return dp[m][n];
    
        }
        int longestCommonSubsequence(string text1, string text2) {
            
            int m = text1.length();
            int n = text2.length();
    
            vector<vector<int>>dp(m+1, vector<int>(n+1, 0));
            return solve(0, 0, m, n, text1, text2, dp);
        }
    };