class Solution {
    public:
        int maxArea(vector<int>& height) {
            int max_area = 0;
    
            int  n = height.size();
            int i = 0, j = n-1;
    
            while(i < j ){
                int area = (j - i) * min(height[i], height[j] );
                max_area = max( area, max_area );
    
                if(height[i] < height[j] ) i++;
                else j--;
            }
            return max_area;
    
        }
    };