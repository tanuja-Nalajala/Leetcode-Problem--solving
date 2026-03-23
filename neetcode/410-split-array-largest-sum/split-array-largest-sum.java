class Solution {
    boolean canSplit(int[]nums, int sum, int k){
        int arrayCount = 1, subArraySum = 0; 
        for(int i : nums){
            //need to find a subarrays such a way that max_possible sum is mid 
            if(subArraySum + i <= sum){
                subArraySum += i;
            }else{
                //i found a subarray with sum <= mid
                arrayCount++;
                subArraySum = i;
            }
        }
        return arrayCount <= k;
    }
    public int splitArray(int[] nums, int k) {
        //minimum possible sum of subarray is : min(nums)
        //largets possible sum of subarray is : sum(nums)

        //check for sum ==> min ->sum
        //check sub array with sum = mid is possible
        //so mid is one of possibility
        //then i will check minimized sum is possible
        //so i will move left
        //if minimized sum is not possible ==> mid +1
        int low = Integer.MIN_VALUE, sum = 0;
        for(int i : nums){
            low = Math.max(low, i);
            sum += i;
        }

        int high = sum, ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canSplit(nums, mid, k) == true){
                //check if array has k subarrays with sum = mid
                //yes==> check for any minimum possible ==> move left
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}