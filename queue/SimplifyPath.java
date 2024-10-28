package a.queue;
import java.util.Stack;

public class SimplifyPath {
    
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        // Step 1: Process each component
        for (String dir : components) {
            // Skip if it's empty or the current directory "."
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            }            
            // If it's "..", pop from the stack if possible
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push the current directory onto the stack
                stack.push(dir);
            }
        }

        // Step 2: Build the simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        // If the stack is empty, return "/"
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }

    public static void main(String[] args) {
        // Test case
        String path = "/a/./b//../../c/";
       
       
       // String path = "/.../a/../b/c/../d/./";
        //Output: "/.../b/d";
                
        String result = simplifyPath(path);
        System.out.println("Simplified Path: " + result);
    }
}
