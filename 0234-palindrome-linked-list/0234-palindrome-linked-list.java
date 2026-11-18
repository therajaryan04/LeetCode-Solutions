
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // Step 1: Find the middle of the linked list using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list starting from 'slow'
        ListNode secondHalfHead = reverseList(slow);
        
        // Step 3: Compare the first half and the reversed second half
        ListNode firstHalfPtr = head;
        ListNode secondHalfPtr = secondHalfHead;
        boolean isPalin = true;
        
        while (secondHalfPtr != null) {
            if (firstHalfPtr.val != secondHalfPtr.val) {
                isPalin = false;
                break;
            }
            firstHalfPtr = firstHalfPtr.next;
            secondHalfPtr = secondHalfPtr.next;
        }
        
        // (Optional) Step 4: Restore the list by reversing the second half back (good practice)
        reverseList(secondHalfHead);
        
        return isPalin;
    }
    
    // Helper method to reverse a linked list (same logic as LeetCode 206!)
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}