package a.array;

public class UniqueElement_XORoper {
    public static int findUnique(int[] nums) {
        int unique = 0;
        for (int num : nums) {
            unique  = unique^ num;
            
        }
        return unique;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2,3, 5, 4, 5, 3};
        System.out.println("The unique element is: " + findUnique(nums));
    }

    //DK XOP is noy fun num 
//    public static int findUnique(String[] str) {
//        int unique = 0;
//        for (String num : str) {
//             unique  = unique^ num;
//        }
//        return unique;
//    }
}
