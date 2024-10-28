package a.array;
public class BinarySearchArrSorted {
    // Returns the index of target in the sorted array nums, or -1 if not found
    public static int binarySearch(int[] nums, int targetNumber) {
        int left = 0;
        int right = nums.length - 1;

        int count=0;
        int finNum=0;
        while (left <= right) {
        	count++;
        	//int[] nums = {1, 3, 5, 7, 9, 11, 13, 15};
        	//DK mid calculation is imp for every time  
             int mid = (left +  right)/ 2;
            // If the target is found at mid, return mid
            if (nums[mid] == targetNumber) {
            	finNum= mid;
            	break;
            }
            // If target is greater than the middle element, ignore left half
            else if (nums[mid] < targetNumber) {
                left = mid + 1;
            }
            // If target is less than the middle element, ignore right half
            else { // DK if (nums[mid] > target)
                right = mid - 1;
            }
        }
        System.out.println("count : " + count);
        // Target not found in the array
        return finNum>0 ? finNum : -1;
    }

    public static void main(String[] args) {
    	//DK arrray should be sorted 
        //int[] nums = {1, 3, 5, 7, 9, 11, 13, 15};
        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) {
        	nums[i] = i + 1;
        }
        
        int target = 999;
        int result = binarySearch(nums, target);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
