class Solution {
    void dfs(int node, List<List<Integer>> adj, int[]vis){
        if( vis[node] == 1) return;
        vis[node] = 1;
        for(int nbr : adj.get(node)){
            dfs(nbr, adj, vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            adj.add(new ArrayList<>());
        }

        //create adj list
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        int []vis = new int[n];
        int count = 0;
        for(int i = 0; i < n; ++i){
            if(vis[i] == 0){
                dfs(i, adj, vis);
                count++;
            }
        }
    return count;
     }
}