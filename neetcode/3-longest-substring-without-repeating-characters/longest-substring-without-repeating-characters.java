class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int l = 0, r = 0;
        int length = 0, maxLength = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while(r < n){
            char rc = s.charAt(r);
            //is curr char is already seen && is it in the current window(l to r)
            //if no => curr char is not duplicate in the current window
            if(mp.containsKey(rc) == true && mp.get(rc) >= l){
                //i found a duplicate character
                //need to update my window
                l = mp.get(rc) + 1;
            }
            mp.put(rc, r);
            maxLength = Math.max(maxLength, r - l + 1);
        r++;
        }
        return maxLength;
    }
}