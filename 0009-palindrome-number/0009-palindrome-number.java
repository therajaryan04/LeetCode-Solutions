
class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers cannot be palindrome
        if (x < 0) {
            return false;
        }

        int original = x;
        int reverse = 0;

        // Reverse the number
        while (x > 0) {
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x = x / 10;
        }

        // Compare original and reversed number
        if (original == reverse) {
            return true;
        } else {
            return false;
        }
    }
}
