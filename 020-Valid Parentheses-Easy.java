import java.util.*;

/**
 * Created by 张启 on 2015/12/2.
 *
 * Given a string containing just the characters '(', ')', '{', '}', 
 * '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" 
 * are all valid but "(]" and "([)]" are not.
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(better("(()"));
    }

    public static boolean isValid(String s) {
        while (true) {
            int len = s.length();
            s = s.replaceAll("\\(\\)|\\[\\]|\\{\\}", "");
            if (s.isEmpty()) {
                return true;
            } else if (s.length() == len) {
                return false;
            }
        }
    }

    public static boolean better(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c == ']' || c == '}') {
                if (!stack.isEmpty() && map.get(stack.peek()).equals(c)) {
                    stack.pop();
                } else return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
