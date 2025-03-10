// time complexity: n* mlog m
//spacecomplexity : n*m

class Solution {
    public:
        vector<vector<string>> groupAnagrams(vector<string>& strs) {
            map<string, vector<string>>mp;
            vector<vector<string>>ans;
    
            for(string str : strs){
                string temp = str;
                sort(temp.begin(), temp.end());
                mp[temp].push_back(str);
            }
    
            for(auto &it: mp){
                ans.push_back(it.second);
            }
            return ans;
        }
    };