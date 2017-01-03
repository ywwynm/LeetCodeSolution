/**
 * Created by 张启 on 2015/12/5.
 *
 * Given an array and a value, remove all instances of that value in place and 
 * return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond 
 * the new length.
 */
public class Solution {

    public static void main(String... args) {
       int[] nums = { 1, 3, 3, 2 };
       int temp = removeElement(nums, 3);
       for (int num : nums) {
           System.out.print(num + " ");
       }

    }

    public static int removeElement(int[] nums, int val) {
        final int len = nums.length;
        int i = -1, j = 0;
        while (j < len) {
            if (nums[j] == val) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    public static int better(int[] nums, int val) {
    	int i = 0, j = 0;
    	while (j < nums.length) {
    		if (nums[j] != val) {
    			nums[i] = nums[j];
    			i++;
    		}
    		j++;
    	}
    	return i;
    }

}
