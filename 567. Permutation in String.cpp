class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int freq[26] = {0};

        int n = s1.length();
        for(char ch : s1){
            freq[ch - 'a']++;
        }

        int i = 0, j = 0, totalchar = n;
        while(j < s2.size()){

         if(freq[s2.at(j++) - 'a']-- > 0 )
            totalchar--;
         
            if(totalchar == 0) return true;
            if(j - i == n && freq[s2.at(i++) - 'a']++ >=0 )
                totalchar++;
        }
        return false;
    }
};