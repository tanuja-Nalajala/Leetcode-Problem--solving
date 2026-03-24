class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> nge = new HashMap<>();
        int n = nums2.length;
        for(int i = n-1; i>= 0; --i){
            while(!stk.isEmpty() && stk.peek() <= nums2[i] )
                stk.pop();
                
            if(stk.isEmpty() == true)
                nge.put(nums2[i],-1); 
            else 
                nge.put(nums2[i],stk.peek());
            stk.push(nums2[i]);    
        }
        int [] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; ++i){
            res[i] = nge.get(nums1[i]);
        }
        return res;
    }
}