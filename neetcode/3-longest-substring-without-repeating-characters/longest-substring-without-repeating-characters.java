class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, r = 0, maxLength = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while(r < n){
            if(mp.containsKey(s.charAt(r)) == true && mp.get(s.charAt(r)) >= l ) {
                l = mp.get(s.charAt(r)) + 1;
            }
        mp.put(s.charAt(r), r);
        maxLength = Math.max(maxLength, r - l +1);
        r++;    
        }
    return maxLength;
    }
}