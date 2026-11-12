class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: overflow condition
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        
        // Convert both to positive long values to prevent overflow
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        
        long quotient = 0;
        
        // Subtract largest shifted chunks of the divisor from the dividend
        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;
            
            // Double the divisor using bitwise shift as long as it fits within the dividend
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            // Subtract the largest chunk found and add its multiple to the quotient
            dvd -= temp;
            quotient += multiple;
        }
        
        // Apply the sign and cast back to int
        return isNegative ? (int) -quotient : (int) quotient;
    }
}