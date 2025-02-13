class Solution {
    public:
        int maxProduct(vector<int>& nums) {
            int n = nums.size();
            if(n == 1 ) return nums[0];
            int max_prod=0;
            int fprod = 1;
            int bprod = 1;
            for( int i=0, j=n-1; i < n || j >= 0; --j,++i){
                if(fprod == 0)
                    fprod =1;
                if(bprod == 0)
                    bprod = 1;
                fprod *= nums[i];
                bprod *= nums[j];
                max_prod = max(max_prod, max(fprod, bprod));
            }
            return max_prod;
        }
    };