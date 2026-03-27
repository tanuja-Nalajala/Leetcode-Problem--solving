class Solution {
    boolean solve(String s, String p, int i, int j, int m, int n, Boolean[][]dp){
        if(i == m && j == n) return true;
         if(j >= n ) return false;
        if( i >= m){
            //if endings are * or J
            while(j < n){
                if(p.charAt(j) != '*') return false;
                else j++;
            }
            return true;
        }

        if(dp[i][j] != null)
            return dp[i][j];

        boolean ans = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            ans = solve(s, p, i+1, j+1, m, n, dp);
        }else if(p.charAt(j) == '*'){
            //take as empty
            ans = solve(s, p, i, j+1, m, n, dp)
            //one char match
           || solve(s, p, i+1, j+1, m, n, dp)

            //more than on ematches
            || solve(s, p, i+1, j, m, n, dp);
        }else ans = false;

    return dp [i][j] = ans;

    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean [][] dp = new Boolean[m+1][n+1];
        return solve(s, p, 0,0, m, n, dp);
    }
}