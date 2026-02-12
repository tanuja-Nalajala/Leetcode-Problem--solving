/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        //questions: 1 -> negavtive numbers?
        //2: possibility of empty lists?
        //3: possibility of large numbers? ->exceeding int capacity?
        //4: return values for empty list2?

        //edge cases: l1 empty() and l2 empty;
        //edge case 2: either l1 or l2

        //approach: i will add numbers by traversing through linkedlist; if exceeds 9 --> flag-->stores flag and carry forward it to the next node.

        ListNode ans = new ListNode(0);
        ListNode temp = ans;

        if(l1 == null && l2 == null) return null;
        if( l1 == null ) return l2;
        if( l2 == null ) return l1;

        int carry = 0;
        //ListNode temp = ans;
        while(l1 != null || l2 != null || carry != 0 ){

            int sum = carry; 

            if(l1 != null ){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null ){
                sum += l2.val ;
                l2 = l2.next;
            }
            carry = sum / 10;
            
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        return ans.next;
    }
}