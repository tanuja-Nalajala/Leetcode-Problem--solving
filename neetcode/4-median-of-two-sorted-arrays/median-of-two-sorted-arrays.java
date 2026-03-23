class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
}
        int totalElement = m + n;

        //since we are looking for median ==> which is at mid 
        //total == even ==> 
        //median : 1,2,3,4,5,6 ==> (3+4) /2 = 3.5
        // so use sysmmetry propty : 
        //if we can make what are the elements going to be in the left part of median
        //say totalElements /2 will be in one part and totalElements/2 in another
        //so if we can find a way to conclude how many elements from arr1 is going to be part of my first portion
        //if we work on array1 : no.of elements which can be part : go from 0 to m
        //say if we want to include 1 element from arr1, remaining (total_elements/2 - 1) must come from array2
        //check if that division leads to a valid sorted portion

        //[1,3,5,8,9] [2,6,7,10, 12]. 10 ===> {1}{2,6,7,10} || {3,5,8,9}{12} (if we chose one element from array1 ==> this is the resultant sequence)
        //which is not valid ==> 10 < 3 
        //if valid 3: from first; 2 from second {1,3,l1 = 5} ||{l2 = 8, 9}
                                            // {2, r1 = 6}   || {r2 = 7, 10, 12}
        //if 2 : {1,3}{5,8,9}
            //    {2,6,7}{10, 12}
        int low = 0, high = m;
         int leftCount = (totalElement + 1) / 2;
         int l1 =Integer.MIN_VALUE, l2 =Integer.MIN_VALUE,r1 = Integer.MIN_VALUE, r2 = Integer.MIN_VALUE;
        while(low <= high){
            int mid1 = low + (high - low)/2;
            int mid2 = leftCount - mid1;
            //if we decided to choose mid no.of elements from array1

            //check is it leads to valid sequence
            l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1]; //max element in array1 in set1
            r1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1]; //min element from array1 in set2

            l2 =(mid2 == 0)? Integer.MIN_VALUE : nums2[mid2 - 1]; //max element in set2 from nums2
            r2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2]; //min element in set2 from nums2

            if(l1 <= r2 && l2 <= r1) 
                return (totalElement % 2 == 0) ? (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0 : Math.max(l1, l2);

            else if(l1 > r2){
                //
                //increment mid
                high = mid1-1;
            }else
                low = mid1 + 1;
        }
        return 0.0;
    }
}