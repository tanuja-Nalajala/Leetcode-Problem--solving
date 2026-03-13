class Solution {
    int DFS(int [][]grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1 ) return 0;

        grid[i][j] = 0;
        int [][] dir = {
            {1,0}, {0,1}, {-1, 0}, {0,-1}
        };
        int ans = 1;
        for(int[] d : dir){
            int nr = i + d[0];
            int nc = j + d[1];
            ans += DFS(grid, nr, nc, m, n);
        }
        return ans;

    }
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        boolean [][] visited = new boolean [rows][cols];

        int maxArea = 0;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(grid[i][j] == 1 && visited[i][j] != true){
                    int area = DFS(grid, i, j, rows, cols);
                    maxArea = Math.max(area, maxArea);
                }   
            }
        }
        return maxArea;
    }
}