import java.util.*;

/**
 * Created by 张启 on 2015/12/5.
 *
 * Given n pairs of parentheses, write a function to generate all combinations of
 * well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Solution {

    public static void main(String... args) {
        List<String> list = better(4);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        } else if (n == 1) {
            res.add("()");
            return res;
        } else {
            HashMap<String, Integer> map = new HashMap<>();
            List<String> list0 = generateParenthesis(n - 1);
            for (String s : list0) {
                if (map.get("(" + s + ")") == null) {
                    map.put("(" + s + ")", 1);
                    res.add("(" + s + ")");
                }
            }

            for (int i = 1; i < n / 2 + 1; i++) {
                List<String> list1 = generateParenthesis(i);
                List<String> list2 = generateParenthesis(n - i);

                for (String s1 : list1) {
                    for (String s2 : list2) {
                        if (map.get(s1 + s2) == null) {
                            map.put(s1 + s2, 1);
                            res.add(s1 + s2);
                        }

                        if (map.get(s2 + s1) == null) {
                            map.put(s2 + s1, 1);
                            res.add(s2 + s1);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static List<String> better(int n) {
        List<String> res = new ArrayList<>();
        DFS(res, "", n, n);
        return res;
    }

    /**
     * left and right represents the remaining number of "(" and ")" that need to
     * be added. When left > right, there are more ")" placed than "(". Such cases
     * are wrong and the method stops.
     */
    public static void DFS(List<String> list, String s, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }

        if (left > 0) {
            DFS(list, s + "(", left - 1, right);
        }
        if (right > 0) {
            DFS(list, s + ")", left, right - 1);
        }
    }

}
