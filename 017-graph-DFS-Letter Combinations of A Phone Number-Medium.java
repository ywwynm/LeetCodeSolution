import java.util.*;

/**
 * Created by 张启 on 2015/12/4.
 *
 * Given a digit string, return all possible letter combinations that the
 * number could represent.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution {

    public static void main(String... args) {
        List<String> ret = better("23");
        ret.forEach(System.out::println);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ret;
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', " ");

        String fst = map.get(digits.charAt(0));
        for (int i = 0; i < fst.length(); i++) {
            ret.add(String.valueOf(fst.charAt(i)));
        }

        final int len = digits.length();
        for (int i = 1; i < len; i++) {
            String curChars = map.get(digits.charAt(i));
            final int charsLen = curChars.length();
            int retSize = ret.size();
            for (int j = 0; j < charsLen - 1; j++) {
                for (int k = 0; k < retSize; k++) {
                    ret.add(ret.get(k));
                }
            }

            retSize = ret.size();
            final int T = retSize / charsLen;
            int index = 0;
            for (int k = 0; k < charsLen; k++) {
                char curChar = curChars.charAt(k);
                while (index < T * (k + 1)) {
                    String get = ret.get(index);
                    get += curChar;
                    ret.set(index++, get);
                }
            }
        }

        return ret;
    }

    public static List<String> better(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ret;
        }

        String[] map = { "", "", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz" };
        DFS(map, digits, 0, "", ret);
        return ret;
    }

    private static void DFS(String[] map, String digits, int nodeIndex, String str, List<String> ret) {
        if (nodeIndex == digits.length()) {
            ret.add(str);
            return;
        }

        int index = digits.charAt(nodeIndex) - '0';
        for (int i = 0; i < map[index].length(); i++) {
            DFS(map, digits, nodeIndex + 1, str + map[index].charAt(i), ret);
        }
    }

}
