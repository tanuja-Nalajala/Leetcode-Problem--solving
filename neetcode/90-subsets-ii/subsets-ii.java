class Solution {
    List<List<Integer>> ans;
    void solve(int[]nums, int ind, List<Integer>set){
        //if(ind == nums.length){
            ans.add(new ArrayList<>(set));
        //    return;
       // }
        for(int i = ind; i < nums.length; ++i){
            if(i > ind && nums[i] == nums[i-1]) continue;
                set.add(nums[i]);
                solve(nums, i+1, set);
                set.remove(set.size() - 1);   
        }
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return ans;
    }
}