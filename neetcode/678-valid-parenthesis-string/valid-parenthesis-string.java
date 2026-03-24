class Solution {
    // boolean solve(String s, int ind, int n, int count, int []dp){
    //     if(ind == n ){
    //         return count == 0;
    //     }
    //     if(count < 0) return false;
    //     boolean open = false, close = false, aster = false;
    //     if(dp[ind] )
    //     //if '('
    //     if( s.charAt(ind) == '(' )
    //          open = solve(s, ind+1, n, count+1);
    //     if( s.charAt(ind) == ')' )
    //          close = solve(s, ind+1, n, count - 1);
    //     if( s.charAt(ind) == '*' )
    //          aster = solve(s, ind+1, n, count + 1) || solve(s, ind+1, n, count -1) 
    //                         || solve(s, ind+1, n, count);
    // return dp[ind] = open || close || aster;
    // }
    public boolean checkValidString(String s) {
        int n = s.length();
        // int count = 0;
        // int [] dp = new int [n];
        // Arrays.fill
        // return solve(s, 0, n, count, dp);
        int max= 0, min = 0;
        int i = 0;
        while(i < n){
            char ch = s.charAt(i);
            if(ch == '('){
                min = min+1;
                max = max+1;
            }
            else if(ch == ')'){
                min = min - 1;
                max = max - 1;
            }else{
                min = min - 1;
                max = max + 1;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        i++;
        }
        return min == 0;
    }
}