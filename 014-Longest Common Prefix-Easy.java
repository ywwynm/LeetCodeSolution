/**
 * Created by 张启 on 2015/11/25.
 *
 * Write a function to find the longest common prefix string amongst an
 * array of strings.
 */
public class Solution {

    public static void main(String... args) {
        String[] test = { "abd", "abc" };
        System.out.println(longestCommonPrefix(test));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int i = 0;
        int[] lengths = new int[strs.length];
        for (int j = 0; j < strs.length; j++) {
            lengths[j] = strs[j].length();
        }

        while (true) {
            if (i >= lengths[0]) {
                return strs[0];
            }
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= lengths[j]) {
                    return strs[j];
                } else if (c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
    }

    public static String seemsBetter(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            int len = str.length();
            if (minLen > len) {
                minLen = len;
            }
        }
        if (minLen == 0) {
            return "";
        }

        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, minLen);
    }
}
