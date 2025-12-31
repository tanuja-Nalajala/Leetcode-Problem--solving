class Solution {
public:

    int checkMagic(int r, int c,vector<vector<int>>& grid){
        if(grid[r+1][c+1] != 5) return 0;

        bool seen[10] ={false};

        //check validity
        for(int i = r; i < r+3; ++i){
            for(int j = c; j < c+3; ++j){
                int val = grid[i][j];
                if(val < 1 || val > 9 || seen[val] ) return 0;
                seen[val] = true;
            }
        }

        for(int i = 0; i < 3; i++){
            if(grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2] != 15 ) return 0;
            if(grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i] != 15 ) return 0;
        }

        if(grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != 15 ) return 0;
        if(grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != 15 ) return 0;

        return 1;
    }
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        //edge case
        int ans = 0;
        if( m < 3 || n < 3 ) return 0;
        
        for(int i = 0; i + 2 < m; i++){
            for(int j = 0; j + 2 < n; ++j){
                if(checkMagic(i, j, grid)){
                    ans++;
                }
            }
        }
        return ans;
    }
};