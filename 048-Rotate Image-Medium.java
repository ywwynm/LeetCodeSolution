/**
 * Created by ywwynm on 2017/2/20.
 *
 * 048-Rotate Image-Medium
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 *
 */
public class Solution48 {

    public static void main(String... args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        inSpace(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    // This sucks because it uses an another 2-dimension array
    public static void rotate(int[][] image) {
        // i,j -> j, len - i - 1
        final int N = image.length;
        int[][] newImage = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newImage[i][j] = image[N - 1 - j][i];
            }
        }
        for (int i = 0; i < N; i++) {
            System.arraycopy(newImage[i], 0, image[i], 0, N);
        }
    }

    public static void inSpace(int[][] matrix) {
        final int len = matrix.length;
        int times = len % 2 == 0 ? len / 2 : len / 2 + 1;
        for (int i = 0; i < times; i++) { // i
            for (int j = i; j < len - i - 1; j++) {
                // i,j -> j,len-1-i
                int temp1 = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = matrix[i][j];
                int temp2 = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = temp1;
                int temp3 = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = temp2;
                matrix[i][j] = temp3;
            }
        }

    }

}
