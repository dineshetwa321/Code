package a.array.cond;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem Statement
You are given an integer array fruits where each integer represents a type of fruit. 
Your goal is to pick exactly two different types of fruits and collect the maximum amount of 
fruits possible (contiguous subarray). The goal is to return the length of the longest subarray with at most 
two distinct elements.
 */

// https://www.youtube.com/watch?v=Oi09pnLLy78
public class FruitIntoBasketsTUGH {

	public static void main(String[] args) {
		int[] fruits1 = { 1, 2, 1 };
		System.out.println("Maximum fruits in baskets: " + totalFruit(fruits1)); // Output: 3

		int[] fruits2 = { 0, 1, 2, 2 };
		System.out.println("Maximum fruits in baskets: " + totalFruit(fruits2)); // Output: 3

		int[] fruits3 = { 1, 2, 3, 2, 2 };
		System.out.println("Maximum fruits in baskets: " + totalFruit(fruits3)); // Output: 4
	}

	//TODO see Min1WindowSubstringTUGH
	public static int totalFruit(int[] fruits) {
		
		Map<Integer, Integer> fruitCount = new HashMap<>();
		int left = 0;int maxFruits = 0;
		for (int right = 0; right < fruits.length; right++) {
			fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

			while (fruitCount.size() > 2) {
				fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
				if (fruitCount.get(fruits[left]) == 0) {
					fruitCount.remove(fruits[left]);
				}
				left++;
			}//While end

			maxFruits = Math.max(maxFruits, right - left + 1);
		}

		return maxFruits;
	}
}
