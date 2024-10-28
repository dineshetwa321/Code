package a.array;

class Rotation_4m_GivenIndex {

// Function to rotate array
	static int[] rotate(int arr[], int index, int n) {
		// Storing rotated version of array
		int temp[] = new int[n];

		//int arr[] = { 1, 7, 2, 5, 3, 4, 5, 6, 9 };
		
		//take one int k =0 and keep increasing for both for loop 
		// logic is 1st starting from index onwards copy to array initial 0
		//Next from initial 0 to index copy to later 
		
		
		// of temp[]
		int k = 0;

		for (int i = index; i < n; i++) {
			temp[k] = arr[i];
			k++;
		}


		for (int i = 0; i < index; i++) {
			temp[k] = arr[i];
			k++;
		}
 
	
		//DDDDD - this is bad 
		
		/* 
		for (i = 0; i<arr.length-index; i++) {			 
			temp[i] = arr[index+i];		 
		}
		System.out.println("i is :"+i);
		System.out.println("arr.length-i is :"+ (arr.length-i));
		for ( int j=0 ;j<arr.length-i ; j++) {
			temp[i+j] = arr[j];
		 
		}
		
		for (int p = 0; p<temp.length; p++) {
			System.out.print(temp[p] + " ");
		}
		*/
		return temp;
	}

// Function to print elements of array
	static void printTheArray(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {

		int arr[] = { 1, 7, 2, 5, 3, 4, 5, 6, 9 };
		int N = arr.length;
		int d = 5;

		// Function calling
		arr = rotate(arr, d, N);

		printTheArray(arr, N);

		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

// This code is contributed by ishankhandelwals.
