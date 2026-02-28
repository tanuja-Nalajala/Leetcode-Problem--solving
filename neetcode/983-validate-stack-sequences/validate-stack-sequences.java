class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> stk = new Stack();
        int j = 0;
        for(int i : pushed){
            stk.push(i);
            while(stk.isEmpty() == false && popped[j] == stk.peek()){
                j++;
                stk.pop();
            }

        }
        return stk.isEmpty();
    }
}