import java.util.HashSet;

class LongestSubsStrNoRepeatQues3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        
        int maxLength = 0; 
        int left = 0; 
        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, remove characters from the left
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add the current character to the set
            set.add(s.charAt(right));
            
            // Update the maxLength if the current window is longer
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        // Return the length of the longest substring without repeating characters
        return maxLength;
    }
    public static void main(String[] args) {
        LongestSubsStrNoRepeatQues3 solution = new LongestSubsStrNoRepeatQues3();
        String test = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(test);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}