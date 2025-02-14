class Solution {
    public:
        bool solve(string s, int n, unordered_set<string>&mp, map<string,bool>&dp){
            if(s.empty())
                return true;
            if(dp.find(s) != dp.end())
                return dp[s];
            
            for(int i = 1; i <= n;++i){
                if((mp.find(s.substr(0,i))!=mp.end()) && solve(s.substr(i, n-i),n-i,mp, dp))
                    return dp[s] = true;
            }
            return dp[s] = false;
        }
        bool wordBreak(string s, vector<string>& wordDict) {
            
            int n = s.length();
            if(n == 0)  return true;
            //int dict_len = wordDict.size();
            unordered_set<string>mp (wordDict.begin(), wordDict.end());
            map<string,bool>dp;
            return solve(s, n, mp,dp);
    
        }
    };