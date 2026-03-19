class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int l = 0, r = n-1, sum = 0;
        for(int i = 0; i < k; ++i){
            sum += cardPoints[i];
        }
        System.out.print(sum);
        int maxSum = sum;
        for(int i = k-1; i >= 0; --i){
            sum -= cardPoints[i];
            sum += cardPoints[r];
            if(maxSum < sum)    
                maxSum = sum;
            r--; 
        }
        return maxSum;
    }
}