class SnapshotArray {
    //we need of past versions of array
    //so instead of storing every snapshot
    //i will track **changes** at snapshot
    //say when i updated index (0)= value ==> 
    //i will store during index:0 : {snap_id, value}
    //my track book will be something like
    //say : snapshot 3 is done and next snapshot is 4
    //after 3; i changes nums[0] : 90, nums[9] : 312
    //0 :{4, 90} 9 : {4, 312}

    //get() => at given index: for given snap_id : return nums[index]
    //eg: ind = 0 : {0:8, 5: 10; 13: 20 }. =>history of index:0
    //say get(0, snap_id:12 )  ==> so this snap_id is not in history, so is hould return  nearesr snap_id which is <= 12
    //we need ordered map => hashmap looks for exact matches => so it doesnt work
    //but treemap will do this : **floorEntry(index)***

    //  find closest ≤ X or ≥ X (or) We need values in TIME ORDER ===> TREEMAP/TREESET 

    //array of treemaps 
    //tm[0] = {key:value, ......}
    TreeMap<Integer, Integer> [] tm ;
    int snap_id = 0;
    public SnapshotArray(int length) {
        tm = new TreeMap [length];
        for(int i = 0; i < length; ++i){
            tm[i] = new TreeMap<>();
            tm[i]. put(0, 0); // at each index : we are intializing snap_id = 0, value = 0;
        }
    }
    
    public void set(int index, int val) {
        //we are updating arr[ind] = val
        //tm[ind] ={snap_d : val}
        tm[index].put(snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        //arr[ind] ==> tm[ind][snap_id]
        //but snap_id might not available ==>return previous snap
        return tm[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */