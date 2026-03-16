class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //what is k: no of banans koko should eat per hour
        //also with in h hrs, koko should complete eating all the bananas
        //what is k rage:
        //koko can eat k = 0 banans? only if piles is empty
        // else k = 1,2...min(piles[i]..i.e(if koko has more hours)).......
        //what is k : max_value possible: (if h== piles.length) =>then koko must eat 1 pile/hr : max(pile)

        //so k will go from 0 to max(piles[i]);

        //i can linarly check k value and look for the minimum possible
        //or i can use binary search

        int maxValue = 0;
        for(int i = 0; i < piles.length; ++i){
            maxValue = Math.max(piles[i], maxValue);
        }

        int i = 1, j = maxValue;
        int minimumRate = Integer.MAX_VALUE;
        while(i <= j){
            int mid = (i + (j-i)/2);
            //i check if my k = mid banas/hr ==> can koko completes them with h hrs
            int hrs = 0;
            for(int ptr = 0; ptr < piles.length; ++ptr){
                hrs += Math.ceil((double)piles[ptr] / mid);
            }
            if(hrs <= h) {
                minimumRate = mid;
                //will go on check on the lower k
                j = mid - 1;
            }else{
                //with current k : koko cant complete all piles; so it should increase rate
                i = mid + 1;
            }
        }
        return minimumRate;

    }
}