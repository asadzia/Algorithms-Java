class Solution {

        private int p1 = 0;
        private int p2 = 0;

    private int getMin(int[] nums1, int[] nums2) {

        if (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                return nums1[p1++];
            } else {
                return nums2[p2++];
            }
        }

        else if (p1 < nums1.length) {
            return nums1[p1++];
        }

        else if (p2 < nums2.length) {
            return nums2[p2++];
        }

        return -1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // No need to create a new array - use existing sorted arrays
        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 0) {
            // even
            for (int i = 0; i < (m + n) / 2 - 1; ++i) {
                getMin(nums1, nums2);
            }

            // return the next two items - i.e. the middle elements
            return (double)(getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;

        } else {
            // odd
            for (int i = 0; i < (m + n) / 2; ++i) {
                getMin(nums1, nums2);
            }

            // return the middle element
            return (double)(getMin(nums1, nums2));
        }
    }
}
