import java.util.*;

public class longestSubArray_woRepeat {
    public static int lengthOfLongestSubstring(String s) {
        HashMap <Character,Integer> hash = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        int n = s.length();

        for(int r = 0; r < n; r++){
            char ch = s.charAt(r);
            if (hash.containsKey(ch) && hash.get(ch) >= l){
                l = hash.get(ch) + 1;
            }
            hash.put(ch, r);
            maxLen = Math.max(maxLen,(r-l)+1);
        }
        return maxLen;
    }
    public static void main (String[] args){
        String s = "abcabcbb";
        System.out.print(lengthOfLongestSubstring(s));
    }
}
