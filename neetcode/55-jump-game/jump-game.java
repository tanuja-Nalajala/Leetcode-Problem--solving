class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        //at each index we check what max_ind i can jummp to
        // if i am at ith index which is greater than max_ind: means i know that ith index is not reachable

        int max_length = 0;
        for(int i = 0; i < n; ++i){

            if(i > max_length) return false;
            max_length = Math.max(max_length, i + nums[i]);
        }
        return true;
    }
}