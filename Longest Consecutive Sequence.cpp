// 128. Longest Consecutive Sequence
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

// Test Cases:

// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9

class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        map<int,int>mp;
        int max_seq=0;
        for(int i:nums){
            mp[i]++;
        }
        for(auto& k :mp){
            int count=1;
            int num=k.first;
            int p=1;
            if(mp.find(num-1)==mp.end()){
                while(mp.find(num+p)!=mp.end()){
                    count++;
                    p++;
                    // mp[num+1];
                }
            }
            mp[num]=count;
            max_seq= max(max_seq, count);
        }
        return max_seq;
    }
};