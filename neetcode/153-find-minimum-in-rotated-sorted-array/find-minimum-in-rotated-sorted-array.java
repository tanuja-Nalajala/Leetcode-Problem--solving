class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int l = 0, r = n-1, ans = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r-l)/2;
            
            //check for sorted half
            if(nums[mid] <= nums[r]){
                //right half sorted
                //pick minimum from sorted half
                ans = Math.min(ans, nums[mid]);
                
                //check for minimum in the not sorted half
                r = mid - 1;
            }
            else{
                ans = Math.min(ans, nums[l]);
                l = mid + 1;
            }
        }
        return ans;
    }
}