class Solution {
    public int minInsertions(String s) {
        //min insertions comes to s.length - longest palindromic subsequence
        //abcaa ==> (aaa) && bc is not matched ==> abcacba is palindrome ==> 2 insertions

        String rev = new StringBuilder(s).reverse().toString();

        char [] temp1 = s.toCharArray();
        char [] temp2 = rev.toCharArray();

        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n; ++i ){
            for(int j = 1; j <= n; ++j){
                if(temp1[i-1] == temp2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int maxLength = dp[n][n];

        return n - maxLength;
    }
}