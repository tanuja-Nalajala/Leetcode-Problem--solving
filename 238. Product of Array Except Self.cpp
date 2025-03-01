// Time complexity : n
//Space Complexity: n


class Solution {
    public:
        vector<int> productExceptSelf(vector<int>& nums) {
            int n = nums.size();
            vector<int> ans(n, 1);
            int prod = 1;
            for(int i = 0; i < n; ++i){
                ans[i] = prod ;
                prod = nums[i] * prod; 
            }
            prod = nums[n-1];
            for(int i = n-2; i >=0; --i){
                ans[i] *=  prod;
                prod *= nums[i];
            }
            return ans;
    
        }
    };