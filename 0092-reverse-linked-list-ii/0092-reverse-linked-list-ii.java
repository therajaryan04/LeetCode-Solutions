
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Move 'prev' to the node immediately before position 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 'sublistStart' marks the first node of the range (becomes the tail after reversal)
        ListNode sublistStart = prev.next;

        // Step 2: Splice each subsequent node in [left + 1, right] to right after 'prev'
        for (int i = 0; i < right - left; i++) {
            ListNode nodeToMove = sublistStart.next;
            sublistStart.next = nodeToMove.next;
            nodeToMove.next = prev.next;
            prev.next = nodeToMove;
        }

        return dummy.next;
    }
}