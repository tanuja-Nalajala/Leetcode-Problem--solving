class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int minLength = Integer.MAX_VALUE, start_indx = -1, counter = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; ++i){
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0)+1);
        }
        int l = 0, r = 0;
        while(r < m){
            char rc = s.charAt(r);
            if(mp.getOrDefault(rc, 0) > 0)
                counter++;
            mp.put(rc, mp.getOrDefault(rc, 0)-1);
            while(counter == t.length()){
                //we found substring with t; but will check for minimum by  shrinking from l
                if(minLength > r - l + 1){
                    minLength = r - l + 1;
                    start_indx = l;
                }
                char lc = s.charAt(l);
                mp.put(lc, mp.getOrDefault(lc, 0) + 1);
                if(mp.get(lc) > 0){
                    //means we losing a match
                    counter--;
                }
                l++;
            }
        r++;
        }
        return start_indx == -1 ? "":s.substring(start_indx, start_indx + minLength);

    }
}