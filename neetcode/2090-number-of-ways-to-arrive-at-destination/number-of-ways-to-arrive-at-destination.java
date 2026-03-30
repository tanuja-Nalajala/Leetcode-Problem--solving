class Solution {
    class Pair{
        int node;
        long dist;
        Pair(int node, long dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod = 1_000_000_007;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            adj.add(new ArrayList<>());
        }

        for(int[]road : roads){
            adj.get(road[0]).add(new int[] {road[1], road[2]} );
            adj.get(road[1]).add(new int[] {road[0], road[2]});
        }

        Queue<Pair> q = new PriorityQueue<>((a,b) -> Long.compare(a.dist, b.dist));

        q.add(new Pair(0,0));
         long [] dist = new long[n];
         Arrays.fill(dist, Long.MAX_VALUE);
         dist[0] = 0;

        int [] ways = new int[n];
        ways[0] = 1;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            long d = p.dist;
            if(d > dist[node])  
                continue;
            for(int [] adjN : adj.get(node)){
                int nextNode = adjN[0];
                int edgW = adjN[1];
                if(edgW + d < dist[nextNode]){
                    dist[nextNode] = edgW + d;
                    ways[nextNode] = ways[node];
                    q.add(new Pair(nextNode, edgW + d));
                }else if(edgW + d == dist[nextNode]){
                    ways[nextNode] = (ways[nextNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1];
    }
}