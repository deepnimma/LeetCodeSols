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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode ahead = head;
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;

        for (int i = 0; i < n; i++) ahead = ahead.next;
        while (ahead != null) {
            prev = prev.next;
            curr = curr.next;
            ahead = ahead.next;
        } // while

        prev.next = curr.next;

        return dummy.next;
    } // removeNthFromEnd
} // Solution