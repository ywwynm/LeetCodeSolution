import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ywwynm on 2017/1/19.
 *
 * 39. Combination Sum
 *
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 *   [7],
 *   [2, 2, 3]
 * ]
 */
public class Solution39 {

    public static void main(String... args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 9;
        List<List<Integer>> ret = combinationSum(candidates, target);
        for (List<Integer> list : ret) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return recursiveCS(candidates, 0, target);
    }

    public static List<List<Integer>> recursiveCS(int[] candidates, int start, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (candidates[i] == target) {
                List<Integer> add = new ArrayList<>(1);
                add.add(target);
                ret.add(add);
                break;
            }

            if (target % candidates[i] == 0) {
                int count = target / candidates[i];
                List<Integer> add = new ArrayList<>(count);
                for (int j = 0; j < count; j++) {
                    add.add(candidates[i]);
                }
                ret.add(add);
            }

            if (i + 1 < candidates.length) {
                int nextNum = candidates[i + 1];
                int count = (target - nextNum) / candidates[i];
                for (int j = 1; j <= count; j++) {
                    List<List<Integer>> next = recursiveCS(
                            candidates, i + 1, target - j * candidates[i]);
                    for (List<Integer> aNext : next) {
                        for (int l = 0; l < j; l++) {
                            aNext.add(0, candidates[i]);
                        }
                        ret.add(aNext);
                    }
                }
            }

        }
        return ret;
    }

}
