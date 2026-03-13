class Solution {
    int lcs(String t1, String t2, int [][]dp, int i, int j){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        if(t1.charAt(i) == t2.charAt(j)){
            return dp[i][j] = 1 + lcs(t1, t2, dp, i-1, j-1);
        }
        else {
            return dp[i][j] = Math.max(lcs(t1, t2, dp, i-1, j), lcs(t1, t2, dp, i, j-1));
        }

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int [][] dp = new int [n1][n2];
        for(int i = 0; i < n1; ++i) Arrays.fill(dp[i], -1);
        return lcs(text1, text2, dp, n1-1, n2-1);
    }
}