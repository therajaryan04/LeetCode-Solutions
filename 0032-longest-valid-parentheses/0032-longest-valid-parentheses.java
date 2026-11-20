import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // Initial base index before the start of the string
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // No matching '('; set current index as the new boundary
                    stack.push(i);
                } else {
                    // Valid substring length is current index minus new top boundary
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
}