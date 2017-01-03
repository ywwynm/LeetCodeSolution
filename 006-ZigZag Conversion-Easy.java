/**
 * Created by 张启 on 2015/11/6.
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a 
 * given number of rows like this: (you may want to display this pattern 
 * in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given 
 * a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(zigzag("PAYPALISHIRING", 5));
    }

    public static String zigzag(String s, int n) {
        if (s == null || s.isEmpty() || n == 1) {
            return s;
        }
        int length = s.length();
        if (length <= n) {
            return s;
        }

        char[] source = s.toCharArray();
        List<String[]> list = new ArrayList<>();
        int col = 0, p = 0, mod;
        while (p < length) {
            String[] chs = new String[n];
            mod = col % (n - 1);
            if (mod == 0) {
                for (int j = 0; j < n; j++) {
                    if (p + j >= length) {
                        break;
                    }
                    chs[j] = String.valueOf(source[p + j]);
                }
                p += n;
            } else {
                chs[n - mod - 1] = String.valueOf(source[p]);
                p++;
            }
            list.add(chs);
            col++;
        }

        StringBuffer buffer = new StringBuffer();
        for (int k = 0; k < n; k++) {
            for (String[] strings : list) {
                if (strings[k] != null) {
                    buffer.append(strings[k]);
                }
            }
        }

        return buffer.toString();
    }

    // 更好的规律
    public static String better(String s, int n) {
        int length = s.length();
        if (length == 0 || n < 2 || length <= n) {
            return s;
        }
        String result = "";
        int T = 2 * n - 2;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < length; j += T) {
                result += s.charAt(j);

                if (i > 0 && i < n - 1) {
                    int index = j + T - 2 * i;
                    if (index < length) {
                        result += s.charAt(index);
                    }
                }
            }
        }
        return result;
    }

    public static String best(String s, int n) {
        int length = s.length();
        if (length == 0 || length <= n || n <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int T = 2 * n - 2;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int j = i; j < length; j += T) {
                    sb.append(s.charAt(j));
                }
            } else {
                int j = i;
                boolean flag = true;
                int T1 = 2 * (n - 1 - i);
                int T2 = T - T1;

                while (j < length) {
                    sb.append(s.charAt(j));
                    if (flag) {
                        j += T1;
                    } else {
                        j += T2;
                    }
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }

}
