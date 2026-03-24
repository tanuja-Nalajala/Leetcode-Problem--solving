class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //since its a circular array
        //try to imagine a 2n array : 1,2,1, 1,2,1
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int [] res = new int [n];

        for(int i = 2*n - 1; i >= 0; --i){
            while(!stk.isEmpty() && stk.peek() <= nums[i%n])
                stk.pop();
            if(i < n){
                //start adding res
                res[i] = stk.isEmpty() == true ? -1 : stk.peek();
            }
        stk.push(nums[i%n]);
        }
    return res;
    }
}