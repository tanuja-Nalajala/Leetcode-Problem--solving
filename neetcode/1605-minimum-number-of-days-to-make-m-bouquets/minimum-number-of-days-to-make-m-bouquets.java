class Solution {
    boolean func(int[] bloomDay, int mid, int m, int k){
        int bloomCounter = 0, bouquet = 0;
        for(int i : bloomDay){
            if(i <= mid){
                bloomCounter++;
            }else {
                    bouquet += bloomCounter / k;
                    bloomCounter = 0;
                }
            if(bouquet >= m)
                    return true;
        }
        bouquet += bloomCounter / k;
        return bouquet >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if((long)m * k > n) return -1;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int i : bloomDay){
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        int bloomCounter = 0, ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if ( func(bloomDay, mid, m, k) == true ){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;

    }
}