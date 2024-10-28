package a.string;
import java.util.Map;
import java.util.TreeMap;

public class SortStringByTreeMap {
    public static void main(String[] args) {
        String input = "sort this string by word using using treemap";
        
        // Create a TreeMap to store words as keys - DK multile value will be overridedn and ognored here
        Map<String, Integer> wordMap = new TreeMap<>();
        
        // Split the input string into words
        String[] words = input.split(" ");
        
        // Add each word to the TreeMap
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        
        // Create a StringBuilder to build the sorted string
        StringBuilder sortedString = new StringBuilder();
        
        // Iterate over the sorted keys in the TreeMap and append to the StringBuilder
        for (String word : wordMap.keySet()) {
            sortedString.append(word).append(" ");
        }
        
        // Remove the trailing space
        sortedString.setLength(sortedString.length() - 1);
        
        // Print the sorted string
        System.out.println(sortedString.toString());
    }
}
