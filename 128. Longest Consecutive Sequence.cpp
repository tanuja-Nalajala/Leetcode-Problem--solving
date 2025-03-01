// Time: n
// space: n

class Solution {
    public:
        int longestConsecutive(vector<int>& nums) {
            set<int>mp(nums.begin(),  nums.end());
            
            int ans ;
            int max_ans = 0;
            for(int it: mp){
                
                if(mp.find(it -1) == mp.end() ){
                    ans =1;
    
                    while(mp.find(it+1) != mp.end() ){
                        ans++;
                        it++;
                    }
                }
                max_ans = max(max_ans, ans);
            }
            return max_ans;
        }
    };