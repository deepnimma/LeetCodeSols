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
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy.next;
        ListNode fast = dummy.next;
        ListNode prev = dummy;

        while (slow != null && fast != null && fast.next != null) {
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        } // while

        prev.next = null;
        Stack<ListNode> s = new Stack<>();

        while (slow != null) { 
            ListNode next = slow.next;
            slow.next = null;
            s.push(slow);
            slow = next;
        } // while

        ListNode curr = dummy.next;

        while (!s.empty() && curr != null) {
            ListNode next = curr.next;
            curr.next = s.pop();
            curr.next.next = next;
            curr = next;
        } // while

        curr = dummy.next;
        prev = dummy;

        while (curr != null) {
            curr = curr.next;
            prev = prev.next;
        } // while

        while (!s.empty()) {
            prev.next = s.pop();
            prev = prev.next;
        } // while
    } // reorderList
} // Solution