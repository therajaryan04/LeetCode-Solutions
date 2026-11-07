
import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        findPartitions(s, 0, new ArrayList<>(), result);

        return result;
    }

    void findPartitions(String s, int start,
                        List<String> current,
                        List<List<String>> result) {

        // If we reach the end, save the partition
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try different substrings
        for (int i = start; i < s.length(); i++) {

            String part = s.substring(start, i + 1);

            // Check whether substring is palindrome
            if (isPalindrome(part)) {

                current.add(part);

                findPartitions(s, i + 1, current, result);

                // Backtracking
                current.remove(current.size() - 1);
            }
        }
    }

    boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
