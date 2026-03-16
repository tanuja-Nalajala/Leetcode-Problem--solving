class Solution {
    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        // int i = 0, j  = 0;
        // length = 0, max_freq = 0
        // if lentgh - maxfreq <= k ==> valid 
        // max_length = length;
        // if(length - max freq > k) ==> needs to more than k changes
        // I need to move my window
        // i will keep moving my window untill i found a valid length string (lentgh - maxfreq <= k)

        //needs to keep track of max_freq
        int [] freq = new int[26];
        int length = 0, max_length = 0, max_freq = 0;
        int r = 0, l = 0;
        while(r < n){
            freq[s.charAt(r) - 'A'] = freq[s.charAt(r) - 'A'] + 1;
            max_freq = Math.max(max_freq, freq[s.charAt(r) - 'A']);
            length = r - l + 1;
            //invalid
            //length = 5 max_freq = 2
            while(length - max_freq > k){
                //update window ==> l++
                //decrement freq of char at l
                //also find new max_freq
                freq[s.charAt(l)-'A']--;
                 max_freq = 0;
                for(int i = 0; i < 26; ++i){
                   max_freq = Math.max(max_freq, freq[i]);
                }
                l++;
                length = r - l + 1;
            }
            max_length = Math.max(max_length, length);

        r++;    
        }
        return max_length;
    }
}