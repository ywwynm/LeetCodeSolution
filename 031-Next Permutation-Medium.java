import java.util.Arrays;

/**
 * Created by ywwynm on 2017/3/8.
 *
 * 031-Next Permutation-Medium
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted
 * in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in
 * the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 1,3,2 -> 2,1,3
 * 1,3,4,3,2 -> 1,4,2,3,3
 * 1,3,5,4,3,2 -> 1,4,2,3,3,5
 * 1,1,5,4,3,2 -> 1,2,1,3,4,5
 * 1,1,4,5,3,2 -> 1,1,5,2,3,4
 */
public class Solution31 {

    public static void main(String... args) {
//        int[] nums = { 1, 2, 3 };
//        int[] nums = { 3, 2, 1 };
//        int[] nums = { 1, 1, 5 };
//        int[] nums = { 1, 3, 2 };
//        int[] nums = { 1, 3, 4, 3, 2 };
        int[] nums = { 1, 3, 5, 4, 3, 2 };
//        int[] nums = { 1, 1, 5, 4, 3, 2 };
//        int[] nums = { 1, 1, 4, 5, 3, 2 };
        better(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        final int len = nums.length;
        // 后面比前面大
        // 前面的越靠后越好
        // 后面的越小越好
        for (int front = len - 2; front >= 0; front--) {
            int minNum = Integer.MAX_VALUE;
            int end = -1;
            for (int i = len - 1; i > front; i--) {
                if (nums[i] > nums[front] && nums[i] < minNum) {
                    end = i;
                    minNum = nums[end];
                }
            }
            if (end != -1) {
                int temp = nums[front];
                nums[front] = nums[end];
                nums[end] = temp;
                Arrays.sort(nums, front + 1, len);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void better(int[] nums) {
        final int len = nums.length;
        int rBegin = len - 1;
        while (rBegin >= 1 && nums[rBegin] <= nums[rBegin - 1]) {
            rBegin--;
        }
        if (rBegin == 0) {
            Arrays.sort(nums);
            return;
        }

        int aIndex = rBegin - 1, a = nums[aIndex];
        Arrays.sort(nums, rBegin, len);
        int start = rBegin, end = len - 1, mid = (start + end) / 2;
        while (start != end && start + 1 != end) {
            if (a < nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
            mid = (start + end) / 2;
        }
        mid = nums[start] > a ? start : end;
        nums[aIndex] = nums[mid];
        nums[mid] = a;
    }

}
