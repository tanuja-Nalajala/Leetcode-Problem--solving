class Solution {
    int [] uParent;
    int [] rank;
    int [] size;
    class DisjointSet{
        DisjointSet(int n){
            uParent = new int[n];
            rank = new int[n];
            size = new int[n];
            for(int i = 0; i < n; ++i){
                uParent[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }
        int findUltimateParent(int u){
            if(uParent[u] == u)
                return u;
            //path compression
            return uParent[u] = findUltimateParent(uParent[u]);
        }
        public void findUnionBySize(int u, int v){
            int ultParentU = findUltimateParent(u);
            int ultParentV = findUltimateParent(v);

            if(ultParentU == ultParentV)
                return;
            if(size[ultParentU] < size[ultParentV]){
                //attach u to v
                uParent[ultParentU] = ultParentV;
                size[ultParentV] += size[ultParentU];
            }else{
                uParent[ultParentV] = ultParentU;
                size[ultParentU] += size[ultParentV];   
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        //size of each component - 1 + (no.of components -1)
        //for each components => get its size and also keep track of total components
        if (connections.length < n - 1) return -1;
        DisjointSet ds = new DisjointSet(n);
        for(int  i = 0; i < connections.length; ++i){
            ds.findUnionBySize(connections[i][0], connections[i][1]);
        }
        int componentCount = 0, componentSize = 0, minedges = 0;
        for(int i = 0; i < n; ++i){
            if(uParent[i] == i){
                //component
                componentCount++;
                componentSize = size[i];
                minedges += componentSize - 1;
            }
        }
        return componentCount - 1;
    }
}