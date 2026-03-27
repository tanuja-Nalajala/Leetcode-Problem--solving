class Solution {
    List<List<Integer>> ans;
    void solve(int[]candidates, int ind, int n, int sum, List<Integer>set){
    if(ind >= n || sum < 0) return;
        if(sum == 0){
                ans.add(new ArrayList<>(set));
                return;
        }
            set.add(candidates[ind]);
            solve(candidates, ind, n, sum - candidates[ind],set );

            set.remove(set.size() - 1);
            solve(candidates, ind+1, n, sum, set);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        solve(candidates, 0, n, target, set);
        return ans;
    }
}