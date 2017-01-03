/**
 * Created by 张启 on 2015/11/10.
 * Convert a string to an integer.
 */
public class Solution {

    public static int myAtoi(String str) {
        String numStr = getNumberStr(str.trim());
        try {
            double num = Double.valueOf(numStr);
            if (num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int) num;
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String getNumberStr(String src) {
        if (src.isEmpty()) {
            return "";
        }
        char c0 = src.charAt(0);
        if (c0 != '-' && c0 != '+' && (c0 < '0' || c0 > '9')) {
            return "";
        }
        int length = src.length();
        int index;
        for (index = 1; index < length; index++) {
            char c = src.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }
        }
        return src.substring(0, index);
    }

    public int better(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }
}