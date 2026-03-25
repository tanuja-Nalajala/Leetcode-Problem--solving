class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < num.length(); ++i){
            char ch = num.charAt(i);
            int digit = ch -'0';
            while(!stk.isEmpty() && digit < stk.peek() && k > 0){
                    //remove from top
                    stk.pop();
                    k--;
            }
        stk.push(digit);
        }
        int n = stk.size();
        while(k > 0 && !stk.isEmpty()){
            stk.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.peek());
            stk.pop();
        }
        sb.reverse();
        int i = 0;
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
           
        }
        return sb.length() == 0 ? "0" : sb.toString() ;
    }
}