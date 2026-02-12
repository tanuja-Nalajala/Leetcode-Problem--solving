class Solution {
    public int[] twoSum(int[] nums, int target) {

        // approach - 1: take a hashmap to store numbers with indexes. 
        // checks if target- curr is already in the list; -> return curr.key and taget-curr.key else, push to map;
        //Time complexity : n
        //space: n -> worst

        HashMap<Integer, Integer> mp = new HashMap<>();

        int n = nums.length;
        for(int i = 0; i < n; ++i){
            int curr = nums[i];
            int remain = target - nums[i];
            if(mp.containsKey(remain)){
                return new int[] { mp.get(remain), i};
            }
                mp.put(curr, i);
        }
        return new int[] {-1 ,-1};
        
    }
}