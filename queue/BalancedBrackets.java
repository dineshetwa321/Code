package a.queue;
import java.util.Stack;

public class BalancedBrackets {
    public static boolean isBalanced(String s) {
        // Create a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }// If the character is a closing bracket, check the top of the stack
            else if (c == ')' || c == '}' || c == ']') {
                // If the stack is empty or the top doesn't match, return false
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were balanced, otherwise return false
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()]}";
        if (isBalanced(s)) {
            System.out.println("The string is balanced.");
        } else {
            System.out.println("The string is not balanced.");
        }
    }
}
