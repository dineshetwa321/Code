package a.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortStringByWordFrequency {
	public static void main(String[] args) {
		String input = "sort this string by word by frequency by word using treemap";

		// Step 1: Count the frequency of each word
		Map<String, Integer> frequencyMap = new HashMap<>(); // new TreeMap<>();
		String[] words = input.split(" ");

		for (String word : words) {
			frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
		}

		// Step 2: Use a TreeMap with a custom comparator to sort by frequency
		TreeMap<String, Integer> sortedByFrequency = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String word1, String word2) {
				int frequencyComparison = frequencyMap.get(word2).compareTo(frequencyMap.get(word1));
				// If frequencies are the same, sort by the natural order of the words
				return frequencyComparison != 0 ? frequencyComparison : word1.compareTo(word2);
			}
		});

		sortedByFrequency.putAll(frequencyMap);

		// Step 4: Build the output string based on frequency
		StringBuilder sortedString = new StringBuilder();
		for (Map.Entry<String, Integer> entry : sortedByFrequency.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				sortedString.append(entry.getKey()).append(" ");
			}
		}

		// Remove the trailing space
		sortedString.setLength(sortedString.length() - 1);

		// Step 5: Print the result
		System.out.println(sortedString.toString());
	}
}
