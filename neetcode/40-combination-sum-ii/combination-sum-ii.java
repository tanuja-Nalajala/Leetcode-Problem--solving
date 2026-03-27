class Solution {
    List<List<Integer>> ans;
    void solve(int[] candidates, int ind, int target, List<Integer>set){
        if(target == 0){
            ans.add(new ArrayList<>(set));
            return;
        }
        if(ind >= candidates.length || target < 0)
            return;
        
        //pick
        for(int i = ind; i < candidates.length; ++i){
            if(i > ind && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) break;
            set.add(candidates[i]);
            solve(candidates, i+1, target - candidates[i], set);

        //remove
            set.remove(set.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        ans = new ArrayList<>();

        solve(candidates, 0, target, new ArrayList<>());
        return ans;
    }
}