package a.array.cond;

public class WaterTrappingRain {

	public static void main(String[] args) {

		System.out.println("Area 1 : " + trap()); // Output: 6
		System.out.println("Area 2 : " + trap(1)); // Output: 6
		System.out.println("Area 3 : " + maxAreaGood()); // Output: 6

	}

	public static int maxAreaGood() {
		int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int leftIndex = 0, rightIndex = heights.length - 1, water = 0;
		int maxLeft = heights[leftIndex];
		int maxRight = heights[rightIndex];
		// 6 min good explanation
		// https://www.youtube.com/watch?v=8cqpkCreiwM
		// https://www.youtube.com/watch?v=C8UjlJZsHBw
		int leftHightMax = 0;
		int righthightMax = 0;

		while (leftIndex < rightIndex) {
			leftHightMax = heights[leftIndex];
			righthightMax = heights[rightIndex];

			if (leftHightMax <= righthightMax) {
				// TODO + is very imp here
				leftIndex++;
				maxLeft = Integer.max(maxLeft, heights[leftIndex]); // 0 1
				if (maxLeft - heights[leftIndex] > 0) {

					water = water + (maxLeft - heights[leftIndex]);
				}

			} else {
				// TODO + is very imp here
				rightIndex--;
				maxRight = Integer.max(maxRight, heights[rightIndex]);

				if (maxRight - heights[rightIndex] > 0) {

					water = water + (maxRight - heights[rightIndex]);
				}

			}
		}
		return water;
	}

	// https://www.youtube.com/watch?v=WOO27cP8rN4
	public static int trap(int i) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = height.length;
		int leftIndex = 0;
		int rightIndex = n - 1;
		int maxArea = 0;
		int leftMaxHight = 0;
		int rightMaxHight = 0;

		// https://www.youtube.com/watch?v=IdD9b1TExMg
		while (leftIndex < rightIndex) {

			leftMaxHight = Math.max(leftMaxHight, height[leftIndex]);
			rightMaxHight = Math.max(rightMaxHight, height[rightIndex]);

			if (leftMaxHight < rightMaxHight) {
				maxArea = maxArea + (leftMaxHight - height[leftIndex]);
				leftIndex++;
			} else {
				maxArea = maxArea + (rightMaxHight - height[rightIndex]);
				rightIndex--;
			}
		}

		return maxArea;
	}

	public static int trap() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		if (height == null || height.length == 0) {
			return 0;
		}

		int n = height.length;
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		leftMax[0] = height[0];
		for (int i = 1; i < n; i++) {

			System.out.println("leftMax[i-1] :" + leftMax[i - 1]);
			System.out.println("leftMax[i] :" + leftMax[i]);

			leftMax[i] = Math.max(leftMax[i - 1], height[i]);

			System.out.println("leftMax[i] :" + leftMax[i]);
		}
		System.out.println("leftMax :" + leftMax);
		rightMax[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}

		System.out.println("leftMax :" + rightMax.toString());

		int totalWater = 0;
		for (int i = 0; i < n; i++) {
			totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
		}

		return totalWater;
	}

}
