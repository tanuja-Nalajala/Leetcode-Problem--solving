class Solution {
    public:
        void dfs(int i, int parent, vector<int>&vis, vector<vector<int>>&adj){
            vis[i] = 1;
                for(auto it: adj[i]){
                    if(!vis[it]){
                        if(dfs(it, i, vis, adj));
                    }
                    else if(it != parent)
                        return true;
                }
                return false;
    
        }
        bool validTree(int n, vector<vector<int>>& edges) {
            //topological sort
            vector<vector<int>>adj(n);
    
            vector<int>vis(n,0);
            for(auto it: edges){
                int p = edges[0];
                int q = edges[1];
                adj[p].push_back(q);
                adj[q].push_back(p);
            }  
            if(dfs(0, -1, vis, adj))
                return false;
            
                    
    
        }
    };
    