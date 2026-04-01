class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //keep a deque -->

        int n = arr.length;
        int l = 0, r = n-1;
        while(r-l+1 > k){
            if(Math.abs(x - arr[l]) <= Math.abs(x - arr[r]) ){
                r--;
            }else{
                l++;
            }
        }
        List<Integer> ans= new ArrayList<>();
        for(int i = l; i <= r; ++i)
            ans.add(arr[i]);
    return ans;
    }
}