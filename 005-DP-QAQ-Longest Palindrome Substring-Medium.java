/**
 * Created by 张启 on 2015/11/15.
 * 
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(longestPalindrome2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        String ret = String.valueOf(s.charAt(0));
        for (int i = 0; i < len && len - i > ret.length(); i++) {
            int lastIndex = len + 1;
            String ch = String.valueOf(s.charAt(i));
            for (;;) {
                lastIndex = s.lastIndexOf(ch, lastIndex - 1);
                if (lastIndex == -1 || lastIndex < i - 1) {
                    break;
                }
                String possible = s.substring(i, lastIndex + 1);
                if (isPalindrome(possible) && lastIndex - i + 1 > ret.length()) {
                    ret = possible;
                    break;
                }
            }
        }
        return ret;
    }

    public static boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        if (arr.length <= 1) {
            return true;
        }
        for (int i = 0; i < arr.length / 2 + 1; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * DP
     */
    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        // If xyPal[x][y] is true, then s.substring(x, y + 1) is palindrome.
        boolean[][] xyPal = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            xyPal[i][i] = true;
        }

        boolean firstTwo = true;
        int maxLen = 1;
        int start = 0, end = 0;
        for (int i = 0; i <= len - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                xyPal[i][i + 1] = true;
                if (firstTwo) {
                    maxLen = 2;
                    start = i;
                    end = i + 1;
                    firstTwo = false;
                }
            }
        }

        for (int l = 3; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    xyPal[i][j] = xyPal[i + 1][j - 1];
                    if (xyPal[i][j] && l > maxLen) {
                        maxLen = l;
                        start = i;
                        end = j;
                    }
                } else {
                    xyPal[i][j] = false;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    // There is another way called Manacher's Algorithm, 
    // which is too hard for me to understand.
}