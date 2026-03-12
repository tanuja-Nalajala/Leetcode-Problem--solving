class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        boolean [][] dp = new boolean [n][n];

        int counter = 0;
        //1 length palindromes;
        for(int i = 0; i < n; ++i){
            dp[i][i] = true;
            counter++;
        }

        //>=2 length
        for(int i = n-2; i >= 0; --i){
            for(int j = n-1; j > i; --j){
                if(s.charAt(i) == s.charAt(j)){
                    //2 length string & >2 length
                    if(j -i ==1 || dp[i+1][j-1] == true){
                        dp[i][j] = true;
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}
