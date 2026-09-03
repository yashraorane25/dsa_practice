package binary_search;

public class MedianOfSortedArrays {
    public static void main(String[] args) {
//        int[] nums1 = {1, 6};
//        int[] nums2 = {2, 3, 4, 5};
        int[] nums1 = {2};
        int[] nums2 = {};
        MedianOfSortedArrays medianOfSortedArrays = new MedianOfSortedArrays();
        double res = medianOfSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println("meidan of two arrays: " + res);
    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            findMedianSortedArrays(nums2, nums1);
//        }
//        int m = nums1.length, n = nums2.length;
//        int left = 0;
//        int right = m;
//        int half = (m + n + 1) / 2;
//        while (left <= right) {
//            int cut1 = left + (right - left) / 2;
//            int cut2 = half - cut1;
//            int maxLeft1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
//            int minRight1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
//            int maxLeft2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
//            int minRight2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];
//
//            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
//                // Found the correct partition
//                if ((m + n) % 2 == 1) {
//                    return Math.max(maxLeft1, maxLeft2);
//                }
//                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
//            } else if (maxLeft1 > minRight2) {
//                right = cut1 - 1;
//            } else {
//                left = cut1 + 1;
//            }
//
//        }
//        return 0.0;
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int half = (m + n + 1) / 2;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = half - i;

            // Handle boundary cases with -INF and +INF
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found the correct partition
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                }
                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            } else if (maxLeft1 > minRight2) {
                // Too many elements from nums1, search left
                right = i - 1;
            } else {
                // Too few elements from nums1, search right
                left = i + 1;
            }
        }

        return 0.0;
    }
}
