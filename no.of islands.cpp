class Solution {
    public:
        void dfs(int i, int j, vector<vector<char>>&grid, int m, int n, vector<vector<int>>&visited){
            if( i < 0 || j < 0 || i >= m || j>= n || visited[i][j])
                return ;
            if( i >=0 && j >=0 && i < m && j < n && grid[i][j] == '1' && !visited[i][j]){
                visited[i][j] = 1;
                dfs(i-1, j, grid, m, n, visited);
                dfs(i+1, j, grid, m, n, visited);
                dfs(i, j-1, grid, m, n, visited);
                dfs(i, j+1, grid, m, n, visited);
            }
        }
        int numIslands(vector<vector<char>>& grid) {
            int m = grid.size();
            int n = grid[0].size();
    
            vector<vector<int>>visited(m, vector<int>(n, 0));
            int count = 0;
            for(int i=0; i < m; i++){
                for(int j = 0; j < n; ++j){
                    if(!visited[i][j] && grid[i][j])
                        count++;
                        dfs(i, j, grid, m, n, visited );
                }
            }
            return count;
        }
    };