/**
 * Created by ywwynm on 2017/2/13.
 *
 * 461-Hamming Distance-Easy with 71.1% Acceptance
 *
 * Need to finish today's task so choose this problem _(:з」∠)_
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding
 * bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 */
public class Solution461 {

    public static void main(String... args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        String xStr = Integer.toBinaryString(x);
        String yStr = Integer.toBinaryString(y);
        final int lenX = xStr.length(), lenY = yStr.length();
        int distance = 0;
        int i, j;
        for (i = lenX - 1, j = lenY - 1; i >= 0 || j >= 0; i--, j--) {
            char xC = i >= 0 ? xStr.charAt(i) : '0';
            char yC = j >= 0 ? yStr.charAt(j) : '0';
            if (xC != yC) distance++;
        }
        return distance;
    }

    // not my solution...very elegant
    public static int oneLine(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

}
