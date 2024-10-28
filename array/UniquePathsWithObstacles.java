package a.array;

//https://leetcode.com/problems/unique-paths-ii/description/
class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length; 
        int col = obstacleGrid[0].length;
                
        // If the start or end is an obstacle, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1) {
            return 0;
        }

        // DP table to store the number of unique paths
        int[][] dp = new int[row][col];
        // Initialize the starting point
        dp[0][0] = 1;

        // Fill the first column
        for (int i = 1; i < row; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i-1][0] == 1) ? 1 : 0;
        }

        // Fill the first row
        for (int j = 1; j < col; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j-1] == 1) ? 1 : 0;
        }

        // Fill the rest of the DP table
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // No paths through an obstacle
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        // The answer is the value in the bottom-right corner
        return dp[row-1][col-1];
    }
    
    public static void main(String[] args) {
        // Read input for the grid
       
        int[][] obstacleGrid = {
        	    {0,0,0},
        	    {0,1,0},
        	    {0,0,0}
        	};
         
        int result = uniquePathsWithObstacles(obstacleGrid);
        
        // Output the result
        System.out.println("The number of unique paths is: " + result);
    }
}
