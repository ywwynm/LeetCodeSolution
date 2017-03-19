/**
 * Created by ywwynm on 2017/3/12.
 *
 * 053-Maximum Subarray-Easy
 *
 * Find the contiguous subarray within an array (containing at least one number) which
 * has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class Solution53 {

    public static void main(String... args) {
//        int[] nums = { 1, 2, 3 };
        int[] nums = { -2,1 };
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(myBetter(nums));
    }

    // TLE. Well, I think I should forget DP.
    public static int maxSubArray(int[] nums) {
        final int N = nums.length;
        if (N == 0) return 0;
        if (N == 1) return nums[0];
        int[][] sum = new int[N][N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            sum[i][i] = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < j; i++) {
                sum[i][j] = sum[i][j - 1] + nums[j];
                if (sum[i][j] > max) max = sum[i][j];
            }
        }
        return max;
    }

    // This is an easy problem... Can I really be a great persom?
    public static int myBetter(int[] nums) {
        final int N = nums.length;
        int sum = 0, max = Integer.MIN_VALUE;
        boolean shouldReturnZero = false;
        for (int i = N - 1; i >= 0; i--) {
            if (shouldReturnZero) {
                shouldReturnZero = false;
                sum = 0;
            }
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                shouldReturnZero = true;
            }
        }
        return max;
    }

}
