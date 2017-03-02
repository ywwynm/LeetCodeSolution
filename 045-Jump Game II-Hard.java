/**
 * Created by 张启 on 2017/3/2.
 *
 * 045-Jump Game II-Hard
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1,
 * then 3 steps to the last index.)
 *
 * Note:
 * You can assume that you can always reach the last index.
 */
public class Solution45 {

    public static void main(String... args) {
//        int[] nums = { 2, 3, 1, 1, 4 };
//        int[] nums = { 2, 4, 2, 2, 3, 1, 1, 4 };
//        int[] nums = { 2, 3, 1 };
//        int[] nums = { 1, 2, 1, 1, 4 };
//        int[] nums = { 10,9,8,7,6,5,4,3,2,1,1,0 };
//        int[] nums = { 2, 3, 4, 5, 6 };
        int[] nums = new int[25002];
        for (int i = nums.length - 2; i >= 0; i--) {
            nums[nums.length - i - 2] = i;
        }
        nums[nums.length - 2] = 1;
        nums[nums.length - 1] = 0;

        long start = System.currentTimeMillis();
        int times = jump(nums);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(times);
    }

    // Maybe TLE...Not Accepted...
    public static int jump(int[] nums) {
        int jumpTimes = 0;
        final int len = nums.length;
        int i = len - 1;
        while (i > 0) {
            int max = 0;
            int bestIndex = 0;
            for (int j = i - 1; j >= 0; j--) {
                int gap = i - j;
                if (nums[j] >= gap) {
                    if (gap == len - 1) {
                        bestIndex = j;
                        break;
                    }
                    if (nums[j] >= max) {
                        bestIndex = j;
                    }
                }
            }
            i = bestIndex;
            jumpTimes++;
        }
        return jumpTimes;
    }

}
