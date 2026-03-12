class Solution {
    
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0) return "";

        boolean [][]dp = new boolean [n][n];
        
        for(int i = 0; i < n; ++i) dp[i][i] = true;

        //i keep 2 pointers to track start and ending of substring that we are considering:
        //when i say dp[1][3] => im checking s[1..3] is palindrome or not.
        //dp[i][j] == true ==> if s[i] == s[j] && s[i+1] == s[j-1]
        //in dp table we need to cover cells i >= j; bcoz i: start & j : end

        //i goes from 0 to n-1
        //j goes from i + 1 to n-1

    //to keep track of longest length i found so far ==> i will store the start index of that string and maximum_length; i will update my k only if i found a mx_length >= gobla_max

       //but to check dp[0...4] ==> i need to know dp[1][3]; dp[2][4] ===> top cells depends on the bottom cells.
       //so i will go with bottom up approach.

       //my i : will start from n-2 (i = n-1, j= n-1 is the only cells in last row, which is true & npo other cell needs to taken care)
       int k = 0, maxLength = 1;
        for(int i = n-2; i>=0; --i){
            for(int j = n-1; j > i; --j){
                if(s.charAt(i)== s.charAt(j)){
                    //need to check inner elements
                    if( j-i == 1 || dp[i+1][j-1] == true){
                        dp[i][j] = true;
                        int currLength = (j - i) + 1;
                        if(currLength > maxLength){
                            maxLength = currLength;
                            k = i;
                        }
                    }
                }else dp[i][j] = false;
            }
        }

        return s.substring(k, k + maxLength);

        
    }
}