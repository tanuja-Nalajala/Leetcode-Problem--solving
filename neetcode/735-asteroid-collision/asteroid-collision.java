class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < asteroids.length; ++i){
            if(asteroids[i] > 0)
                stk.push(asteroids[i]);
            else{
                //negative asteroid
                //
                while(!stk.isEmpty() && stk.peek() > 0 && stk.peek() < Math.abs(asteroids[i]) ){
                    //pop()
                    stk.pop();

                }
                if(!stk.isEmpty() && stk.peek() == Math.abs(asteroids[i])){
                    stk.pop();
                }else if(stk.isEmpty() || stk.peek() < 0){
                    stk.push(asteroids[i]);
                }
            }
        }
        int k = stk.size();
        int[] ans = new int[k];
        for(int i = stk.size()-1; i>=0; --i){
            ans[i] = stk.peek();
            stk.pop();
        }
    return ans;
    }
}