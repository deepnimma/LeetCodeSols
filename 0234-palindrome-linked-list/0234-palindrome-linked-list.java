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
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;
        
        ListNode dummy = new ListNode(-1, head);
        ListNode copy = deepCopy(head);
        copy = reverse(copy);

        while (head != null) {
            if (head.val != copy.val) return false;
            head = head.next;
            copy = copy.next;
        } // while

        return true;
    } // isPalindrome

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode dummy = new ListNode(-1, head);
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } // while

        return prev;
    } // reverse

    private ListNode deepCopy(ListNode curr) {
        ListNode dummy = new ListNode();
        ListNode copy = dummy;

        while (curr != null) {
            copy.next = new ListNode(curr.val);
            curr = curr.next;
            copy = copy.next;
        } // while

        return dummy.next;
    } // deepCopy
} // Solution