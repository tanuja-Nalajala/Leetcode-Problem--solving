class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[]dp = new int[n+1];
        Arrays.fill(dp, 1);

        int [] count = new int[n];
        Arrays.fill(count, 1);
        int index = 0, maxi = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j] && dp[i] < 1+dp[j]){
                    dp[i] = 1+dp[j];
                    count[i] = count[j]; 

                }else if(nums[j] < nums[i] && 1+dp[j] == dp[i]){
                    count[i] += count[j];
                }

            }
            if(dp[i] > maxi){
                maxi = dp[i];
                index = i;
            }
        }

        int ans = 0;
        for(int i = 0; i < n; ++i){
            if(dp[i] == maxi){
                ans += count[i];
            }
        }
        return ans;
        
    }
}