class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if(n == 1) 
            return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int l = 1, r = n-2;
        while(l < n){
            int mid = l + (r-l)/2;

            //check peak is at mid 
            //nums[mid - 1] < nums[mid] > nums[mid + 1]
            if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
                return mid;
            //mid can be at decresing side of a peak (nums[mid - 1] > nums[mid]) (decresing side)
            //i need to move towards left
            else if(nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]) 
                r = mid - 1;
            else {
                //nums[mid -1] <= nums[mid]
                l = mid + 1;
            }
        }
        return -1;
    }
}