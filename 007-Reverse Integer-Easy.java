/**
 * Created by 张启 on 2015/11/5.
 *
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class Solution {

    public static void main(String... args) {

    }

    public static int reverse(int x) {
        String source = String.valueOf(x);
        StringBuffer buffer;
        if (x < 0) {
            buffer = new StringBuffer(source.substring(1, source.length()));
        } else {
            buffer = new StringBuffer(source);
        }
        String resultStr = buffer.reverse().toString();
        int result = 0;
        try {
            result = Integer.valueOf(resultStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return x < 0 ? result * -1 : result;
    }

    public static int myBetter(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) result;
        }
    }

}
