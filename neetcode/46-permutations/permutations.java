class Solution {
    List<List<Integer>> ans;
    void solve(int []nums, List<Integer>set, int [] freq){
        if(set.size() == nums.length){
            ans.add(new ArrayList<>(set));
            return;
        }
        for(int i = 0 ; i < nums.length; ++i){
            if(freq[i] == 0){
                freq[i] = 1;
                set.add(nums[i]);

                solve(nums, set, freq);

                freq[i] = 0;
                set.remove(set.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        ans = new ArrayList<>();
        int [] freq = new int[n];
            solve(nums, new ArrayList<>(), freq);
        return ans;
    }
}