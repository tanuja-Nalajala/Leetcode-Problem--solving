class Solution {
    public:
        int lengthOfLongestSubstring(string s) {
            
            int n = s.length();
    
            int i = 0,j = 0, ans = 0;;
            map<char, int>mp;
            for(int j = 0; j < n; ++j){
                int count = 0;
                if(mp.find(s[j]) != mp.end() && mp[s[j]] >= i ){
                    i = mp[s[j]] + 1;
                    //mp[s[j]] = j;
                }
                mp[s[j]] = j;
                count = j - i + 1;
                ans = max(ans, count);
            }
            return ans;
        }
    };