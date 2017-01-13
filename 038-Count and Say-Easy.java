/**
 * Created by ywwynm on 2017/1/13.
 *
 * 38 Count and Say
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        // n > 1
        String last = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        final int len = last.length();
        int i = 0;
        while (i < len) {
            char c1 = last.charAt(i);
            int j = i + 1;
            while (j < len && last.charAt(j) == c1) {
                j++;
            }
            sb.append(j - i).append(c1);
            i = j;
        }
        return sb.toString();
    }

}