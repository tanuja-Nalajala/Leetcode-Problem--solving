class Solution {
    public:
        bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
            //topological sort
    
            vector<vector<int>>adj(numCourses);
            for(auto i : prerequisites){
                int p = i[1];
                int q = i[0];
                adj[p].push_back(q);
            }
    
            vector<int> indegree(numCourses, 0);
            for(int i = 0; i < numCourses; ++i){
                for( auto it: adj[i]){
                    indegree[it]++;
                }
            }
    
            queue<int>q;
            for(int i = 0; i < numCourses; ++i){
                if(indegree[i] == 0)
                    q.push(i);
            }
            vector<int> topo;
            while(!q.empty()){
                int course = q.front();
                topo.push_back(course);
                q.pop();
    
                for( auto it: adj[course]){
                    indegree[it]--;
                    if(indegree[it] == 0 )
                        q.push(it);
                }
            }
    
            if(topo.size() == numCourses)
                return true;
            else return false;
    
        }
    };