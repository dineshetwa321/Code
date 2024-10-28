package a.array;

public class SearchWithMaxDiff {

	// https://www.youtube.com/watch?v=KtrAWsfyBaA

	// Function to search key in the array with adjacent elements differing by at
	// most k -DK here max diff will be k or less than k b/w the arr element
	public static int search(int[] arr1, int searcNum, int arrWithMaxDiff) {

		int[] arr = { 2, 4, 5, 7, 7, 6 };
		searcNum = 5;
		arrWithMaxDiff = 2; // this

		int right = arr.length;
		int i = 0;

		while (i < right) {
			// If the current element is equal to the searcNum, return its index
			if (arr[i] == searcNum) {
				return i;
			}

			int moveTo = Math.abs(arr[i] - searcNum) / arrWithMaxDiff; // if abs method not then if else
			// int moveTo = Math.abs(searcNum - arr[i]) / arrWithMaxDiff;
			System.out.println("arr[" + i + "] searcNum moveTo  :" + arr[i] + "-" + searcNum + "/" +arrWithMaxDiff+" :"+ moveTo);
			 
			int move = Math.max(1, Math.abs(arr[i] - searcNum) / arrWithMaxDiff);
			i = i + move;
		}

		// If key is not found, return -1
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 5, 7, 7, 6 };
		int searcNum = 5;
		int arrWithMaxDiff = 2; // this

		int index = search(arr, searcNum, arrWithMaxDiff);

		if (index != -1)
			System.out.println("searcNum found at index: " + index);
		else
			System.out.println("searcNum not found in the array.");
	}

}
