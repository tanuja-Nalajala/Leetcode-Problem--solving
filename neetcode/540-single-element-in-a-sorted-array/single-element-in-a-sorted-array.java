class Solution {
    public int singleNonDuplicate(int[] nums) {
        //so array is sorted 
        //single elememnt & rest is pairs
        //before single elements ==> all pairs index pattern would be like 
        //(even, odd) ==> (0, 1) (2, 3)

        //single element is at even index 
         
        //pattern changes to (odd, even)

        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = (l + (r - l) /2);

            //i know single element must be at even index
            if(mid % 2 == 1)
                mid--;
            
            //check mid is at after the single element or before
            //if mid is after the single element ==> 
            //pair pattern is (odd, even) 
            //mid: even ==> so 
            if(nums[mid] == nums[mid + 1])
            {
                //(even, odd)pair
                //mid is at before the single element 
                //go to right portion
                l = mid + 2;
            }else{
                //(nums[mid] != nums[mid+1])
                //(even , odd) not for sure
                //can be mid can be my single element 
                //or mid is right portion of single element ==> (odd, even) pair
                r = mid;
            }
        }
        return nums[l];

    }
}