class Solution {
    void DFS(char[][] grid, int i, int j, boolean [][] visited, int m, int n){
        if(i < 0 || j < 0 || i >=m || j >= n || visited[i][j] == true || grid[i][j] == '0') return;

        visited[i][j] = true;
        //down, right
        // DFS(grid, i+1, j, visited, m, n);
        // DFS(grid, i, j+1, visited, m, n);
        // DFS(grid, i-1, j,visited, m, n);
        // DFS(grid, i, j-1, visited, m, n);
        int [][] dir = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };

        for(int [] d : dir){
            int nr = i + d[0];
            int nc = j + d[1];
            DFS(grid, nr, nc, visited, m, n);
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n =  grid[0].length;

        boolean [][] visited = new boolean [m][n];
        int counter = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == '1' && visited[i][j]== false){
                    counter ++;
                    DFS(grid, i, j, visited, m, n);
                }
            }
        }
        return counter;
    }
}