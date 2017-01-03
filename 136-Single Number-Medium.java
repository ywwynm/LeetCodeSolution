import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by 张启 on 2015/11/17.
 *
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 * Could you implement the algorithm without using extra memory?
 */
public class Solution {

    public static void main(String... args) {
        int[] nums = new int[] { 0, 1, 3, 1, 4, 2, 2, 4, 0 };
        System.out.println(best(nums));
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> single = new HashMap<>();
        for (int num : nums) {
            Boolean b = single.get(num);
            if (b == null) {
                single.put(num, true);
            } else {
                single.put(num, false);
            }
        }

        for (int num : nums) {
            if (single.get(num)) {
                return num;
            }
        }

        return 0;
    }

    public static int singleNumber2(int[] nums) {
        HashSet<Integer> single = new HashSet<>();
        for (int num : nums) {
            if (!single.add(num)) {
                single.remove(num);
            }
        }
        return single.iterator().next();
    }

    public static int best(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        return x;
    }
}
