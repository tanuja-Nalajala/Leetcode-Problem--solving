class Solution {
    public int lengthOfLongestSubstring(String s) {

        //characters: A_Z?
        //empty string? possible? yes -> return value?0:-1
        //approach: lets starts with 1 lenth substring -> increase pointer until existing /seen character surfaces? update curr longest as max; update intial pointer to past(index+1) of seen char;

        // time complexity: O(n), SC: i need a array of 100 to track sysmbols

        int n = s.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        if(n == 0) return 0;
        //System.out.println(n);

        int i = 0, j = 0;
        int ans = 0, local_max = 0;
        while(j < n ){
            char curr = s.charAt(j);
            if(mp.containsKey(curr) && mp.get(curr) >= i){
                int last_seen = mp.get(curr);
                i = last_seen + 1;
            }
            mp.put(curr, j);
            //local_max++;
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
        
    }
}