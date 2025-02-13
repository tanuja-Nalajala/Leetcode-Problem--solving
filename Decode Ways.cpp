class Solution {
    public:
        int solve(int i, string s, int n, vector<int>&dp){
            if(i == n)
                return  1;
            if(s[i] == '0' ) 
                return 0;
            if (dp[i] != -1)
                return dp[i];
    
            int ways =  solve(i+1, s, n, dp);
            if(i+1 < n && ( s[i] == '1' || (s[i]=='2' && s[i+1] <='6'))){
                ways += solve(i+2, s, n, dp);
            }
            return dp[i]=ways;
            
        }
        int numDecodings(string s) {
            int n = s.length();
            vector<int> dp(n, -1);
            
            return solve(0, s,n, dp);
        }
    };