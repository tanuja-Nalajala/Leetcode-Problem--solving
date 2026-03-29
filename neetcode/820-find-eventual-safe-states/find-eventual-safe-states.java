class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        int n = graph.length;
        int[]indegree = new int[n];
        for(int i = 0; i < n; ++i){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < graph[i].length; ++j){
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; ++i){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int adjNode : adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0)
                    q.add(adjNode);
            }
        }
        Collections.sort(ans);
        return ans;

    }
}