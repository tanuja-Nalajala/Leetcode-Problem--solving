class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> freqCounter = new HashMap<>();
        for(int cardValue : hand){
            freqCounter.put(cardValue, freqCounter.getOrDefault(cardValue, 0) +1);
        }

        Arrays.sort(hand);

        for(int i = 0; i < hand.length; ++i){
            int startCard = hand[i];
            if(freqCounter.get(startCard) == 0) continue;
            for(int k = startCard; k < startCard + groupSize ; k++){
                if(!freqCounter.containsKey(k) || freqCounter.get(k) == 0) return false;
                freqCounter.put(k, freqCounter.get(k) -1);
            }
        }
        return true;
    }
}