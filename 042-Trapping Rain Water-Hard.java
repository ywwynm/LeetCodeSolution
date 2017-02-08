/**
 * Created by 张启 on 2017/2/7.
 *
 * 42-Trapping Rain Water-Hard
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Solution42 {

    public static void main(String... args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
//        int[] height = { 4, 2, 3 };
        System.out.println(betterTrap(height));
    }

    /**
     * 我执意于找出每个能存水的区间的开始与结尾，而这个方法则是直接一点一点就把水加了起来
     */
    public static int betterTrap(int[] height) {
        if (height.length < 3) return 0;

        int water = 0;
        int l = 0, r = height.length - 1;

        // find the left and right edge which can hold water
        while (l < r && height[l] <= height[l + 1]) l++;
        while (l < r && height[r] <= height[r - 1]) r--;

        while (l < r) {
            int left = height[l];
            int right = height[r];
            if (left <= right) {
                // add volume until an edge larger than the left edge
                while (l < r && left >= height[++l]) {
                    water += left - height[l];
                }
            } else {
                // add volume until an edge larger than the right volume
                while (l < r && height[--r] <= right) {
                    water += right - height[r];
                }
            }
        }
        return water;
    }

    // 可以过^_^
    public static int trap2(int[] height) {
        int water = 0;
        int i = 0;
        final int n = height.length;
        while (i < n) {
            int c = height[i];
            if (height[i] == 0) {
                i++;
                continue;
            }
            int j = i + 1;
            boolean someNumBetter = false;
            while (j < n) {
                if (height[j] >= c) {
                    someNumBetter = true;
                    break;
                } else j++;
            }
            if (!someNumBetter) {
                height[i]--;
                continue;
            }
            if (i < n && j < n) {
                int lower = Math.min(height[i], height[j]);
                for (int k = i + 1; k < j; k++) {
                    water += lower - height[k];
                }
            }
            i = j;
        }
        return water;
    }

    // 思路不对，过不了
    public static int trap(int[] height) {
        int water = 0;
        int i = 0;
        boolean down = false, up = false;
        int downStart = -1;
        while (i < height.length) {
            int j = i;
            while (j < height.length) {
                if (j + 1 < height.length && height[j] < height[j + 1]) {
                    if (down && (downStart == -1 || height[downStart] <= height[j + 1])) {
                        if (downStart != -1 && height[downStart] > height[j + 1]) {

                        }
                        up = true;
                        down = false;
                        break;
                    }
                    up = true;
                    down = false;
                    j++;
                } else if ((j + 1 < height.length && height[j] > height[j + 1]) || j + 1 >= height.length) {
                    if (up) {
                        if (downStart != -1) {
                            System.out.println(downStart);
                            // start to count water from downStart to j
                            int lower = Math.min(height[downStart], height[j]);
                            for (int k = downStart + 1; k < j; k++) {
                                water += lower - height[k];
                            }
                        }
                        downStart = j;
                        up = false;
                        down = true;
                        break;
                    }
                    up = false;
                    down = true;
                    j++;
                }
            }
            i = j + 1;
        }
        return water;
    }

}
