/* 
Reverse a Linked List
  */

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
    public ListNode reverseList(ListNode head) {
        
        ListNode result = null;
        ListNode x = head;
        ListNode output = null;

        while (x != null) {
            output = x;
            ListNode y = x.next;
            x.next = result;
            result = output;
            x = y;
        }

        return result;
    }
}
