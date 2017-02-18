import java.util.ArrayList;
import java.util.List;

/**
 * Created by ywwynm on 2017/2/18.
 *
 * 46-Permutations-Medium
 *
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [
 *    [1,2,3],
 *    [1,3,2],
 *    [2,1,3],
 *    [2,3,1],
 *    [3,1,2],
 *    [3,2,1]
 * ]
 */
public class Solution46 {

    public static void main(String... args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> lists = permute(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(nums, ret, new ArrayList<>(), 1);
        return ret;
    }

    private static void helper(int[] nums, List<List<Integer>> ret, List<Integer> list, int step) {
        for (int j = 0; j < nums.length; j++) {
            if (!list.contains(nums[j])) {
                List<Integer> list1 = new ArrayList<>(list);
                list1.add(nums[j]);
                if (step == nums.length) {
                    ret.add(list1);
                } else {
                    helper(nums, ret, list1, step + 1);
                }
            }
        }
    }

}
