class TimeMap {
    Map<String, TreeMap<Integer, String>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key, new TreeMap<>());
        mp.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(mp.containsKey(key) == false) return "";

        TreeMap<Integer, String> tm = mp.get(key);
        // Map.Entry<Integer, String> entry = tm.floorEntry(timestamp);
        // return (entry == null)? "" : entry.getValue();

        Integer entry = tm.floorKey(timestamp);
        return (entry == null) ? "" : tm.get(entry);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */