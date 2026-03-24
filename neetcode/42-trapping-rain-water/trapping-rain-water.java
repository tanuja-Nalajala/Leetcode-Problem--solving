class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int l = 0, r = n-1;

        int lmax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;
        int total = 0;

        while(l < r){
            if(height[l] <= height[r]){
                //water stored is limited by l
                //consider heigh[l] : 1 & height[r] : 2 ==> upto height 1 only
                if(lmax > height[l]){
                    //means i can store
                    total += lmax - height[l];
                }else
                    lmax = height[l];
            l++;
            }else{
                if(rMax > height[r]){
                    total += rMax - height[r];
                }else
                    rMax = height[r];
            r--;
            }
        }
        return total;
    }
}