class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //binary search
        //start : 00 
        //end :: mn
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1;
        while(start <= end){
            int mid = (end - (end - start) / 2);

            //mid = 5 
            //rows : 3
            //cols = 4;
            //i : mid / cols : 1
            //j : mid% cols; 1
            int i = mid/cols;
            int j = mid % cols;
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target){
                start = mid + 1;
            }
            else end = mid - 1;

        }
        return false;
    }
}