class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //subarray sum >= target
        //return 0 on failure
        //else length
        
        //minimal length
        //l & r pointers, when sum >= target ==> note length
        //shrink window
        int l = 0, r = 0;
        int n = nums.length;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while(r < n){
            sum += nums[r];
            while(sum >= target){
                if(minLength > r -l +1){
                    minLength = r - l + 1;
                }

                sum -= nums[l];
            l++;
            }
        r++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}