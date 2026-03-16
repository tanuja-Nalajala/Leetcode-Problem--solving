class Solution {
    void DFS(char[][] board, int[][]vis, int i, int j, int[][]dir, int m, int n){
            
            if(i < 0 || i >= m || j < 0 || j >= n || vis[i][j] == 1 || board[i][j] == 'X') return;

            vis[i][j] = 1;

            for(int [] d : dir){
                int nr = i + d[0];
                int nc = j + d[1];
                DFS(board, vis, nr, nc, dir, m, n);
            }

    }
    public void solve(char[][] board) {
        
        //if cell[i][j] == x next
        //if(cell [i][j] == 0) {
            // 4 directions
            // nr, nc ==>will check cell[nr][nc] == 0 && nr, nc > 0 & < n-1 
        int m = board.length;
        int n = board[0].length;
        int [][] vis = new int[m][n];
        int [][]dir = {
            {1,0}, {0,1}, {-1, 0}, {0,-1}
        };
        for(int i = 0; i < m; ++i){
            
            if(board[i][0] == 'O' && vis[i][0] == 0){
                
                DFS(board, vis, i, 0, dir, m, n);
            }
            if(board[i][n-1] == 'O' && vis[i][n-1] == 0)
            {
                
                DFS(board, vis, i, n-1,dir, m, n);
            }
            
        }

        for(int j = 0; j < n; ++j){
            
            if(board[0][j] == 'O' && vis[0][j] == 0){
                DFS(board, vis, 0, j, dir, m, n);
            }
            if(board[m-1][j] == 'O' && vis[m-1][j] == 0)
            {
                DFS(board, vis, m-1, j, dir, m, n);
            }
        }

        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(board[i][j] == 'O' && vis[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    
    }
}