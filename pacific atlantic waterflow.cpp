class Solution {
    public:
        void dfs(int i, int j, vector<vector<int>>&vis, int m , int n, int prev_height, vector<vector<int>>&heights){
            if( i < 0 || j < 0 || i >= m || j >= n || heights[i][j] < prev_height || vis[i][j] ){
                return;
            }
            vis[i][j] = 1;
            dfs(i-1, j, vis, m, n, heights[i][j], heights);
            dfs(i+1, j, vis, m, n, heights[i][j], heights);
            dfs(i, j+1, vis, m, n, heights[i][j], heights);
            dfs(i, j-1, vis, m, n, heights[i][j], heights);
    
        }
        vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
            vector<vector<int>> result;
            int rows = heights.size();
            int cols = heights[0].size();
    
            vector<vector<int>>pac(rows, vector<int>(cols,0));
            vector<vector<int>>atl(rows, vector<int>(cols, 0));
    
            for(int i = 0; i < rows; ++i){
                //left
                //if(pac[i][0])
                    dfs(i, 0, pac, rows, cols, heights[i][0], heights);
                //right
                //if(atl[i][cols-1])
                    dfs(i, cols-1, atl, rows, cols, heights[i][cols-1], heights);
            }
    
            for(int j = 0; j < cols; ++j){
                //top
                //if(pac[0][j])
                    dfs(0, j, pac, rows, cols, heights[0][j], heights);
                //down
                //if(atl[rows-1][j])
                    dfs(rows-1, j, atl, rows, cols, heights[rows-1][j], heights);
            }
    
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    if(pac[i][j] && atl[i][j])
                        result.push_back({i,j});
                }
            }
                
            return result;
        }
    };