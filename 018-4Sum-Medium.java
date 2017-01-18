import java.util.*;

/**
 * Created by ywwynm on 2017/1/14.
 *
 * 18 4Sum
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that
 * a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note: The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *    [-1,  0, 0, 1],
 *    [-2, -1, 1, 2],
 *    [-2,  0, 0, 2]
 * ]
 */
public class Solution {

    public static void main(String... args) {
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        List<List<Integer>> list = better(nums, target);
        System.out.println(list.size());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ret = new ArrayList<>();
        int end = nums.length;
        for (int i = 0; i < end - 3; i++) {
            for (int j = i + 1; j < end - 2; j++) {
                for (int k = j + 1; k < end - 1; k++) {
                    for (int l = k + 1; l < end; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> numsList = new ArrayList<>(4);
                            numsList.add(nums[i]);
                            numsList.add(nums[j]);
                            numsList.add(nums[k]);
                            numsList.add(nums[l]);
                            set.add(numsList);
                        } else if (sum > target) {
                            break;
                        }
                    }
                }
            }
        }
        ret.addAll(set);
        return ret;
    }

    public static List<List<Integer>> better(int[] nums, int target) { // 2017/1/18
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int f = j + 1, e = nums.length - 1;
                while (f < e) {
                    int sum = nums[i] + nums[j] + nums[f] + nums[e];
                    if (sum == target) {
                        List<Integer> numsList = new ArrayList<>(4);
                        numsList.add(nums[i]);
                        numsList.add(nums[j]);
                        numsList.add(nums[f]);
                        numsList.add(nums[e]);
                        ret.add(numsList);

                        f++; e--;

                        while (f < e && nums[f] == nums[f - 1]) f++;
                        while (f < e && nums[e] == nums[e + 1]) e--;
                    } else if (sum < target) {
                        f++;
                    } else {
                        e--;
                    }
                }
            }
        }
        return ret;
    }

}
