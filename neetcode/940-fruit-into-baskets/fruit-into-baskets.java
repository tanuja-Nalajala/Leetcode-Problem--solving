class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = fruits.length;
        int l = 0,  r = 0, max_length = 0;
        while(r < n){
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0)+ 1);
            while(mp.size() > 2){
                mp.put(fruits[l], mp.get(fruits[l])-1 );
                if(mp.get(fruits[l]) == 0){
                    mp.remove(fruits[l]);
                }
                l++;
            }
            max_length = Math.max(max_length, r-l+1);
        r++;
        }
        return max_length;
    }
}