class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int l = 0, r = 0, length = 0, max_freq = 0, start_idx = 0, max_length = 0;
        int []hash = new int[256];
        while(r < n){
            char rc = s.charAt(r);
            hash[rc - 'A']++;
            max_freq = Math.max(max_freq, hash[rc - 'A']);
            
            while((r - l + 1) - max_freq > k){
                char lc = s.charAt(l);
                hash[lc - 'A']--;
                max_freq = 0;
                for (int c = 0; c < 26; c++) {
                    max_freq = Math.max(max_freq, hash[c]);
                }
                l++;
            }
            if((r - l + 1) - max_freq <= k)
                max_length = Math.max(max_length, r - l + 1);
            
        r++;
        }
        return max_length;
    }
}