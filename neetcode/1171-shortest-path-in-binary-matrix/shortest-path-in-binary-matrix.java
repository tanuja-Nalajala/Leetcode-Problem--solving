class Solution {
    class Pair{
        int row;
        int col;
        int cost;
        Pair(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(grid[0][0] == 1 || grid[rows -1][cols-1] == 1) return -1;
        int[][]vis = new int [rows][cols];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0, 1));

        vis[0][0] = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int len = p.cost;
            if(r == rows -1 && c == cols -1)
                return len;
            int [][] dir = {
                {1,0}, {0,1}, {-1, 0}, {0, -1}, {1,1}, {-1,1}, {-1, -1}, {1, -1}
            };

            for(int [] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 0 && vis[nr][nc] == 0 ){
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr, nc, len+1 ));
                }
            }
        }
        return -1;
    }
}