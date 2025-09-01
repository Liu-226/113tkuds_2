
class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int halfLen = (m + n + 1) / 2;

        while (left <= right) {
            int i = (left + right) / 2;        // nums1 分割位置
            int j = halfLen - i;               // nums2 分割位置

            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // 找到正確分割
                if ((m + n) % 2 == 0) {
                    int maxLeft = Math.max(nums1Left, nums2Left);
                    int minRight = Math.min(nums1Right, nums2Right);
                    return (maxLeft + minRight) / 2.0;
                } else {
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted properly.");
    }

    public static void main(String[] args) {
        int[] nums1a = {1, 3};
        int[] nums2a = {2};
        System.out.println("Example 1 Output: " + findMedianSortedArrays(nums1a, nums2a)); // 2.0

        int[] nums1b = {1, 2};
        int[] nums2b = {3, 4};
        System.out.println("Example 2 Output: " + findMedianSortedArrays(nums1b, nums2b)); // 2.5

        int[] nums1c = {0, 0};
        int[] nums2c = {0, 0};
        System.out.println("Extra Example Output: " + findMedianSortedArrays(nums1c, nums2c));
    }
}
