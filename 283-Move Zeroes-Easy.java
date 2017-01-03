/**
 * Created by 张启 on 2015/11/29.
 *
 * Given an array nums, write a function to move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums 
 * should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Solution {

    public static void main(String... args) {
        int[] nums = new int[] { 1, 0 };
        best(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void moveZeroes(int[] nums) {
        final int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                if (j < i) {
                    j = i + 1;
                }
                while (j < len) {
                    if (nums[j] != 0) {
                        nums[i] = nums[i] ^ nums[j];
                        nums[j] = nums[i] ^ nums[j];
                        nums[i] = nums[i] ^ nums[j++];
                        break;
                    }
                    j++;
                }
                if (j == len && nums[len - 1] == 0) {
                    return;
                }
            }
        }
    }

    public static void best(int[] nums) {
        final int len = nums.length;
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }

        while (i < len) {
            nums[i++] = 0;
        }
    }
}
