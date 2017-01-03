/**
* Created by 张启 on 2015/11/14
* Determine whether an integer is a palindrome.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        return isPalindromeStr(String.valueOf(x));
    }
    
    public boolean isPalindromeStr(String s) {
        char[] arr = s.toCharArray();
        if (arr.length <= 1) {
            return true;
        }
        for (int i = 0; i < arr.length / 2 + 1; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}