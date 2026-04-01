class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : t.toCharArray()){ //tc : o(t.length)
            mp.put(ch, mp.getOrDefault(ch, 0)+1); //o(t.length)
        }

        int l = 0, r = 0;
        int counter = 0;
        int minLength = Integer.MAX_VALUE;
        int startIdx = -1;
        //intuition for each char found in s, decrement counter in t, and track of how many char match found;
        //when a all occurrneces found (charmatch counter == t.length)=> store this as possible string
        //now i will decrement my l pointer until my valid counter exists
         while(r < s.length()){ //o)n
            char rc = s.charAt(r);
            if(mp.getOrDefault(rc,0) > 0){
                //matching char found
                counter++;
            }
            //decrement counter
            mp.put(rc, mp.getOrDefault(rc, 0)-1);
            while(counter == t.length()){
                if(r - l + 1 < minLength){
                    minLength = r - l + 1;
                    startIdx = l;
                }
            //decrement l pointer to find minimum substring in the current window
                char lc = s.charAt(l);
                mp.put(lc, mp.getOrDefault(lc, 0)+1);
                if(mp.get(lc) > 0)
                    counter--;
                l++;
            }
            r++;
        }
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLength);
    }
}