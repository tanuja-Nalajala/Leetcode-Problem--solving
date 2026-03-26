class StockSpanner {
    class Pair{
        int stock;
        int span;
        Pair(int stock, int span){
            this.stock = stock;
            this.span = span;
        }
    }
    Stack<Pair> stk;
    public StockSpanner() {
        stk = new Stack<>();
    }
    
    public int next(int price) {
        int days = 1;
        while(!stk.isEmpty() && stk.peek().stock <= price ){
             days += stk.peek().span;
             stk.pop();    
        }
        stk.push(new Pair(price, days));
    return stk.peek().span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */