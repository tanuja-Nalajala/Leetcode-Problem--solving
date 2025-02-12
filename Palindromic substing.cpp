class Solution {
    public:
        int countSubstrings(string s) {
            int n = s.length();
            if(n == 0 ) return 0;
    
            vector<vector<bool>> dp(n, vector<bool>(n, 0));
            int res = 0;
             
            // length = 1 strings
            for( int  i = 0; i < n; ++i){
                dp[i][i] = 1;
                res++;
            }
    
            //length 2 strings
            for(int i = 0; i < n-1; ++i){
                    dp[i][i+1] = (s[i] == s[i+1]);
                    if(dp[i][i+1] )
                        res++;
            }
    
            // >3 length strings
            for(int len = 3; len <= n; ++len){
                for(int i = 0,j = i+len-1; j < n; ++i,++j){
                    if(s[i] == s[j] && dp[i+1][j-1]){
                        dp[i][j] = 1;
                        res++;
                    }
                }
            }
            return res;
        }
    };