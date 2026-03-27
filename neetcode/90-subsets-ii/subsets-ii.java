class Solution {
    Set<List<Integer>> ans;
    void solve(int[]nums, int ind, List<Integer>set){
        if(ind == nums.length){
            ans.add(new ArrayList<>(set));
            return;
        }
        set.add(nums[ind]);
        solve(nums, ind+1, set);

        set.remove(set.size() - 1);
        solve(nums, ind+1, set);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new HashSet<>();
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return new ArrayList(ans);
    }
}