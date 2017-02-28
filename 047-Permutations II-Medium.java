import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 张启 on 2017/2/23.
 *
 * 047-Permutations II-Medium
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 *     [1,1,2],
 *     [1,2,1],
 *     [2,1,1]
 * ]
 */
public class Solution47 {

    public static void main(String... args) {
        int[] nums = { 1, 1, 2 };
        List<List<Integer>> lists = permuteUnique(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        helper(ret, numsList, new ArrayList<>());
        return ret;
    }

    private static void helper(List<List<Integer>> ret, List<Integer> nums, List<Integer> toAdd) {
        final int size = nums.size();
        if (size == 0) {
            ret.add(toAdd);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (i > 0 && nums.get(i).equals(nums.get(i - 1))) continue;
            List<Integer> realToAdd = new ArrayList<>(toAdd);
            realToAdd.add(nums.get(i));
            Integer num = nums.remove(i);
            helper(ret, nums, realToAdd);
            nums.add(i, num);
        }
    }

}
