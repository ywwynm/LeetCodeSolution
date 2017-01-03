/**
 * Created by 张启 on 2015/12/4.
 *
 * Given a sorted array, remove the duplicates in place such that each element appear 
 * only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with 
 * constant memory.
 * 
 * For example, Given input array nums = [1,1,2], Your function should return length = 2, 
 * with the first two elements of nums being 1 and 2 respectively. It doesn't matter 
 * what you leave beyond the new length.
 */
public class Solution {

    public static void main(String... args) {
        int[] nums = { 0, 0, 0, 0, 3 };
        System.out.println(best(nums));
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int repeat = 0;
        for (int i = 0; i < nums.length - repeat;) {
            int jump = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    jump = j - i - 1;
                    break;
                }
            }
            repeat += jump;
            if (jump != 0) {
                for (int k = i; k + jump + 1 < nums.length; k++) {
                    nums[k + 1] = nums[k + jump + 1];
                }
            }
            i++;
        }
        return nums.length - repeat;
    }

    public static int better(int[] nums) {
        if (nums.length < 2) {
            return 1;
        }

        int j = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[j]) {
                i++;
            } else {
                j++;
                nums[j] = nums[i];
                i++;
            }
        }
        return j + 1;
    }

    public static int best(int[] nums) {
        int dup = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dup++;
            }
            nums[i - dup] = nums[i];
        }
        return nums.length - dup;
    }

}
