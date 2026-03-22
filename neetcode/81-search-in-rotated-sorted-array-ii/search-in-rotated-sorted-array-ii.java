class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while(l <= r ){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] == nums[l] && nums[r] == nums[mid]){
                l = l + 1;
                r = r - 1;
                continue;
            }
            if(nums[mid] <= nums[r]){
                //right half sorted
                if(nums[mid] < target && nums[r] >= target){
                    l = mid + 1;
                }else r = mid - 1;
            }else{
                // left half is sorted
                if(nums[mid] > target && nums[l] <= target)
                    r = mid - 1;
                else l = mid + 1;
            }
        }
        return false;
    }
}