package leetcode.sort;

public class 回文字段 {
    public static void main(String[] args) {
        String str = "ADFGBBAAAABBCDB";

        String s = longestPalindrome(str);
        System.out.println(s);
    }

    /**
     * 直接折一半，判断是否相等
     * isPalindromic
     *
     * @param s:
     * @return boolean
     * @author xuegao
     * @date 2023/6/12 15:35
     */
    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双重遍历
     * longestPalindrome
     *
     * @param s:
     * @return java.lang.String
     * @author xuegao
     * @date 2023/6/12 15:35
     */
    public static String longestPalindrome(String s) {
        // 临时存储一个变量，，在最后判断最长的长度
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }

}
