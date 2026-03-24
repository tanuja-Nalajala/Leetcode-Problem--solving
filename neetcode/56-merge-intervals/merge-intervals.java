class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        int [] arr = intervals[0];
        List<int[]> ans = new ArrayList<>();
        
        for(int i = 0; i < n; ++i){
            
            if(intervals[i][0] <= arr[1]){
                //overlap
                arr[0] = Math.min(intervals[i][0], arr[0]);
                arr[1] = Math.max(intervals[i][1], arr[1]);
            }
            else{
                ans.add(arr);
                arr = intervals[i];
            }
        }
        ans.add(arr);
    return ans.toArray(new int[ans.size()][]);
    }
}