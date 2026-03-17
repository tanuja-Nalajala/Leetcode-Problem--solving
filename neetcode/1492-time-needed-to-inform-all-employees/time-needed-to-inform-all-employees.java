class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //construct adjacenvy
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            adj.add(new ArrayList<>() );
        }
        for(int i = 0; i < n; ++i){
            if(manager[i] != -1){
                adj.get(manager[i]).add(i);
            }
        }
       
        //bfs
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int [] {headID, 0});
        int ans = 0;
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int node = curr[0];
            int time = curr[1];
            ans = Math.max(ans, time);
            //time limit
            // for(int i = 0; i < n; ++i){
            //     if( manager[i] == node){
            //         q.offer(new int[] {i,time + informTime[node]});
            //     }
            // }
            for(int next : adj.get(node) ){
                q.offer(new int[]{next, time + informTime[node]});
            }
        }
        return ans;
    }

}