class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        set<int> s;

        for(int n : nums){
            if(s.contains(n))
                return n;
            s.insert(n);
        }
        return -1;
    }
};