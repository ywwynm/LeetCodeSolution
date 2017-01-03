import java.util.*;

/**
 * Created by 张启 on 2016/3/26.
 *
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class Solution {

    public static void main(String... args) {
        int[] digits = { 1, 2 };
        int[] ret = myBetter(digits);
        for (int i : ret) {
            System.out.print(i + " ");
        }
    }
    public static int[] plusOne(int[] digits) {
        final int len = digits.length;
        int[] ret = new int[len + 1];
        int add = 1;
        for (int i = len - 1; i >= 0; i--) {
            int res = digits[i] + add;
            if (res > 9) {
                res = res - 10;
                add = 1;
            } else {
                add = 0;
            }
            ret[i + 1] = res;
        }
        if (add != 0) {
            ret[0] = 1;
        } else {
            int[] newRet = new int[len];
            System.arraycopy(ret, 1, newRet, 0, len);
            ret = newRet;
        }
        return ret;
    }

    public static int[] myBetter(int[] digits) {
        final int len = digits.length;
        int[] ret = new int[len];
        int add = 1;
        for (int i = len - 1; i >= 0; i--) {
            int res = digits[i] + add;
            if (res > 9) {
                res = res - 10;
                add = 1;
                ret[i] = res;
            } else {
                System.arraycopy(digits, 0, ret, 0, i);
                ret[i] = res;
                return ret;
            }
        }
        int[] newRet = new int[len + 1];
        System.arraycopy(ret, 0, newRet, 1, len);
        newRet[0] = 1;
        return newRet;
    }

}
