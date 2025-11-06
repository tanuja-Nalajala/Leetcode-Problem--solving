class Solution {
public:
    int scoreOfString(string s) {

        int ans = 0;
        int j = 1;
        int n = s.length();

        int prev = s[0]; 
        while(j < n) {
            int curr = s[j];
            ans += prev > curr ? ( prev - curr ) : ( curr - prev);
            prev = curr;
            j++;
        }

        return ans;

        
    }
};