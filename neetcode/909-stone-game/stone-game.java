class Solution {
    int solve(int[]piles, int ind, int last, int n, int [][]dp){
        if(ind > last ) return 0;

        if(dp[ind][last] != -1) return dp[ind][last];

        int choiceOne = 0, choiceTwo = 0;
        //choice-1 : Max Alice can make if Alice picks either (0 / n-1)
        choiceOne = piles[ind] - solve(piles, ind + 1,last, n, dp);
        choiceTwo = piles[last] - solve(piles, ind, last - 1, n, dp);

        return dp[ind][last] = Math.max(choiceOne, choiceTwo);

    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int [][] dp = new int[n][n];
        for(int i = 0; i < n; ++i) Arrays.fill(dp[i], -1);

        int ans = solve(piles, 0, n-1, n, dp); 
        return (ans > 0) ? true : false;
       
        //two pointer = Greedy doesnot work 
        //==>piles = [3,2,10,4]
        // int i = 0, j = n-1;
        // int alice = 0, bob = 0;
        // while(i < j){
        //     if(piles[i] > piles[j]){
        //         alice += piles[i];
        //         i++;
        //     }else{
        //         alice += piles[j];
        //         j--;
        //     }

        //     if(piles[i] > piles[j]){
        //         bob += piles[i];
        //         i++;
        //     }else{
        //         bob += piles[j];
        //         j--;
        //     }

        // }
        // return (alice > bob) ? true : false;
    }
}