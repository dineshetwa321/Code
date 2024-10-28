package a.array;
import java.util.*;

public class FindSum3No {
    public static void main(String[] args) {
        int[] nums = {1, 4, 45, 6, 10, 8};
        int target = 22;

        List<List<Integer>> triplets = findTripletSum(nums, target);
        
        if (triplets != null) {
            System.out.println("The triplet sums to " + target + " are:");
            for (List<Integer> triplet : triplets) {
                System.out.println(triplet);
            }
        } else {
            System.out.println("No triplet sum found.");
        }
    }

    public static List<List<Integer>> findTripletSum(int[] nums, int target) {
       
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        
        //This is very imp to do left++; OR right -- ;
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate elements
            }

            int left = i + 1; // this is for 2nd index
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(triplet);
                    left++;
                    right--;
                     
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result.isEmpty() ? null : result;
    }
}
