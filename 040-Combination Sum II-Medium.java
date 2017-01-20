import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by ywwynm on 2017/1/20.
 *
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 */
public class Solution40 {

    public static void main(String... args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;

        List<List<Integer>> ret = combinationSum2(candidates, target);
        for (List<Integer> list : ret) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return recursiveCS2(candidates, 0, target);
    }

    public static List<List<Integer>> recursiveCS2(int[] candidates, int start, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (candidates[i] == target) {
                List<Integer> add = new ArrayList<>(1);
                add.add(target);
                if (set.add(add)) {
                    ret.add(add);
                }
                break;
            }

            if (i + 1 < candidates.length) {
                List<List<Integer>> next = recursiveCS2(
                        candidates, i + 1, target - candidates[i]);
                for (List<Integer> aNext : next) {
                    aNext.add(0, candidates[i]);
                    if (set.add(aNext)) {
                        ret.add(aNext);
                    }
                }
            }

        }
        return ret;
    }

}
