class Solution {
    public int trap(int[] height) {
        //at each i ==> we can store water if there exists a max > curr on its right and left
        //and the amount of water i can store is min(leftmax, rightmax ) - curr;
        //compute lefmax and right max at each index
        int n = height.length;

        int [] prefixMax = new int[n];
        int [] sufMax = new int[n];
        // prefixMax[0] = height[0];
        // for(int i = 1; i < n; ++i){
        //     prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        // }
        sufMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; --i){
            sufMax[i] = Math.max(sufMax[i+1], height[i]);
        }
        int water = 0;
        int leftMax = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i){
            leftMax = Math.max(leftMax, height[i] );
            int rightMax = sufMax[i];
            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }
}