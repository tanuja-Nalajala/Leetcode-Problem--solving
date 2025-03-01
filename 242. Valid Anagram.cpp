class Solution {
    public:
        bool isAnagram(string s, string t) {
            map<char, int>mp;
            for(char ch : s){
                mp[ch]++;
            }
            for(char ch: t){
                if(mp.find(ch) == mp.end()) return false;
                else{
                    mp[ch]--;
                }
            }
            for(auto i:mp){
                if(i.second) return false;
            }
            return true;
        }
    };