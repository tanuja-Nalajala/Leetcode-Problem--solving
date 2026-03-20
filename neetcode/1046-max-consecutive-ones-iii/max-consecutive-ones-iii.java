class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int zeroCounter = 0, maxLength = 0;
        int n = nums.length;

        while(r < n){
            if(nums[r] == 0)
                zeroCounter++;
            while(zeroCounter > k){
                if(nums[l] == 0){
                    zeroCounter--;
                }
                l++;
            }
            
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
    return maxLength;
    }
}