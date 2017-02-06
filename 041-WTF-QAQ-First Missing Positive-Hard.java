/**
 * Created by ywwynm on 2017/1/25.
 *
 * 41. First Missing Positive - Hard
 *
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2,
 * and [] return 1,
 * and [1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class Solution41 {

    public static void main(String... args) {
        int[] nums = { 1, 1 };
        System.out.println(firstMissingPositive(nums));
    }

    /**
     * 我的算法非常巧妙，用到了位操作-异或哦~
     * 然而并没有什么卵用，因为给的数组中可能存在重复的数字...如果没有这种情况，那我这算法就完美了QAQ
     */
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int missing = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[i] < min) {
                    min = nums[i];
                }
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
        }
        if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing ^= nums[i];
            }
        }
        for (int i = min; i <= max; i++) {
            missing ^= i;
        }
        if (missing == 0) {
            if (min - 1 > 0) return min - 1;
            return max + 1;
        }
        return missing;
    }

    public static int better(int[] A) {
        final int len = A.length;
        for (int i = 0; i < len; i++) {
            // 始终让A[i]的数字保持正确
            while (A[i] > 0 && A[i] <= len && A[i] != A[A[i] - 1]) {
                int tmp = A[i];
                A[i] = A[A[i] - 1];
                A[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

}
