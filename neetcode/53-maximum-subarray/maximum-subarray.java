class Solution {
    public int maxSubArray(int[] nums) {
        //at each index i have 2 optioons
        //1. chose it part of prev sun ==> if it increases overall
        //2. start new sub array ==> 
        //
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int  i = 0; i < nums.length; ++i){
                sum += nums[i];
                maxSum = Math.max(sum, maxSum);

                if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}