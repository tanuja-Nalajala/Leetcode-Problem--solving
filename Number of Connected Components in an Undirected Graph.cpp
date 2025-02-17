class Solution {
    public:
        void dfs(int i, vector<vector<int>>&adj, vector<int>&vis){
            vis[i] = 1;
            for(auto it: adj[i]){
                if(!vis[it])
                    dfs(it, adj,vis);
            }
    
        }
    
        int countComponents(int n, vector<vector<int>>& edges) {
    
            vector<vector<int>>adj(n);
            
            for(auto it: edges){
                int p = it[0];
                int q = it[1];
                adj[p].push_back(q);
                adj[q].push_back(p);
            }
            vector<int>vis(n, 0);
            int ans = 0;
            for(int i = 0; i < n; ++i){
                if(!vis[i]){
                    ans++;
                    dfs(i, adj, vis);
                }
            }
            return ans;
        }
    };
    