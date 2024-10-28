package a.array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubsetCheck {

    // Function to check if arr1[] is a subset of arr2[]
    public static boolean isSubset(int[] arr1, int[] arr2) {
        // Create a HashSet and add all elements of arr2 to it
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr2) {
            set.add(num);
        }

        // Check if each element of arr1 is present in the set
        for (int num : arr1) {
            if (!set.contains(num)) {
                return false; // If any element is not found, arr1 is not a subset
            }
        }

        return true; // All elements found, arr1 is a subset
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 7};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        
       // return Collections.indexOfSubList(list, sublist) != -1;
        
        //IntStream is1=  Arrays.stream(arr1).sorted();
        Set<Integer> is1=  Arrays.stream(arr1).sorted().boxed().collect(Collectors.toSet());
        Set<Integer> is2=  Arrays.stream(arr2).sorted().boxed().collect(Collectors.toSet());
        
        boolean b = is2.containsAll(is1);
       
      //  intStream.mapToObj();
        
        boolean result = isSubset(arr1, arr2);

        if (result) {
            System.out.println("arr1 is a subset of arr2");
        } else {
            System.out.println("arr1 is not a subset of arr2");
        }
    }
}
