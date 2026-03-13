class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();

        //stores no.of ways to decode n length string
        int [] dp = new int [n + 1];

        dp[0] = 1; //decode as invalid;

        for(int i = 1; i <= n; ++i){
            
            //considering as single element
            //i : s[0...i-1] ==> 
            if(s.charAt(i-1) != '0') dp[i] = dp[i-1];

            //decoding as 2 digits ==> no trailing 0's && <= 26
            //length should be atleast 2
            //previous element must not be = 0
            // i: s[0....i-1]i
            if(i > 1 && s.charAt(i-2) != '0'){
                //substring(i,j) =>s[i , j-1]
                //
                int twoDigitNumber = Integer.valueOf(s.substring(i-2, i));
                if(twoDigitNumber <= 26) dp[i] += dp[i-2];
            }
        }
        return dp[n];

    }
}