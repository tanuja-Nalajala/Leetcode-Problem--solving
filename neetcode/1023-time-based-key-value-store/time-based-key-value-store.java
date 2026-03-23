class TimeMap {
    class Pair {
        String value;
        int timestamp;
        Pair(int timestamp, String value){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    Map<String, List<Pair>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key, new ArrayList<>());
        mp.get(key).add(new Pair (timestamp, value) );
    }
    
    public String get(String key, int timestamp) {
        if(mp.containsKey(key) == false) return "";
        List<Pair> list = mp.get(key);
        int low = 0, high = list.size() - 1;
        String ans = "";
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(list.get(mid).timestamp <= timestamp){
                //means need to go for higher timestamp
                 ans = list.get(mid).value;
                low = mid + 1;
            }else
                high = mid - 1;
        }
        return ans;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */