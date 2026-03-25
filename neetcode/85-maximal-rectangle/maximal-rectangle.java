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
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int [][] prefix = new int[rows][cols];
        for(int j = 0; j < cols; ++j){
            int sum = 0;
            for(int i = 0; i < rows; ++i){
                if(matrix[i][j] == '1')
                    sum += 1;
                if(matrix[i][j] == '0') sum = 0;
            prefix[i][j] = sum;
            }
        }
        int maxArea = 0;
        for(int i = 0; i < rows; ++i){
                maxArea = Math.max(maxArea, largestRectangleArea(prefix[i]));
        }
        return maxArea;
    }
}