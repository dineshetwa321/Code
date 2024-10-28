package a.string;

public class ReverseWholeLine {

	public static String reverseString(String str) {
		// Convert the string to a character array
		char[] charArray = str.toCharArray();

		// Initialize pointers for the beginning and end of the array
		int left = 0;
		int right = charArray.length - 1;

		// Swap characters from the beginning and end of the array
		while (left < right) {
			char temp = charArray[left];
			charArray[left] = charArray[right];
			charArray[right] = temp;
			left++;
			right--;
		}

		// Convert the character array back to a string
		return new String(charArray);
	}

	public static void main(String[] args) {
		String original = "Hello Dinesh, How is the world!";
		String reversed = reverseString(original);
		System.out.println("Original string: " + original);
		System.out.println("Reversed string: " + reversed);

		reverseStringStrBuffer(original);
	}

	public static String reverseStringStrBuffer(String str) {

		String[] words = str.split(" ");
		StringBuilder reversed = new StringBuilder();
		StringBuilder reversedStr = new StringBuilder();

		// for (int i = words.length - 1; i >= 0; i--) {
		for (int i = 0; i < words.length; i++) {

			System.out.println("i is :" + i);
			reversed = reversed.append(words[i]);
			System.out.println("reversed is :" + reversed);
			// reversedStr = reversedStr.append(" " + reversed.reverse());

			reversedStr = reversed.reverse().append(" " + reversedStr);

			reversed = new StringBuilder("");

			System.out.println("reversedStr : " + reversedStr.toString());

		}
		return str;
	}
}
