class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, length = 0, maxFreq = 0, maxlength = 0;
        int [] hash = new int[256];
        int n = s.length();
        while(r < n){
            char rc = s.charAt(r);
            hash[rc - 'A']++;
            maxFreq = Math.max(maxFreq, hash[rc - 'A']);
            while(r - l + 1 - maxFreq > k){
                char lc = s.charAt(l);
                hash[lc - 'A']--;
                for(int i = 0; i < 26; ++i){
                    maxFreq = Math.max(maxFreq, hash[i]);
                }

            l++;
            }
            maxlength = Math.max(maxlength, r - l + 1);
        r++;
        }
        return maxlength;
    }
}