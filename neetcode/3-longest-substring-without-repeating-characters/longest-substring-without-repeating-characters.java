class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        int j = 0, maxLength = 0;
        for(int i = 0; i < n; ++i){
            
            if(mp.containsKey(s.charAt(i))){
                int last_index = mp.get(s.charAt(i));
                if(last_index >= j){
                    j = last_index + 1;
                }
            }
            mp.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i-j+1);
        }
        return maxLength;
    }
}