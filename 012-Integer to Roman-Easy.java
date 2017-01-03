/**
 * Created by 张启 on 2015/11/30.
 *
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * 1-I, 5-V, 10-X, 50-L, 100-C, 500-D, 1000-M
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(intToRoman(1996));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int thousand = num / 1000;
        for (int i = 0; i < thousand; i++) {
            sb.append("M");
        }
        append(sb, (num % 1000) / 100, "M", "D", "C");
        append(sb, (num % 100) / 10, "C", "L", "X");
        append(sb, num % 10, "X", "V", "I");

        return sb.toString();
    }

    public static void append(StringBuilder sb, int num,
                              String ten, String five, String one) {
        if (num == 9) {
            sb.append(one).append(ten);
        } else if (num >= 5) {
            sb.append(five);
            num -= 5;
            for (int i = 0; i < num; i++) {
                sb.append(one);
            }
        } else {
            if (num == 4) {
                sb.append(one).append(five);
            } else {
                for (int i = 0; i < num; i++) {
                    sb.append(one);
                }
            }
        }
    }

    public static String beautiful(int num) {
    	StringBuilder sb = new StringBuilder();  
        String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };    
        int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };   
        for (int i = 0; num != 0; i++ ) {
            while (num >= value[i]) {  
                num -= value[i];
                sb.append(symbol[i]);
            }  
        }  
        return sb.toString(); 
    }

    public static String recursion(int num) {
    	if (num >= 1000) return "M"  + intToRoman(num - 1000);
        if (num >= 900)  return "CM" + intToRoman(num - 900);
        if (num >= 500)  return "D"  + intToRoman(num - 500);
        if (num >= 400)  return "CD" + intToRoman(num - 400);
        if (num >= 100)  return "C"  + intToRoman(num - 100);
        if (num >= 90)   return "XC" + intToRoman(num - 90);
        if (num >= 50)   return "L"  + intToRoman(num - 50);
        if (num >= 40)   return "XL" + intToRoman(num - 40);
        if (num >= 10)   return "X"  + intToRoman(num - 10);
        if (num >= 9)    return "IX" + intToRoman(num - 9);
        if (num >= 5)    return "V"  + intToRoman(num - 5);
        if (num >= 4)    return "IV" + intToRoman(num - 4);
        if (num >= 1)    return "I"  + intToRoman(num - 1);
        return "";
    }

}
