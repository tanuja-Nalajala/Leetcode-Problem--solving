class Solution {
    int [] parent;
    int [] size;
    class DisjointSet{
        DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; ++i){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int findParent(int u){
            if(u == parent[u])  return u;
            return parent[u] = findParent(parent[u]);
        }
        void unionBySize(int u, int v){
            int ultPU = findParent(u);
            int ultPV = findParent(v);

            if(ultPU == ultPV) return;

            if(size[ultPU] < size[ultPV]){
                parent[ultPU] = parent[ultPV];
                size[ultPV] += size[ultPU];
            }else{
                parent[ultPV] = parent[ultPU];
                size[ultPU] += size[ultPV];
            }
        }

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int numAccounts = accounts.size();
        DisjointSet ds = new DisjointSet(numAccounts);

        Map<String, Integer> mailToAccount = new HashMap<>();
        for(int i = 0; i < numAccounts; ++i){
            List<String> emails = accounts.get(i);
            

            //each account add all the emails to map
            //emails to root mapping
            for(int j = 1; j < emails.size(); ++j){
                String email = emails.get(j);
                //check String already present in map
                if(mailToAccount.containsKey(email) == true){
                    // Email already seen - union current account with previous account
                    //i will merge current account id and id of (email) present in map
                    ds.unionBySize(mailToAccount.get(email), i);
                }else
                    mailToAccount.put(email, i);
            }
        }

             // root account -> list of emails
             //for each accoun i can get their ultimate parent
            List<List<String>> rootToMails = new ArrayList<>();
            for(int k = 0; k < numAccounts; ++k){
                rootToMails.add(new ArrayList<>());
            }

            for(Map.Entry<String, Integer> entry : mailToAccount.entrySet()){
                String email = entry.getKey();
                int accountIndex = entry.getValue();
                int rootAccount = ds.findParent(accountIndex);

                rootToMails.get(rootAccount).add(email);

            }

            //return ans;
            //we have email to root in a map
            //we have rootAccount. to all emails
            //we need to return ans for each rootAccount -> get its name, and add all the accounts
            List<List<String>> ans = new ArrayList<>();
            for(int id = 0; id < numAccounts; ++id){
                List<String> e = rootToMails.get(id);
                if(e.isEmpty() == true) continue;
                Collections.sort(e);

                List<String> merged = new ArrayList<>();
                merged.add(accounts.get(id).get(0));
                merged.addAll(e);

                ans.add(merged);
                
            }
    return ans;     
    }
}