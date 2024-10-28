package a.queue;

public class MinimumRemoveToMakeValidParentheses {

    public static String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0;
        // First pass: remove unmatched ')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) {
                    continue; // skip this ')' as it would be unmatched
                }
                open--;
            }
            result.append(c);
        }
        // Second pass: remove unmatched '(' from the end
        StringBuilder finalResult = new StringBuilder();
        int balance = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            char c = result.charAt(i);
            if (c == '(') {
                if (balance == 0) {
                    continue; // skip this '(' as it would be unmatched
                }
                balance--;
            } else if (c == ')') {
                balance++;
            }
            finalResult.append(c);
        }
        // Reverse the final result as we iterated from end to start
        return finalResult.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "lee(t(c)o)de)";
        System.out.println("Result: " + minRemoveToMakeValid(s1)); // Output: "lee(t(c)o)de"

        String s2 = "a)b(c)d";
        System.out.println("Result: " + minRemoveToMakeValid(s2)); // Output: "ab(c)d"

        String s3 = "))((";
        System.out.println("Result: " + minRemoveToMakeValid(s3)); // Output: ""
    }
}
