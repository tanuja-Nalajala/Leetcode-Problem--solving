class Solution {
public:
    map<string, vector<char> >mp;
    set<string> bad;

    public:
     bool dfs(string btm, int i, string temp){ 
        //(bcd, 0, ""); (bcd, 1, c); (bdc, 2, ce); (ce, 0, ""), dfs(ce, 1, a); dfs(a, 0, "")

        //base case -> length == 1 & pyramid is success
        if(btm.size() == 1 ) return true; //(3 == 1) F; (3 == 1) f; (3 == 1 ) f; (2 == 1 ) F; f; true

        if(i==0 && bad.count(btm)) return false;

        //if we built next row
        if(i == btm.size() - 1 ){ //(0 == 3 -1 ) F; (1 == 3 - 1) F; (2 == 3 - 1) true; (0 == 1 ) F; (1 == 2 - 1)
            string nextRow; //
            bool res = dfs(temp, 0, nextRow); //dfs(ce, 0, ""); dfs(a, 0, "")(Ret T);
            if(!res && i == 0 ) bad.insert(btm);

            return res;
        }

        string key = btm.substr(i, 2); //key = substr(0,2) -> (bc); key = sb(1, 2) ->(cd); key =(0,2)-> ce

        //if(mp.fin)

        //try all the possible chars that can go above this pair

        for(char ch : mp[key]){ //mp[bc] -> (c); mp[cd] ->(e); mp[ce] -> a
            temp.push_back(ch); //temp = c; temp = ce; temp = a
            if(dfs(btm, i+1, temp)) return true; // dfs(bcd, 1, c); dfs(bcd, 2, ce); dfs(ce, 1, a)()

            temp.pop_back();
        }

        bad.insert(btm);
        return false;
    }
    bool pyramidTransition(string bottom, vector<string>& allowed) {

        for(auto &a : allowed ){
            mp[a.substr(0, 2)].push_back(a[2]);
        }

        string temp;
        return dfs(bottom, 0, temp);
        
    }
};