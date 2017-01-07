import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ywwynm on 2017/1/7.
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to
 * a given number, target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {

    public static int threeSumClosest(int[] nums, int target) {
        long min = target < 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    long sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) return target;
                    if (Math.abs(sum - target) < Math.abs(min - target)) {
                        min = sum;
                    }
                }
            }
        }
        return (int) min;
    }

}
