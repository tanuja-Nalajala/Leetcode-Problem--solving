class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //so here i need to add elements from the front and need to remove from back
        //dequeue store indexes
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n-k + 1];
        int j = 0;
        for(int i = 0; i < nums.length; ++i){
            //check if your dq has k elements : index range is: i - k to i (i: 4 then last index in the window is 2; <= 1 pop from dq)
            if(!dq.isEmpty() && dq.peekFirst() <= i-k)
                dq.pollFirst();
            
            //dq elements are stored in decresing order;
            //say dq has 1 and incoming is 3: there is no point of storing 1 in the queue as we need maximum and 1 cant be max when 3 is present
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            //now answer for each window
            //answers need to collect from i = k-1
            if(i >= k-1){
                ans[j++] = nums[dq.peekFirst()];
            }
        }
    return ans;    
    }
}