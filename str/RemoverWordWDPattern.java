package a.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoverWordWDPattern {
    
	public static String removeWordbySplit(String sentence, String wordToRemove) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.equals(wordToRemove)) {
                result.append(word).append(" ");
            }
        }

        // Remove the last trailing space if necessary
        return result.toString().trim();
    }
	
    public static String removeWordWDPattern(String input, String wordToRemove) {
        // Create a pattern to match the word to remove
        Pattern pattern = Pattern.compile("\\b" + wordToRemove + "\\b", Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = pattern.matcher(input);
        
        // Replace all occurrences of the word with an empty string
        String result = matcher.replaceAll("");
       
        return result;
    }
    
    public static void main(String[] args) {
        String input = "This is a sample sentence with some words. Let's remove the word 'sample' from this sentence.";
        String wordToRemove = "sample";
        
        String output = removeWordWDPattern(input, wordToRemove);
        
        System.out.println("Original sentence: " + input);
        System.out.println("Sentence after removing the word '" + wordToRemove + "':");
        System.out.println(output);
       
        output = removeWordbySplit(input, wordToRemove);
        System.out.println(output);
        
    }
}
