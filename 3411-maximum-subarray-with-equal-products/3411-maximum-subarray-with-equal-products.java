class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            int gcdVal = 0;
            long lcmVal = 1;

            for (int j = i; j < n; j++) {
                int curr = nums[j];
                gcdVal = (gcdVal == 0) ? curr : gcd(gcdVal, curr);
                lcmVal = lcm(lcmVal, curr);
                prod *= curr;

                if (prod == lcmVal * gcdVal) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd((int) a, (int) b)) * b;
    }
}