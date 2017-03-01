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
        List<List<Integer>> lists = myBetter(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    // 可以过但是概率不是 100%。。。
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        helper(ret, set, numsList, new ArrayList<>());
        return ret;
    }

    private static void helper(List<List<Integer>> ret, HashSet<List<Integer>> set, List<Integer> nums, List<Integer> toAdd) {
        final int size = nums.size();
        if (size == 0) {
            if (set.add(toAdd)) {
                ret.add(toAdd);
            }
            return;
        }

        for (int i = 0; i < size; i++) {
            List<Integer> realToAdd = new ArrayList<>(toAdd);
            realToAdd.add(nums.get(i));
            Integer num = nums.remove(i);
            helper(ret, set, nums, realToAdd);
            nums.add(i, num);
        }
    }

}
