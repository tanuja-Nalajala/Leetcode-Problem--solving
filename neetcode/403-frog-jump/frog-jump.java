class Solution {
    Boolean [][] dp;
    boolean solve(int []stones, int ind, int steps, Map<Integer, Integer> mp, int n){
        if(ind == n-1) return true;
        //if(steps == 0) return false;

        //3 possibilities steps -1, steps, steps+1
        //i can take next step only if there is a stone
        if(dp[ind][steps] != null)
            return dp[ind][steps];
        for(int k = steps - 1; k <= steps + 1; ++k){
            if(k > 0){
                if(mp.containsKey(stones[ind]+ k)){
                    int nextIndex = mp.get(stones[ind]+ k);
                        if(solve(stones, nextIndex, k, mp, n) == true)
                            return dp[ind][steps] = true;
                }
            }
        }
        return dp[ind][steps] = false;

    }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        dp = new Boolean[n][n + 1];
        Map<Integer, Integer> units = new HashMap<>();
        for(int i = 0; i < stones.length; ++i){
            units.put(stones[i], i);
        }
        
        return solve(stones, 0, 0, units, n);
    }
}