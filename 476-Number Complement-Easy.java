/**
 * Created by ywwynm on 2017/2/16.
 *
 * 476-Number Complement-Easy with 60.8 acceptance
 *
 * Given a positive integer, output its complement number. The complement strategy is to flip
 * the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 *
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement
 * is 010. So you need to output 2.
 *
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement
 * is 0. So you need to output 0.
 */
public class Solution476 {

    public static void main(String... args) {
        System.out.println(better(5));
    }

    public static int findComplement(int num) {
        String numBinStr = Integer.toBinaryString(num);
        System.out.println(numBinStr);
        final int len1 = numBinStr.length();
        String cplmBinStr = Integer.toBinaryString(~num);
        final int len2 = cplmBinStr.length();
        cplmBinStr = cplmBinStr.substring(len2 - len1, len2);
        return Integer.parseInt(cplmBinStr, 2);
    }

    /**
     * According to the problem, the result is
     *
     * 1. The flipped version of the original input but
     * 2. Only flip N bits within the range from LEFTMOST bit of 1 to RIGHTMOST.
     * For example input = 5 (the binary representation is 101), the LEFTMOST bit of 1 is the third one
     * from RIGHTMOST (100, N = 3). Then we need to flip 3 bits from RIGHTMOST and the answer is 010
     *
     * To achieve above algorithm, we need to do 3 steps:
     * 1. Create a bit mask which has N bits of 1 from RIGHTMOST. In above example, the mask is 111.
     * And we can use the decent Java built-in function Integer.highestOneBit to get the LEFTMOST bit
     * of 1, left shift one, and then minus one. Please remember this wonderful trick to create bit
     * masks with N ones at RIGHTMOST, you will be able to use it later.
     * 2. Negate the whole input number.
     * 3. Bit AND numbers in step 1 and 2.
     */
    public static int better(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return num & mask;
    }

}
