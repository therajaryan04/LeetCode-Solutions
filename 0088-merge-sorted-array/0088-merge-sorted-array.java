class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;     // Pointer for the last valid element in nums1
        int p2 = n - 1;     // Pointer for the last element in nums2
        int i = m + n - 1;  // Pointer for the final merged position in nums1
        
        // While there are elements to process in nums2
        while (p2 >= 0) {
            // If nums1 still has elements and its element is larger, place it at nums1[i]
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                // Otherwise, place nums2's element at nums1[i]
                nums1[i] = nums2[p2];
                p2--;
            }
            i--;
        }
    }
}