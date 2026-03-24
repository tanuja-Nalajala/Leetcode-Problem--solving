class MinStack {

    class Pair{
        int value;
        int min;
        Pair(int value, int min){
            this.value = value;
            this.min = min;
        }
    }
    Stack<Pair> stk;
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if(stk.isEmpty()){
            stk.push(new Pair (val, val));
        }else{
            stk.push( new Pair(val, Math.min(val, stk.peek().min) ) );
        }
    }
    
    public void pop() {
        if(!stk.isEmpty()){
            stk.pop();
        }
    }
    
    public int top() {
        return stk.peek().value;
    }
    
    public int getMin() {
        return stk.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */