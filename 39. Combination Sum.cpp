class Solution {
    public:
        void solve(int i, vector<int>&candidates, int target, int n, vector<vector<int>>&ans, vector<int>&res){
            if(target == 0) {
                ans.push_back(res);
                return;
            }
            if(i >= n || target < 0 ) return ;
            
            
           
            res.push_back(candidates[i]);
            solve(i,candidates, target - candidates[i], n, ans, res);
    
            res.pop_back();
            solve(i+1,candidates, target, n, ans, res);
        }
        vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
            vector<vector<int>>ans;
            vector<int>res;
            int len = candidates.size();
            
            solve(0,candidates, target, len, ans, res);
            return ans;
        }
    };