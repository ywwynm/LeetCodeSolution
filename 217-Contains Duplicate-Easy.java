import java.util.*;

/**
 * Created by 张启 on 2015/12/2.
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice
 * in the array, and it should return false if every element is distinct.
 */
public class Solution {

    public static void main(String... args) {
        int[] nums = new int[] { 0, 1, 2, 0 };
        System.out.println(myMoreBetter(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    public static boolean myBetter(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return true;
        }
        return false;
    }

    public static boolean myMuchBetter(int[] nums) {
        Arrays.sort(nums);
        final int len = nums.length;
        for (int i = 1; i <= len / 2; i++) {
            if (nums[i - 1] == nums[i] || nums[len - i] == nums[len - i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean best(int[] nums) {
        byte[] mark = new byte[150000];
        for (int i : nums) {
            int j = i / 8;
            int k = i % 8;
            int check = 1 << k;
            if ((mark[j] & check) != 0) {
                return true;
            }
            mark[j] |= check;
        }
        return false;
    }

}
