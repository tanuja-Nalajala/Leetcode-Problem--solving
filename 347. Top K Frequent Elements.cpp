// Time complexity : nlogn
// Space complexity : n


class Solution {
    public:
        vector<int> topKFrequent(vector<int>& nums, int k) {
            map<int, int>mp;
            for(int i: nums){
                mp[i]++;
            }
            vector<int>ans;
            priority_queue< pair<int,int> >pq;
            for(auto &it: mp){  
                // takes logn
                pq.push({it.second, it.first});
            }
            while(k){
                ans.push_back(pq.top().second);
                //takes logn
                pq.pop();
                k--;
            }
            return ans;
        }
    };