class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        //return max element found in each window
        //need to delete elements from end and add elements from start
        //dll : as montonic decreasing dq: storing indices
        //dll : 
        /*
        1 : { 1} max : 1
        3 : pop 1 & push 3; no need to keep one since we had a max element; so 1 never going to max element than 3: {3} max : 3
        -1 : {3, -1} ==> max : 3
        -3 : {3, -1, -3} max: 3
        5 : -3 < 5 remove -1 < 5 remove ; {5} max: 5
        3 : {5, 3}
        6 : 3 < 6 pop; 5 < 6 pop; {6}
        7 : {7} 
    */
        int n = nums.length;
        
        int max = 0;
        int [] ans = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        
        int j = 0;
        for(int i = 0; i < n; ++i){
            //remove out of window elements
            if(!q.isEmpty() && q.peekFirst() <= i - k)
                q.pollFirst();
            
            //remove minimal & equal 
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }
            q.offerLast(i);

            if(i >= k -1){
                ans[j++] = nums[q.peekFirst()];
            }
        }
    return ans;
        
    }
}