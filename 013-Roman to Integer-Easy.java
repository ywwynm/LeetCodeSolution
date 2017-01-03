/**
 * Created by 张启 on 2015/12/1.
 *
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * 1-I, 5-V, 10-X, 50-L, 100-C, 500-D, 1000-M
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(romanToInt("MCMXCVI"));
    }

    public static int romanToInt(String s) {
        char[] values = s.toCharArray();
        int ret = 0, temp = 0;
        for (char c : values) {
            int num = 0;
            if (c == 'M') {
                num = 1000;
            } else if (c == 'D') {
                num = 500;
            } else if (c == 'C') {
                num = 100;
            } else if (c == 'L') {
                num = 50;
            } else if (c == 'X') {
                num = 10;
            } else if (c == 'V') {
                num = 5;
            } else if (c == 'I') {
                num = 1;
            }
            if (num > temp) {
                ret -= 2 * temp;
            }
            ret += num;
            temp = num;
        }
        return ret;
    }
}
