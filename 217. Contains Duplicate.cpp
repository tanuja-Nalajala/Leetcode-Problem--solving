class Solution {
    public:
        bool containsDuplicate(vector<int>& nums) {
            map<int, int>mp;
            //int n = nums.size();
            for(int i : nums){
                if(mp.find(i) != mp.end() ) return true;
                else mp[i]++;
            }
            return false;
        }
    };