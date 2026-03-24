class Solution {
    int[] getNSE( int[]arr){
            int n = arr.length;
            Stack<Integer> stk = new Stack<>();
            int [] nse = new int[n];
            //nse[n-1] = n;
            for(int i = n-1; i >= 0; --i){
                while(!stk.isEmpty() && arr[stk.peek()] >= arr[i])
                    stk.pop();
            nse[i] = (stk.isEmpty()) ? n :stk.peek();
            stk.push(i);
            }
        return nse;
    }
    int [] getPSE(int[]arr){
            int n = arr.length;
            Stack<Integer> stk = new Stack<>();
            int [] pse = new int[n];
            pse[0] = 0;
            //stk.push(0);
            for(int i = 0; i < n; ++i){
                while(!stk.isEmpty() && arr[stk.peek()] > arr[i])
                    stk.pop();
                pse[i] = (stk.isEmpty()) ? -1 : stk.peek();
                stk.push(i);
            }
            return pse;
    }
    public int sumSubarrayMins(int[] arr) {
        /*
       {
        //brute force is to generate all sub arrays, tracking min in each and adding it to total;
        //n^2
        //optimal is to at each index we want to know, in how many subarrays; curr element is minimum
        //so at i: i want to where my next smallest element is : say j==> upto j-1 i know nums[i] is minimum
        //also at i i want to know where my prev smallest element is say k: upto k-1 to i : nums[i] is minimum

        //and no.of subarrays i can generate with i as min element is (j-1 - i) * (i - (k-1)) : subarrays
        //total : * nums[i];

        //eg: [1,2,3,1,,2,3]
        //at 0: 1 => nse : 1 (at 3) up to 2==> no.of aubarrays with 1 as minimum is (2-0);2 => rotal 2 * 1 
        //at 0 : 1 => nprev/equ e : 0 () ==> no.of subarrays eith 1 as minimum is 1 : total : 1 * 1 ; + 2 = 3
        //subarrays {1} {1,2} {1,2,3} : total : 3

        //at 1: 2 => nse => 1: at 3  => no.of subarrays (3-1 - 1) : 1
        //at 1: 2 => npee => 1: at(k:0) => no.of subarrays (1- 1) : 0 => 3 subarrays :  {2} {2,3}
       }
       */
        int[] nse = getNSE(arr);
        int[] pse = getPSE(arr);
        int n = arr.length;
        long total = 0;
        int mod = 1_000_000_007;
        for(int  i = 0; i < n; ++i){
            long right = (nse[i] - i);
            long left =  (i - pse[i]);
           long contrib = (left * right % mod) * arr[i]%(mod);
           total = (total + contrib)%mod; 
        }
        return (int)total;
        
    }
}