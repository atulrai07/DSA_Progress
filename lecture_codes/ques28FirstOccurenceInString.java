public class ques28FirstOccurenceInString {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // Edge case: if needle is empty, return 0
        if (m == 0) return 0;

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }

        return -1; 
    }
    public static void main(String[] args) {
        ques28FirstOccurenceInString obj = new ques28FirstOccurenceInString();
        String haystack = "hello";
        String needle = "ll";
        int result = obj.strStr(haystack, needle);
        System.out.println("First occurrence of needle in haystack: " + result); // Output: 2
    }
}