import java.util.HashMap;

/**
 * Created by 张启 on 2015/11/4.
 * 
 * Given a string, find the length of the longest substring without 
 * repeating characters. For example, the longest substring without 
 * repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(myBetter("ejtdfngsdnnkgpkvtigsq"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int length = s.length(), longestLength = 1, size;
        HashMap<Character, Character> map = new HashMap<>();
        char temp;
        for (int i = 0; i < length; i++) {
            temp = s.charAt(i);
            map.put(temp, temp);
            for (int j = i + 1; j < length; j++) {
                temp = s.charAt(j);
                if (map.get(temp) != null) {
                    break;
                } else {
                    map.put(temp, temp);
                }
            }
            size = map.size();
            if (size > longestLength) {
                longestLength = size;
            }
            map.clear();
        }
        return longestLength;
    }

    public static int myBetter(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int result = 0, length = s.length();

        HashMap<Character, Integer> map = new HashMap<>(26);

        int l = 0, r = 0;
        char c;
        Integer index;
        while (r < length) {
            c = s.charAt(r);
            index = map.get(c);
            if (index != null) {
                result = Math.max(result, r - l);
                for (int i = l; i < index + 1; i++) {
                    map.put(s.charAt(i), null);
                }
                l = index + 1;
            }
            map.put(c, r);
            r++;
        }

        return Math.max(result, r - l);
    }

    public static int best(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int result = 0;
        boolean[] flag = new boolean[256];
        int l = 0;
        char[] arr = s.toCharArray();

        for (int r = 0; r < arr.length; r++) {
            char current = arr[r];
            if (flag[current]) {
                result = Math.max(result, r - l);
                for (int k = l; k < r; k++) {
                    if (arr[k] == current) {
                        l = k + 1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }

        result = Math.max(arr.length - l, result);

        return result;
    }
}