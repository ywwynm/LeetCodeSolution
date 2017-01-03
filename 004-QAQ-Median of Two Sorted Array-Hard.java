/**
 * Created by 张启 on 2015/11/16.
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log(m+n)).
 */
public class Solution {

    public static void main(String... args) {
        int[] nums1 = new int[] { 0, 1, 3, 5, 8, 16 };
        int[] nums2 = new int[] { 0, 1, 2, 3, 4, 5, 6, 15, 17, 18 };
        System.out.println(myBetter(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int n = 0, i = 0, j = 0; i < nums1.length || j < nums2.length; n++) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    nums[n] = nums1[i];
                    i++;
                } else {
                    nums[n] = nums2[j];
                    j++;
                }
            } else if (i < nums1.length) {
                nums[n] = nums1[i++];
            } else if (j < nums2.length) {
                nums[n] = nums2[j++];
            }
        }
        if (nums.length % 2 == 0) {
            int n1 = nums[nums.length / 2 - 1];
            int n2 = nums[nums.length / 2];
            return (n1 + n2) / 2d;
        } else {
            return nums[(nums.length - 1) / 2];
        }
    }


    public static double myBetter(int[] nums1, int[] nums2) {
        int lenSum = nums1.length + nums2.length;
        int end = lenSum % 2 == 0 ? lenSum / 2 : (lenSum - 1) / 2;

        int[] nums = new int[end + 1];
        for (int n = 0, i = 0, j = 0;
             (i < nums1.length || j < nums2.length) && n < nums.length; n++) {
            if (i < nums1.length && j < nums2.length) {
                nums[n] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else if (i < nums1.length) {
                nums[n] = nums1[i++];
            } else if (j < nums2.length) {
                nums[n] = nums2[j++];
            }
        }

        if (lenSum % 2 == 0) {
            int n1 = nums[nums.length - 2];
            int n2 = nums[nums.length - 1];
            return (n1 + n2) / 2d;
        } else {
            return nums[nums.length - 1];
        }
    }



    public static double logMaddNUsingFindKth(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if ((len1 + len2) % 2 != 0) // odd
            return (double) findKth(nums1, nums2, (len1 + len2) / 2,
                    0, len1 - 1, 0, len2 - 1);
        else { // even
            return (findKth(nums1, nums2, (len1 + len2) / 2,
                    0, len1 - 1, 0, len2 - 1)
                    + findKth(nums1, nums2, (len1 + len2) / 2 - 1,
                    0, len1 - 1, 0, len2 - 1))
                    / 2;
        }
    }

    /**
     * 找到数组融合后第k大的元素
     */
    public static int findKth(int A[], int B[], int k,
                              int aStart, int aEnd, int bStart, int bEnd) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

        int aMid = aLen * k / (aLen + bLen); // a's middle count
        int bMid = k - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }
}
