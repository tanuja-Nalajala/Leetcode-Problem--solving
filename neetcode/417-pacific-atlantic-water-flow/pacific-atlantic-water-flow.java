class Solution {
    void DFS(int[][] board, int i, int j, int[][]ocean, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n || ocean[i][j] == 1) return;

        //vis[i][j] = 1;
        ocean[i][j] = 1;
        int [][] dir = {
            {0,1}, {1,0}, {-1,0}, {0, -1}
        };

        for(int [] d : dir){
            int nr = i + d[0];
            int nc = j + d[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && ocean[nr][nc] == 0 && board[nr][nc] >= board[i][j])
                DFS(board, nr, nc, ocean, m, n);
        }


    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];


        List<List<Integer>> ans = new ArrayList<>();

        //pacific is at top and left ; i =0 && j = 0
        for(int i = 0; i < m; ++i){
                if(pacific[i][0] == 0)
                DFS(heights, i, 0, pacific, m, n);
        }
        for(int j = 0; j < n; ++j){
                if(pacific[0][j] == 0)
                DFS(heights, 0, j, pacific, m, n);
        }

        //atlantic
        for(int i = 0; i < m; ++i){
                if(atlantic[i][n-1] == 0)
                    DFS(heights, i, n-1, atlantic, m, n);
        }
        for(int j = 0; j < n; ++j){

                if(atlantic[m-1][j] == 0)
                    DFS(heights, m-1, j, atlantic, m, n);
        }


        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(atlantic[i][j] == 1 && pacific[i][j] == 1){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;

    }
}