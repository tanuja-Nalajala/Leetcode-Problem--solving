class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        if(k == 0) return false;
        for(int i = 0; i < nums.length; ++i){
            if(set.contains(nums[i])) return true;
            if(set.size() == k ){
                //remove element at i -k
                set.remove(nums[i-k]);
            }
            set.add(nums[i]);
        }
        return false;
    }
}