class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;

        // Check whether there are k nodes
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Less than k nodes, don't reverse
        if (count < k) {
            return head;
        }

        // Reverse first k nodes
        ListNode prev = null;
        curr = head;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect with remaining groups
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}
