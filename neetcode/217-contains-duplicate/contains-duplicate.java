class Solution {
    public boolean containsDuplicate(int[] nums) {


        // HashMap<Integer, Integer> hm = new HashMap<>();

        // for(int i = 0; i < nums.length; ++i){
        //     int key = nums[i];
        //     if(hm.containsKey(key)) return true;

        //     else hm.put(key, i);
        // }
        // return false;


        Set<Integer> st = new HashSet<>();

        for(int i = 0; i < nums.length; ++i){
            int key = nums[i];

            if(st.contains(key)) return true;

            st.add(key);
        }
        return false;
    }
}