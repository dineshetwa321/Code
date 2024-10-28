package a.array.cond;

// Best Leetcode problems for FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986
// Leetcode Link: https://leetcode.com/problems/container-with-most-water/
// Video Solution: https://www.youtube.com/watch?v=wi8fqhNoV-Y


class WaterContainer  {
    public static int maxArea(int[] height) {
         
        height =  new int[] {1,8,6,2,5,4,8,3,7};
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left<right){
            
            int width = Math.min(height[left], height[right]);
            int length = right - left;
            
            max = Math.max(max, width*length);
            
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        
        return max;
        
    }
    
   
    		
    public static void main(String[] args) {

		System.out.println("Area 1 : " + maxArea(null)); // Output: 6
	 

	}
}