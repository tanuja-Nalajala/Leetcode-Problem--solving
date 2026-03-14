class Solution {
    void DFS(int [][] image, int sr, int sc, int ele, int color, int m, int n){
        if(sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc] != ele || image[sr][sc] == color) return;
       
        image[sr][sc] = color;
        int [][] dir = {
            {1,0},{0,1},{-1,0},{0,-1}
        };
        for(int []d : dir){
            int nr = sr + d[0];
            int nc = sc + d[1];
            DFS(image, nr, nc, ele, color,m,n);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        //DFS
        int rows = image.length;
        int cols = image[0].length;
        int[][] vis = new int[rows][cols];
        int ele = image[sr][sc];
        DFS(image, sr, sc, ele, color, rows, cols);
        return image;
    }
}