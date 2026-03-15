class Solution {
    int solve(String s, String p, int i, int j, int[][]dp){

        //base case
        if(i < 0 && j < 0) return 1;
        if(j < 0) return 0;

        if(i < 0){
            if(p.charAt(j) == '*'){
                return ( j > 0 && solve(s, p, i, j-2, dp) == 1) ? 1 : 0;
            }
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int x = 0, y = 0, z = 0;
        if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')
                x =solve(s, p, i-1, j-1, dp);

        if(j > 0 && p.charAt(j) == '*'){
            //i should keep my j pointer hold
            //and decr i untill all the p[j] chars processed

            //0 occurence als
                y = solve(s, p, i, j - 2, dp);
            //1 or more occurrence
            if( s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                y = ( ( y == 1) || (solve(s, p, i - 1, j, dp) == 1) )? 1 : 0;
            }
            
        }
        

        return dp[i][j] = (x == 1 || y == 1) ? 1 : 0 ;     
    }
    public boolean isMatch(String s, String p) {
        
        //for a given pattern i nedd to see all the possible strings
        // if any one of these strinf matches given string i will return true

        //* --> ind - 1 string has 2 choices 
        //a* ---> {}, {a, {aa}, {aaa}}

        //j = n-1 and i : m-1
        //I will check what p[j-1] ==> * then p[j-2] == s[j-1] ==> { include or not include

        //f(i = m-1, j = n-1){
            //p[j] == *
                //(j >= 1 && p[j-1] == s[i] ) 
                    //j will be at n-2 at i will move my pointer  ==>
                    //f(i-1, n-2)
            //}
            //p[j] == .
                //(j >= 1 && p[j-1] == s[i] ) f(i-1, j-1);

            //p[j] == s[i] f(i-1, j -1);

            //base case
            //i < 0 return 1;

            int m = s.length();
            int n = p.length();

            int [][] dp = new int[m][n];
            for(int i = 0; i < m; ++i) Arrays.fill(dp[i], -1);
            
        return (solve(s, p, m-1, n-1, dp) == 1) ? true : false ;
    }
}