
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // Step 1: Save the next node
            curr.next = prev;              // Step 2: Reverse the current node's pointer
            prev = curr;                   // Step 3: Move prev one step forward
            curr = nextTemp;               // Step 4: Move curr one step forward
        }
        
        // When curr becomes null, prev is pointing to the new head of the reversed list
        return prev;
    }
}