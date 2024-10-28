package a.array;

public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int n = nums.length + 1; // Length of array + 1
        int totalSum = n * (n + 1) / 2; // Sum of all numbers from 1 to n
        
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num; // Calculate sum of numbers in the array
            //DK below is the bit better 
            totalSum=  totalSum -num;
        }
        return totalSum;
        // The difference between the total sum and array sum is the missing number
        //return totalSum - arraySum;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6}; // Example array with one missing number
        int missingNumber = findMissingNumber(arr);
        System.out.println("The missing number is: " + missingNumber);
    }
}
