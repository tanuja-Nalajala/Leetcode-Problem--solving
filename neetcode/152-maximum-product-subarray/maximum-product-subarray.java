class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int [] maxi = new int [n];
        int [] mini = new int [n];

        for(int i = 0; i < n; ++i){
            maxi[i] = nums[i];
            mini[i] = nums[i];
        }

        //p tracks the max in maxi, q tracks the min in minimum
        int p = nums[0], q = nums[0], ans = nums[0];
        for(int i = 1; i < n; ++i ){
            maxi[i] = Math.max(nums[i], Math.max(p * nums[i], q * nums[i]));
            mini[i] = Math.min(nums[i], Math.min(p * nums[i], q * nums[i]));
            
            p = maxi[i];
            q = mini[i];
            System.out.println(p);
            System.out.println(q);

            ans = Math.max(ans, p);
            System.out.println(ans + "*");

        }
        return ans;

    }
}