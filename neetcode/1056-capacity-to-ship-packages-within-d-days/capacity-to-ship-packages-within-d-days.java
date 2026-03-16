class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //least weight capapcity of the belt ==> so that we can load all the weights in given days

        //so belt capapcity : max(nums[i] :: bcoz boat should definetluy have the capacity to carry; coz we cant split weight[i] across multiple days) to sum(weights[i])(day = 1)

        //need min: i will binary search on this weight range
        //for curr_w; if i can ship all the weights d:days ==> will search on lower bounds
        //keeping track of minimum
        int totalWeight = 0, ans = 0, maxWeight = 0;
        for(int i = 0; i < weights.length; ++i){
            totalWeight += weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }
        //ans : will go from 1 to totalWeight
        int i = maxWeight, j = totalWeight;
        while(i <= j){
            int mid = i + (j - i) / 2;
            //calculate no.of days required to ship all weights
            int weight = 0;
            int d = 1;
            for(int w : weights){
                if(weight + w > mid){
                    //i need one more day
                    d++;
                    //on new day ship weight changes
                    weight = w;
                }
                else weight += w;
            }
            if(d <= days){
                ans = mid;
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return ans;
    }
}