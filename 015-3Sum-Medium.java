import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 张启 on 2015/12/1.
 *
 * Given an array S of n integers, are there elements a, b, c in S such
 * that a + b + c = 0? Find all unique triplets in the array which gives
 * the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class Solution {

    public static void main(String... args) {
        long start = System.currentTimeMillis();
        List<List<Integer>> ret = better(new int[]{2,-8,8,6,-14,-12,11,-10,13,
                14,7,3,10,-13,3,-15,7,3,-11,-8,4,5,9,11,7,1,3,13,14,-13,3,-6,-6,
                -12,-15,-12,-9,3,-15,-11,-6,-1,0,11,2,-12,3,-6,6,0,-6,-12,-10,-12,
                6,5,-4,-5,-5,-4,-11,13,5,-2,-13,-3,-7,-15,8,-15,12,-13,0,-3,6,9,
                -8,-6,10,5,9,-11,0,7,-15,-8,-3,-4,-6,7,7,-2,-2,-11,3,0,-6,12,0,
                -13,4,-3,11,-11,1,2,13,8,4,9,-1,-2,5,14,12,5,13,-6,-13,-8,9,1,5,
                -8,-2,-6,-1});
        long end = System.currentTimeMillis();

        for (List<Integer> list : ret) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println((end - start) + "ms");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<int[]> two = twoSum(nums, i + 1, -nums[i]);
            for (int[] pair : two) {
                int fst = nums[pair[0]];
                int sec = nums[pair[1]];
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(fst);
                list.add(sec);
                map.put(list, 1);
            }
        }
        ret.addAll(map.keySet().stream().collect(Collectors.toList()));
        return ret;
    }

    public static List<int[]> twoSum(int[] nums, int from, int target) {
        List<int[]> ret = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = from; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                ret.add(new int[] { index, i });
            }
            map.put(nums[i], i);
        }
        return ret;
    }

    public static List<List<Integer>> better(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        final int len = nums.length;
        for (int i = 0; i <= len - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int f = i + 1;
                int e = len - 1;
                while (f < e) {
                    int sum = nums[i] + nums[f] + nums[e];
                    if (sum == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[f]);
                        list.add(nums[e]);
                        ret.add(list);
                        f++;
                        e--;
                        while (f < e && nums[f] == nums[f - 1]) {
                            f++;
                        }
                        while (f < e && nums[e] == nums[e + 1]) {
                            e--;
                        }
                    } else if (sum < 0) {
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
