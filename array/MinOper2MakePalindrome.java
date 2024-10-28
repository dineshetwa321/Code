package a.array;

//https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/
public class MinOper2MakePalindrome {

    // Function to find the minimum number of operations to make an array palindrome
    public static int findMinOperations(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int operations = 0;

        while (i < j) {
            // If elements are equal, move both pointers inward
            if (arr[i] == arr[j]) {
                i++;
                j--;
            }
            // If the left element is smaller, merge it with the next element
            else if (arr[i] < arr[j]) {
                arr[i + 1] += arr[i];
                i++;
                operations++;
            }
            // If the right element is smaller, merge it with the previous element
            else {
                arr[j - 1] += arr[j];
                j--;
                operations++;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 9, 1};
        
        
        int result = findMinOperations(arr);
        System.out.println("Minimum number of operations to make the array palindrome: " + result);
    }
}
