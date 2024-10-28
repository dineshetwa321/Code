package a.string;

public class OccurrenceFirstIndex {

	public static int findFirstOccurrenceIndex(String text, String pattern) {
		// Using indexOf() method to find the index of the first occurrence of pattern
		// in text
		int index = text.indexOf(pattern);

		String subStr =text.substring(index+pattern.length(),text.length());
		int index1stOccur = subStr.indexOf(pattern);
		if(index1stOccur != -1) {
			index = index+ pattern.length() + index1stOccur;
		}
		
		// Returning the index of the first occurrence of pattern in text
		return index1stOccur;
	}

	public static void main(String[] args) {

//Hello, world! This is a sample world text.
		String text = "Hello, world! This is a sample world text.";
		//! This is a sample world text.
		String pattern = "world123";

		int index = findFirstOccurrenceIndex(text, pattern);

		if (index != -1) {
			System.out.println("The index of the first occurrence of '" + pattern + "' in the text is: " + index);
		} else {
			System.out.println("The pattern '" + pattern + "' is not found in the text.");
		}
	}
}