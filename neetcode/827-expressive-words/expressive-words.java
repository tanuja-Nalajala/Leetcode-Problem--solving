class Solution {
    boolean solve(String s, String w, int index1, int index2){
        int sLen = s.length();
        int wLen = w.length();

        if(index1 == sLen && index2 == wLen) return true;
        if(index1 == sLen || index2 == wLen) return false;
        int i = index1, j = index2;
        char sChar = s.charAt(i), wChar = w.charAt(j);

        if(sChar != wChar) return false;

        while(i < sLen && s.charAt(i) == sChar) i++;
        while(j < wLen && w.charAt(j) == wChar) j++;

        if(i - index1 < j - index2 ) return false;
        if(i - index1 > j - index2 && i - index1 < 3) return false;
        return solve(s,w,i,j);

        
    }
    public int expressiveWords(String s, String[] words) {
        
        int ans = 0;
        for(String w : words){
            if(solve(s,w,0,0) == true) ans++;
        }
    return ans;
    }
}