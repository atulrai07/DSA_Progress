import java.util.Stack;

public class Valid_parenthesis_20 {
    public static void main(String[] args) {
        String s = "([{}])";
        System.out.println(isValid(s)); // Output: true

        s = "([)]";
        System.out.println(isValid(s)); // Output: false

        s = "{[]}";
        System.out.println(isValid(s)); // Output: true
    }
    
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }
}
