class Solution {
    public boolean canJump(int[] nums) {
        int max_length = 0;
        for(int i = 0; i < nums.length; ++i){
            if(i > max_length) return false;
            max_length = Math.max(max_length, i + nums[i]);
        }
        return true;
    }
}