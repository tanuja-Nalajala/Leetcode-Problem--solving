class Solution {
    int[] getPSE(int[]heights){
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        int [] nums = new int[n];
        for(int i = 0; i < n; ++i){
            while(!stk.isEmpty() && heights[i] <= heights[stk.peek()]){
                stk.pop();
            }
            nums[i] = stk.isEmpty() ? -1 : stk.peek();
        stk.push(i);
        }
        return nums;
    }
    int[] getNSE(int[]heights){
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        int [] nums = new int[n];
        for(int i = n-1; i>=0; --i){
            while(!stk.isEmpty() && heights[i] <= heights[stk.peek()]){
                stk.pop();
            }
            nums[i] = stk.isEmpty() ? n : stk.peek();
        stk.push(i);
        }
        return nums;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nse = getNSE(heights);
        int[] pse = getPSE(heights);
        int maxArea = 0;
        for(int i = 0; i < heights.length; ++i){
            //get index of left & right smaller elements 
            int nsi = nse[i];
            int psi = pse[i];

            int area = (nsi - psi - 1) * heights[i];

            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}