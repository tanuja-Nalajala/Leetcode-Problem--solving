class Solution {
    class Pair{
        int row;
        int col;
        int distance;

        Pair(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int rows =  mat.length;
        int cols = mat[0].length;

        int [][] dist = new int[rows][cols];
        int [][] vis = new int[rows][cols];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i< rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    dist[i][j] = 0;
                    q.add(new Pair(i,j, 0));
                }
            }
        }
        int [][] dir = {
            {1,0}, {0,1}, {-1,0}, {0,-1}
        };
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int d = curr.distance;
            for(int[] nbr : dir){
                int nr = r + nbr[0];
                int nc = c + nbr[1];
                if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && vis[nr][nc] != 1 ){
                    vis[nr][nc] = 1;
                    dist[nr][nc] = d + 1;
                    q.add(new Pair(nr, nc, d+1));
                }
            }
        }
        return dist;
      }
}