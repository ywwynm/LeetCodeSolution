/**
 * Created by 张启 on 2015/11/16.
 *
 * Given a non-negative integer num, repeatedly add all its digits until
 * the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it.
 */
public class Solution {

    public static void main(String... args) {

    }

    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        int n = num;
        while (n != 0) {
            sum += (n % 10);
            n /= 10;
        }
        return addDigits(sum);
    }

    public static int best(int num) {
        return (num - 1) % 9 + 1;
    }
}
