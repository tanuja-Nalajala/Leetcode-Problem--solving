class Solution {
    int solve(String s1, String s2, String s3, int i, int j, int m, int n, int[][]dp){
        //base case
        if(i == m && j == n) return 1;
        //current index in s3
        if(dp[i][j] != -1) return dp[i][j];
        int k = i + j;
        int p = 0,q = 0;
        if(i < m && s1.charAt(i) == s3.charAt(k)) 
            p = solve(s1, s2, s3, i + 1, j, m, n,dp);
        if(j < n && s2.charAt(j) == s3.charAt(k)) 
            q = solve(s1, s2, s3, i, j + 1, m, n, dp);
        return dp[i][j] = (p == 1 || q == 1) ? 1 : 0;    

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        if(m + n != s3.length()) return false;

        //will start from 0 th index in s1, s2
        //checks s3[i+j] == s1[i ] ==> will pick from s1 and run recursion with next ind
        //same time time s3[i+j] == s2[j] ==> will pick here and run recursion
        
        //base case
        //i >= m && j >= m return true;

         int [][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; ++i) Arrays.fill(dp[i], -1);

        int ans = solve(s1, s2, s3, 0,0, m, n, dp);
        return (ans == 1) ? true : false;
    }
}
