package a.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElementArray { // Occurence Majority means our of n elemement this element will be n/2+1
									// minimum times in the array
	public static void main(String[] args) {

		int arr[] = { 3, 4, 3, 5, 3, 90, 3, 3 };

		int majorityElement = 0;// findMajorityElement(arr);
		System.out.println("majority element 1 : " + majorityElement);

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + ":");

			if (map.containsKey(new Integer(arr[i]).toString())) {

				int value = map.get(new Integer(arr[i]).toString()) + 1;

				map.put(new Integer(arr[i]).toString(), value);
			} else {
				map.put(new Integer(arr[i]).toString(), 1);
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			System.out.println("entry.getValue() arr.length/2 --> :" + entry.getValue() + " : " + (arr.length / 2));
			// Occurence Majority means out of n elemement this element will be >= n/2+1
			// minimum times in the array
			if (entry.getValue() >= arr.length / 2) {
				System.out.println("majority element 2: " + entry.getKey());
				break;
			}

		}

		majorityElement = findMajorityElementJ8(arr);
		System.out.println("majority element findMajorityElementJ8  : " + majorityElement);

	}

	public static Integer findMajorityElementJ8(int[] arr) {
		// Count frequencies of each element
		Map<Integer, Long> frequencyMap = Arrays.stream(arr).boxed() // Convert int[] to Stream<Integer>
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		int n = arr.length;

		// Find the element that appears more than n/2 times
		return frequencyMap.entrySet().stream().filter(entry -> entry.getValue() > n / 2).map(Map.Entry::getKey)
				.findFirst().orElse(null); // Return null if no majority element is found
	}

}