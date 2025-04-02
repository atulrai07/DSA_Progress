import java.util.ArrayList;
import java.util.List;

class parenthesis22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        Generate(n, 0, 0, list, "");
        return list;
    }

    public static void Generate(int n, int open, int close, List<String> list, String ans) {
        if (open == n && close == n) {
            list.add(ans);
            return;
        }

        if (open < n) { 
            Generate(n, open + 1, close, list, ans + "(");
        }
        
        if (close < open) { 
            Generate(n, open, close + 1, list, ans + ")");
        }
    }

    public static void main(String[] args) {
        parenthesis22 obj = new parenthesis22();
        int n = 3;
        List<String> result = obj.generateParenthesis(n);
        System.out.println("Generated Parentheses for n = " + n + ":");
        for (String s : result) {
            System.out.println(s);
        }
    }
}