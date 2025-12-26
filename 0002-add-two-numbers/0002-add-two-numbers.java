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
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carryOver = 0;

        while (curr1 != null && curr2 != null) {
            int val1 = curr1.val;
            int val2 = curr2.val;
            int sum = val1 + val2 + carryOver;
            carryOver = sum / 10;
            int dig = sum % 10;

            curr.next = new ListNode(dig);
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        } // while

        ListNode carryOverNode;

        if (curr1 != null) curr.next = curr1;
        if (curr2 != null) curr.next = curr2;

        if (carryOver == 0) return dummy.next;

        ListNode prev = curr;
        curr = curr.next;

        while (curr != null && carryOver != 0) {
            if (curr.val == 9) {
                curr.val = 0;
            } else {
                curr.val += 1;
                carryOver = 0;
            } // if-else

            prev = prev.next; 
            curr = curr.next;
        } // while

        if (carryOver != 0) prev.next = new ListNode(1);

        return dummy.next;
    } // addTwoNumbers
} // Solution