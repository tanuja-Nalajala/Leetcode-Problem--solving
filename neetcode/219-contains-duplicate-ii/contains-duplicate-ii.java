class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        
        //with no extra data structure
      
        // for(int i = 0; i < n; ++i){
        //     for(int j = i+1; j <= i + k && j < n;  ++j){
        //         if(nums[i] == nums[j]) return true;
        //     }
        // }
        // return false;
        Set<Integer> set = new HashSet<>();
        int j = 0;
        for(int i = 0; i < n;++i){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if(i >= k ) set.remove(nums[i-k]);
        }
        return false;

    }
}