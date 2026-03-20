class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n =  cardPoints.length;
        int  l = 0, r = n-1;
        int sum = 0, maxSum = 0;
        for(int i = 0; i < k; ++i){
            sum += cardPoints[i];
        }
        maxSum = Math.max(sum, maxSum);
        for(int i = k-1; i >= 0; --i){
            sum -= cardPoints[i];
            sum += cardPoints[r];
            maxSum = Math.max(sum, maxSum);
            r--;
        }
        return maxSum;

        //tc: O(K); SC(1)
    }
}