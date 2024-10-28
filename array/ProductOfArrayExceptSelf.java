package a.array;
public class ProductOfArrayExceptSelf {
    
	 public static int[] productExceptSelf(int[] nums) {
	        int n = nums.length;
	        int[] result = new int[n];

	        // Step 1: Calculate left products for each element
	        result[0] = 1;  // There are no elements to the left of the first element
	        for (int i = 1; i < n; i++) {
	            result[i] = result[i - 1] * nums[i - 1];
	        }

	        // Step 2: Calculate right products and multiply with left products
	        int right = 1;  // There are no elements to the right of the last element
	        for (int i = n - 1; i >= 0; i--) {
	            result[i] = result[i] * right;  // Multiply the current result with the right product
	            right = right * nums[i];  // Update the right product
	        }

	        return result;
	    }

	 public static int[] productExceptSelfDK(int[] nums) {
	        int n = nums.length;
	        int[] result = new int[n];

	      // int[] nums = {1, 2, 3, 4};
	     // int[] nums = {1, 2, 3, 4};
	       // int[] nums = {24, 12, 8, 6};
	        // Step 1: Calculate left products for each element
	        result[0] = 1;  // There are no elements to the left of the first element
	        for (int i = 1; i < n; i++) {
	        	 
	            result[i] = result[i-1] *nums[i-1] ;
	        }

	        // Step 2: Calculate right products and multiply with left products
	        int right = 1;  // There are no elements to the right of the last element
	        for (int i = n - 1; i >= 0; i--) {
	            result[i] = result[i] * right;  // Multiply the current result with the right product
	            right = right * nums[i];  // Update the right product
	        }

	        return result;
	    }
	 
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        
        // Output the result array
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
