
import java.util.*;

class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If character is a digit
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            // If plus sign
            else if (ch == '+') {
                result = result + (sign * number);
                number = 0;
                sign = 1;
            }

            // If minus sign
            else if (ch == '-') {
                result = result + (sign * number);
                number = 0;
                sign = -1;
            }

            // If opening bracket
            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }

            // If closing bracket
            else if (ch == ')') {
                result = result + (sign * number);
                number = 0;

                result = result * stack.pop();
                result = result + stack.pop();
            }
        }

        // Add the last number
        result = result + (sign * number);

        return result;
    }
}
