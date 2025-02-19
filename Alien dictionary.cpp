class Solution {
    public:
        string foreignDictionary(vector<string>& words) {
            int n = words.size();
    
            //vector<char>adj[n];
            map<char, vector<char>>adj;
            set<char>st;
    
            for (const string &word : words) {
                for (char c : word) {
                    st.insert(c);
                }
            }
    
    
            for(int i = 0; i < n-1; ++i){
                string s1 = words[i];
                string s2 = words[i+1];
                if(s1.size() > s2.size() && s1.substr(0, s2.size()) == s2)
                    return "";
                int len = min(s1.length(), s2.length());
                int j = 0;
                while(len && s1[j] == s2[j]){
                    j++;
                    len--;
                    // st.insert(s1[j]);
                }
                if(len){
                    adj[s1[j]].push_back(s2[j]);
                    // st.insert(s1[j]);
                    // st.insert(s2[j]);
                }
            }
            int k = st.size();
            //topological sort
           
            map<char, int>indegree;
            for(char c:st) indegree[c] = 0;
    
            for(auto &[i,neighbors] : adj){
                for(auto it: neighbors){
                    indegree[it]++;
                }
            }
            
            queue<char>q;
            for(char c : st){
                if(indegree[c] == 0)    q.push(c);
            }
        string ans="";
           while(!q.empty()){
            char ele = q.front();
            ans+= ele;
            q.pop();
            for(auto it: adj[ele]){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.push(it);
            }
           } 
        if(ans.length() == k)
            return ans;
        else return "";
    
    
        }
    };
    