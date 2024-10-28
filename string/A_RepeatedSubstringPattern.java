package a.string;

//https://leetcode.com/problems/repeated-substring-pattern/description/
//https://algo.monster/liteproblems/459 
public class A_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String modified = doubled.substring(1, doubled.length() - 1);
        return modified.contains(s);
    }

    public static void main(String[] args) {
    	A_RepeatedSubstringPattern solution = new A_RepeatedSubstringPattern();
        
        // Test cases
        System.out.println(solution.repeatedSubstringPattern("abab"));  // Output: true
        System.out.println(solution.repeatedSubstringPattern("aba"));   // Output: false
        System.out.println(solution.repeatedSubstringPattern("abcabcabcabc")); // Output: true
    }
}
